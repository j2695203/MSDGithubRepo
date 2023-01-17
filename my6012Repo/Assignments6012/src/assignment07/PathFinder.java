package assignment07;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {
    static Graph graph_;
    static ArrayList<Graph.Node> route_ = new ArrayList<>();

    public static void solveMaze(String inputFile, String outputFile) throws IOException {
        // create graph according to input file
        graph_ = new Graph(inputFile);

        // create queue for BFS
        Queue<Graph.Node> queue = new LinkedList<>();

        // search from starting point
        queue.add(graph_.start_);

        // keep BFS until goal point found
        while( !queue.isEmpty() ){

            Graph.Node node = queue.remove();
            // goal found
            if( node.data_.equals(graph_.goal_.data_) ){
                // track the route and draw dots on graph
                trackRoute(node);
                break;
            }
            // search neighbors
            for( Graph.Node neighbor: node.neighbors_ ){
                if( !neighbor.visited_ ){
                    neighbor.visited_ = true;
                    neighbor.cameFrom_ = node;
                    queue.add(neighbor);
                }
            }
        }

        // output the layout with route
        writeFile(outputFile);
    }

    /**
     * Recursively tracking the route from goal to start, and save these nodes in ArrayList.
     * @param node the node started to track their previous node.
     */
    private static void trackRoute(Graph.Node node){
        // base case: stop recursive
        if( node.cameFrom_ == null ){ return;}
        // draw a dot to graph
        if( node.data_.equals(" ")){ node.data_ = ".";}
        // add the node to route
        route_.add(node.cameFrom_);
        // keep tracking previous node
        trackRoute(node.cameFrom_);
    }

    /**
     * Output the same layout of the graph, and replace some spaces
     * (the minimum route from S to G) as dot characters.
     * @param filename name of an output file
     * @throws IOException if fails on writing file
     */
    private static void writeFile(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename);
        // write dimension
        myWriter.write (graph_.height_ + " " + graph_.width_ + "\n");
        // write the maze
        for( int i = 0; i < graph_.height_; i++ ){
            for( int j = 0; j < graph_.width_; j++ ){
                myWriter.write(graph_.maze_[i][j].data_ );
            }
            myWriter.write("\n");
        }
        myWriter.close();
    }

}
