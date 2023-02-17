//package msd.benjones;

import java.util.HashMap;
import java.util.Set;

public class Router {

    private HashMap<Router, Integer> distances;
    private String name;
    public Router(String name) {
        this.distances = new HashMap<>();
        this.name = name;
    }

    public void onInit() throws InterruptedException {
        //As soon as the network is online,
        //fill in your initial distance table and broadcast it to your neighbors

        // set distance to all routers = infinite
        for( Router r: Network.getRouters() ){
            distances.put(r, Integer.MAX_VALUE);
        }
        // set distance to itself = 0
        distances.put(this, 0);
        // set distance to neighbors = cost
        for( Neighbor n: Network.getNeighbors(this)){
            distances.put(n.router, n.cost);
        }
        // send neighbors
        for( Neighbor n: Network.getNeighbors(this)){
            Network.sendDistanceMessage( new Message(this, n.router, distances));
        }
    }

    public void onDistanceMessage(Message message) throws InterruptedException {
        //update your distance table and broadcast it to your neighbors if it changed

        boolean isChanged = false; // record if the distance to any routers change

        // for all routers
        for( Router r: Network.getRouters() ){
            int Dr = distances.get(message.sender) + message.distances.get(r); // Dr = D_this_sndNeighbor = min ( C_this_snd + D_snd_sndNeighbor )
            // if the distance to r through neighbor is closer, update my distance to r
            if( Dr < distances.get(r) && Dr > 0){ // set Dr > 0 because add on infinity would be negative
                distances.replace(r, Dr);
                isChanged = true;
            }
        }

        if(isChanged){
            // send neighbors
            for( Neighbor n: Network.getNeighbors(this)){
                Network.sendDistanceMessage( new Message(this, n.router, distances));
            }
        }
    }

    public void dumpDistanceTable() {
        System.out.println("router: " + this);
        for(Router r : distances.keySet()){
            System.out.println("\t" + r + "\t" + distances.get(r));
        }
    }

    @Override
    public String toString(){
        return "Router: " + name;
    }
}
