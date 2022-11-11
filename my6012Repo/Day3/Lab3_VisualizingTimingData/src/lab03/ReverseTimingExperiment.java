package lab03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Collections;

public class ReverseTimingExperiment {

  private static final int ITER_COUNT = 1000;

  public static void main(String[] args) {

    long startTime, stopTime;

    // First, spin computing stuff until one second has gone by.
    // This allows this thread to stabilize.
    startTime = System.nanoTime();
    while (System.nanoTime() - startTime < 1_000_000_000){ // empty block
    }

    // open up a file writer, so we can write to file.
    try (FileWriter fw = new FileWriter(new File("reverse_experiment.tsv"))) {

      for (int exp = 10; exp <= 20; exp++) { // This is used as the exponent to calculate the size of the set.
        int size = (int) Math.pow(2, exp);

        // Do the experiment multiple times, and average out the results
        long totalTime = 0;

        for (int iter = 0; iter < ITER_COUNT; iter++) {

          // SET UP!
          ArrayList<Integer> list = new ArrayList<>();
          for (int i = 0; i < size; i++) {
            list.add(i);
          }

          // TIME IT!
          long start = System.nanoTime();
          Collections.reverse(list);
          long stop = System.nanoTime();
          totalTime += stop - start;
        }

        double averageTime = totalTime / (double) ITER_COUNT;
        System.out.println(size + "\t" + averageTime); // print to console
        fw.write(size + "\t" + averageTime + "\n"); // write to file.
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    Charter charter = new Charter();
    charter.createChart("contains_experiment.tsv", "chart.png");
  }
}
