#include <chrono>
#include <iostream>
#include "timeTest.h"
#include "myMalloc.h"

void testAllocateTime(){

    std::cout << "[ Time for Allocate different times] \n";

    int allocateIterator = 200000;

    // This allows this thread to stabilize.
    int n = 0;
    while ( n < 100000){ // empty block
        n++;
    }

    for(int allocateTimes = 1; allocateTimes < allocateIterator; allocateTimes *= 2 ){

        // SET UP!
        myMalloc m;
        int allocateIter = 0;

        // TIME IT!
        long totalTime = 0;

        // start allocate
        for(int i = 0; i < allocateTimes; i++ ){
            auto start = std::chrono::high_resolution_clock::now();

            // Test Object: Choose "m.allocate" or "malloc" here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            m.allocate(10);
//            malloc(10);

            auto stop = std::chrono::high_resolution_clock::now();
            auto duration = std::chrono::duration_cast<std::chrono::nanoseconds> (stop - start);
            totalTime += duration.count();
        }
        std::cout << allocateTimes << "\t" << totalTime << "\n";
    }

}

void testDeallocateTime(){

    std::cout << "[ Time for Deallocate different times] \n";

    int allocateIterator = 200000;

    // This allows this thread to stabilize.
    int n = 0;
    while ( n < 100000){ // empty block
        n++;
    }

    for(int deallocateTimes = 1; deallocateTimes < allocateIterator; deallocateTimes *= 2 ){

        // SET UP!
        myMalloc m;
        int allocateIter = 0;

        // allocate first
        void* addresses[deallocateTimes];
        for(int i = 0; i < deallocateTimes; i++ ){

            // Test Object: Choose "m.allocate" or "malloc" here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            addresses[i] = m.allocate(10);
//            addresses[i] = malloc(10);

        }

        // TIME IT!
        long totalTime = 0;

        // start deallocate
        for(int i = 0; i < deallocateTimes; i++ ){
            auto start = std::chrono::high_resolution_clock::now();

            // Test Object: Choose "m.deallocate" or "free" here (should be consistent with allocate) !!!!!!!!!!!!!

            m.deallocate(addresses[i]);
//            free(addresses[i]);

            auto stop = std::chrono::high_resolution_clock::now();
            auto duration = std::chrono::duration_cast<std::chrono::nanoseconds> (stop - start);
            totalTime += duration.count();
        }
        std::cout << deallocateTimes << "\t" << totalTime << "\n";
    }
}
