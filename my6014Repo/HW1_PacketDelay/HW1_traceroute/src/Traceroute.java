import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Traceroute {

    // Variables
    ArrayList<String> hopsIP = new ArrayList<>();
    ArrayList<Float> hopsTime = new ArrayList<>();

    /*
    TraceRoute Function
     */
    void traceRoute(String filename) throws FileNotFoundException {
        // Read file
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){

            // For each hop number (if the 1st string of the line is an integer)
            if(sc.hasNextInt()){
                sc.nextInt(); // ignore hop number
                sc.next(); // ignore hop name

                // Save hop IP ( split )
                String ip = sc.next();
                if( !ip.equals("*") ){
                    ip = ip.substring(ip.indexOf("(")+1,ip.indexOf(")"));
                }
                hopsIP.add(ip);

                // Save average time for the same hop
                float time = 0;
                int timeCount = 0;
                while( !sc.hasNextInt() ){ // if it's not the next hop

                    if(sc.hasNextFloat()){
                        time += sc.nextFloat(); // add all times for this hop
                        timeCount++;
                    }else if(sc.hasNext()){
                        sc.next(); // keep searching time for this hop
                    }else{
                        break; // stop searching time if there's no string for this hop
                    }
                }
                hopsTime.add(time/timeCount); // save average delay time for this hop
            }
        }

        // Print out to check answer
//        for(int i = 0; i < hopsIP.size(); i++ ){
//            System.out.println("Hop#" + (i+1) + ", IP: " + hopsIP.get(i) + ", delay: " + hopsTime.get(i));
//        }

        // Write file
        PrintWriter pw = new PrintWriter( new FileOutputStream( "Results_" + filename ) );
        for(int i = 0; i < hopsIP.size(); i++){
            pw.println( hopsIP.get(i) + " " + hopsTime.get(i) );
        }
        sc.close();
        pw.close();

    }

}
