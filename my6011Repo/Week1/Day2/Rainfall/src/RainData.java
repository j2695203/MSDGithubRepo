import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class EachLine{         // can't be public class cause dif name with filename ??
    public String month;
    public Integer year;
    public Double rfAmount;
}

public class RainData {
    /*
     VARIABLES
     */
    private ArrayList<EachLine> raindatas = new ArrayList<>();
    public ArrayList<String> allMonths = new ArrayList<>( Arrays.asList( // to avoid FOR loop too many times
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
    )
    );
    public ArrayList<Double> rfPerMonth = new ArrayList<Double>( Arrays.asList(  // to save average rainfall value per month
            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    )
    );
    public ArrayList<Integer> countPerMonth = new ArrayList<Integer>( Arrays.asList(  // to count average value
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    )
    );

    /*
     METHODS
     */
    // constructor
    public RainData(String filename) throws IOException {
        File file = new File(filename);  // open file
        Scanner sc = new Scanner(file);

        String city = sc.nextLine();
        while(sc.hasNext()){
            EachLine eachLine = new EachLine();
            eachLine.month = sc.next();
            eachLine.year = sc.nextInt();
            eachLine.rfAmount = sc.nextDouble();
            raindatas.add(eachLine);       // save eachLine data in arrayList
        }
    }

    // compute average rainfall for each month
    public void compute(){

        for (EachLine el: raindatas){                                   // for each data (240)
            for (int i = 0; i < 12; i++){                               // for each month (12)
                if ( allMonths.get(i).equals(el.month) ){
                    countPerMonth.set(i, countPerMonth.get(i) + 1 );    // count how many times saving data for the same month
                    rfPerMonth.set(i, rfPerMonth.get(i) + el.rfAmount); // sum of rf value per month
                    break;
                }
            }
        }

        for (int i = 0; i < 12; i++){
            rfPerMonth.set(i, rfPerMonth.get(i) / countPerMonth.get(i)); // average of rf value per month
        }

    }

    // write the result to a file
    public void writeFile() throws IOException {
        DecimalFormat d = new DecimalFormat("0.00");  // for formatted double
        PrintWriter pw = new PrintWriter( new FileOutputStream( "rainfall_results.txt" ) );
        for(int i = 0; i < 12; i++){
            pw.println("The average rainfall amount for "+ allMonths.get(i) + " is "+ d.format(rfPerMonth.get(i) ) + " inches.");
        }
        pw.close();
    }

}
