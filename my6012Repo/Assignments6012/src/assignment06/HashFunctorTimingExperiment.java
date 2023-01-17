package assignment06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static assignment06.ChainingHashTableTest.getRandomString;

public class HashFunctorTimingExperiment {
    private static final int ITER_COUNT = 1000;

    public static void main(String[] args) {

        long startTime, stopTime;
//        int tableCapacity = 3581;

        // First, spin computing stuff until one second has gone by.
        // This allows this thread to stabilize.
        startTime = System.nanoTime();
        while (System.nanoTime() - startTime < 1_000_000_000){ // empty block
        }

        // initialize constructors
        HashFunctor badHash = new BadHashFunctor();
        HashFunctor medHash = new MediocreHashFunctor();
        HashFunctor goodHash = new GoodHashFunctor();

//        ChainingHashTable tableBad = new ChainingHashTable(tableCapacity,badHash);
//        ChainingHashTable tableMed = new ChainingHashTable(tableCapacity,medHash);
//        ChainingHashTable tableGood = new ChainingHashTable(tableCapacity,goodHash);

        // This is used as the exponent to calculate the size of the set.
        for (int exp = 10; exp <= 20; exp++) {
            int size = (int) Math.pow(2, exp);

            // Do the experiment multiple times, and average out the results
            long totalTime = 0;
            for (int iter = 0; iter < ITER_COUNT; iter++) {

                // SET UP!
                // create a random string with specific size
                String str = getRandomString(size);

                // TIME IT!
                long start = System.nanoTime();
                badHash.hash(str); // testing objective
                long stop = System.nanoTime();
                totalTime += stop - start;

            }

            double averageTime = totalTime / (double) ITER_COUNT;
            System.out.println(size + "\t" + averageTime); // print to console
        }


    }

}
