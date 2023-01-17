package assignment07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Use Node[][] to represent a graph, it includes Node class
 */
public class Graph {
    Node[][] maze_;
    Node start_, goal_;
    int height_, width_;

    public class Node {
        String data_;
        int row_; // index y
        int col_; // index x
        boolean visited_;
        Node cameFrom_ = null; // track previous node on route
        ArrayList<Node> neighbors_ = new ArrayList<>(); // neighbors nodes (at most 4)

        public Node(int row, int col, String data, boolean visited) {
            row_ = row;
            col_ = col;
            data_ = data;
            visited_ = visited;
        }

        public void buildNeighbors(int row, int col){
            // right
            if( isValid(row,col-1)){
                neighbors_.add(maze_[row][col-1]);
            }
            // left
            if( isValid(row,col+1)){
                neighbors_.add(maze_[row][col+1]);
            }
            // up
            if( isValid(row-1,col)){
                neighbors_.add(maze_[row-1][col]);
            }
            // down
            if( isValid(row+1,col)){
                neighbors_.add(maze_[row+1][col]);
            }
        }
    }

    // Graph constructor
    public Graph(String filename) throws FileNotFoundException {

        FileReader mazeFile = new FileReader(filename);
        Scanner sc = new Scanner(mazeFile);

        // read dimensions
        String[] dimensions = sc.nextLine().split(" ");
        height_ = Integer.parseInt(dimensions[0]);
        width_ = Integer.parseInt(dimensions[1]);

        // read maze data and save in maze_
        maze_ = new Node[height_][width_];

        for( int i = 0; i < height_; i++ ){
            String[] line = sc.nextLine().split("");

            for( int j = 0; j < width_; j++ ){
                String data = line[j];
                Node node;

                // if it's start point, save the node
                if( data.equals("S") ){
                    node = new Node(i,j,data,true);
                    start_ = node;
                }
                // if it's end point, save the node
                else if( data.equals("G") ){
                    node = new Node(i,j,data,false);
                    goal_ = node;
                }
                // if it's wall, mark as visited
                else if( data.equals("X") ){
                    node = new Node(i,j,data,true);
                }
                // open space
                else{
                    node = new Node(i,j,data,false);
                }
                maze_[i][j] = node;
            }
        }
        sc.close();

        // build up neighbors for every node
        for( int i = 0; i < height_; i++ ){
            for( int j = 0; j < width_; j++ ){
                maze_[i][j].buildNeighbors(i,j);
            }
        }
    }

    /**
     * Given a pair of index. If the index is within the range, and a node of this index is not a wall,
     * then return true that a node of this index could be a neighbor node.
     * @param row row of a potential neighbor node
     * @param col column of a potential neighbor node
     * @return true if it could be a neighbor node
     */
    public boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < height_ && col < width_ && !maze_[row][col].data_.equals("X");
    }

    /**
     * Print out the maze to check.
     */
    public void printGraph(){
        // print to check the maze
        for( int i = 0; i < height_; i++ ){
            for( int j = 0; j < width_; j++ ){
                System.out.print(maze_[i][j].data_);
            }
            System.out.println();
        }
        System.out.println();
    }
}
