package lab03;

import assignment03.BinarySearchSet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FindPositionTimingExperiment {
    private static final int ITER_COUNT = 100;

    public static void main(String[] args) {

        long startTime, stopTime;

        // First, spin computing stuff until one second has gone by.
        // This allows this thread to stabilize.
        startTime = System.nanoTime();
        while (System.nanoTime() - startTime < 1_000_000_000){ // empty block
        }

        // open up a file writer, so we can write to file.
        try (FileWriter fw = new FileWriter(new File("findPosition_experiment.tsv"))) {
            Random random = new Random();
            for (int exp = 10; exp <= 21; exp++) { // This is used as the exponent to calculate the size of the set.
                int size = (int) Math.pow(2, exp);

                // Do the experiment multiple times, and average out the results
                long totalTime = 0;



                    // SET UP!
                    BinarySearchSet<Integer> set_integer = new BinarySearchSet<>();
                    for( int i = 0; i < size; i++){
                        set_integer.add(i*10);
                    }
                for (int iter = 0; iter < ITER_COUNT; iter++) {
                    // search for a random integer to be added
                    int goal = random.nextInt(size)*10 + 1; // +1 to avoid add the same value in the 10-times-set

                    // TIME IT!
                    long start = System.nanoTime();
                    set_integer.add(goal);
                    long stop = System.nanoTime();
                    totalTime += stop - start;
                    set_integer.remove(goal);
                }

                double averageTime = (totalTime / (double) ITER_COUNT)/1000; // convert ns to ms
                System.out.println(size + "\t" + averageTime); // print to console
                fw.write(size + "\t" + averageTime + "\n"); // write to file.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Charter charter = new Charter();
        charter.createChart("findPosition_experiment.tsv", "findPositionChart.png");
    }
}
