import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ping {

    // Variables
    int packetCount = 0;
    int totalTime = 0;

    /*
    Ping delay time Function
     */
    void pingDelay(String filename) throws FileNotFoundException {
        // Read file
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        int packetCount = 0;
        double eachTime = 0;
        double cumulatedTime = 0;
        double minTime = 100000;

        while(sc.hasNextLine()){
            // read each line
            String line = sc.nextLine();
            // parse string which is avg time, and convert string to double
            if(line.contains("time=")){
                eachTime = Double.parseDouble(line.substring(line.indexOf("time=")+5,line.indexOf("time=")+12));
                if( eachTime < minTime ){
                    minTime = eachTime;
                }
                cumulatedTime += eachTime;
                packetCount++;
            }
        }
        // calculate avg queuing time
        System.out.println("Avg queuing delay: " + (cumulatedTime/packetCount - minTime));
        sc.close();
    }
}
