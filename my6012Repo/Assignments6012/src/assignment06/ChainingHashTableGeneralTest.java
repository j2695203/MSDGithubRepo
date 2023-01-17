package assignment06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static assignment06.ChainingHashTableTest.getRandomString;

public class ChainingHashTableGeneralTest {
//    private static final int ITER_COUNT = 1000;

    @Test
    void testHashFunctionTime(){

        int ITER_COUNT = 1000;
        long startTime;

        // First, spin computing stuff until one second has gone by.
        // This allows this thread to stabilize.
        startTime = System.nanoTime();
        while (System.nanoTime() - startTime < 1_000_000_000){ // empty block
        }

        // initialize constructors
        HashFunctor badHash = new BadHashFunctor();
        HashFunctor medHash = new MediocreHashFunctor();
        HashFunctor goodHash = new GoodHashFunctor();

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
                medHash.hash(str); // testing objective
                long stop = System.nanoTime();
                totalTime += stop - start;

            }

            double averageTime = totalTime / (double) ITER_COUNT;
            System.out.println(size + "\t" + averageTime); // print to console
        }
    }

    @Test
    void testCollisionTime(){
        int tableCapacity = 10007;
        int strLength = 50;
        int ITER_COUNT = 100;

        // initialize constructors
        HashFunctor badHash = new BadHashFunctor();
        HashFunctor medHash = new MediocreHashFunctor();
        HashFunctor goodHash = new GoodHashFunctor();

        // This is used as the exponent to calculate the size of the set.
        for (int entries = 1; entries < tableCapacity; entries+=1000 ) {


            // Do the experiment multiple times, and average out the results
            int badTotalCollision = 0;
            int medTotalCollision = 0;
            int goodTotalCollision = 0;

            for (int iter = 0; iter < ITER_COUNT; iter++) {
                ChainingHashTable tableBad = new ChainingHashTable(tableCapacity,badHash);
                ChainingHashTable tableMed = new ChainingHashTable(tableCapacity,medHash);
                ChainingHashTable tableGood = new ChainingHashTable(tableCapacity,goodHash);
                // create random strings with specific size
                String str;
                ArrayList<String> randomStrings = new ArrayList<>();
                for( int i = 0; i < entries; i++ ){
                    str = getRandomString(strLength);
                    randomStrings.add(str);
                }

                // add the random strings to tables with different hash function
//                tableBad.addAll(randomStrings);
                tableMed.addAll(randomStrings);
//                tableGood.addAll(randomStrings);

//                badTotalCollision += tableBad.collisionTime();
                medTotalCollision += tableMed.collisionTime();
//                goodTotalCollision += tableGood.collisionTime();

            }
//            double badAverageCollision = badTotalCollision / (double) ITER_COUNT;
            double medAverageCollision = medTotalCollision / (double) ITER_COUNT;
//            double goodAverageCollision = goodTotalCollision / (double) ITER_COUNT;

//            System.out.println(entries + "\t" + badAverageCollision + "\t" + medAverageCollision + "\t" + goodAverageCollision); // print to console
            System.out.println(entries + "\t" + medAverageCollision ); // print to console
        }
    }

    @Test
    void testContainTime(){
        long startTime;
        int tableCapacity = 10007;
        int strLength = 30;
        int ITER_COUNT = 1000;
        Random random = new Random();

        // First, spin computing stuff until one second has gone by.
        // This allows this thread to stabilize.
        startTime = System.nanoTime();
        while (System.nanoTime() - startTime < 1_000_000_000){ // empty block
        }

        // initialize constructors
        HashFunctor badHash = new BadHashFunctor();
        HashFunctor medHash = new MediocreHashFunctor();
        HashFunctor goodHash = new GoodHashFunctor();

        // This is used as the exponent to calculate the size of the set.
        for (int entries = 1; entries < tableCapacity; entries += 1000) {

            // Do the experiment multiple times, and average out the results
            long totalTime = 0;

            // SET UP!
            ChainingHashTable tableBad = new ChainingHashTable(tableCapacity,badHash);
            ChainingHashTable tableMed = new ChainingHashTable(tableCapacity,medHash);
            ChainingHashTable tableGood = new ChainingHashTable(tableCapacity,goodHash);

            // create random strings with specific size
            String str;
            ArrayList<String> randomStrings = new ArrayList<>();
            for( int i = 0; i < entries; i++ ){
                str = getRandomString(strLength);
                randomStrings.add(str);
            }

            tableBad.addAll(randomStrings); // testing objective
//            tableMed.addAll(randomStrings); // testing objective
//            tableGood.addAll(randomStrings); // testing objective


            for (int iter = 0; iter < ITER_COUNT; iter++) {
                // random string
//                String strFind = randomStrings.get(random.nextInt(entries));
                String strFind = getRandomString(strLength); // testing objective: add

                // TIME IT!
                long start = System.nanoTime();
                tableBad.add(strFind); // testing objective
//                tableMed.add(strFind); // testing objective
//                tableGood.add(strFind); // testing objective
                long stop = System.nanoTime();

//                tableGood.add(strFind); // testing objective: remove
                tableBad.remove(strFind); // testing objective: add

                totalTime += stop - start;

            }

            double averageTime = totalTime / (double) ITER_COUNT;
            System.out.println(entries + "\t" + averageTime); // print to console
        }
    }

}
