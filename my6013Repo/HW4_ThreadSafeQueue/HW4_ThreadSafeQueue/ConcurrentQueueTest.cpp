#include <stdio.h>
#include <vector>
#include <thread>
#include "ConcurrentQueue.hpp"
#include <iostream>
#include <string>

// counter for dequeueing an empty queue
static std::atomic<int> ct_dequeueEmpty(0);

// enqueue function to be called by thread
void enqueue( ConcurrentQueue<int> &myQueue, int num_ints){
    for(int j = 0; j < num_ints; j++){
        myQueue.enqueue(j);
    }
}

// dequeue function to be called by thread
void dequeue( ConcurrentQueue<int> &myQueue, int num_ints){
    int* ret = new int;
    for(int j = 0; j < num_ints; j++){
        if( !myQueue.dequeue(ret) ){
            ct_dequeueEmpty++;
        }
    }
}


bool testQueue(int num_producers, int num_consumers, int num_ints){
    
    // Create a vector of threads, and reserve space in this vector for all producer and consumer threads.
    int vSize = num_producers + num_consumers;
    std::vector<std::thread> threads(vSize);
    
    // Create a ConcurrentQueue object statically.
    ConcurrentQueue<int> myQueue;
    
    // Create num_producer producer threads that enqueue num_ints ints into the ConcurrentQueue.
    for(int i = 0; i < num_producers; i++){
        threads[i] = std::thread(enqueue, std::ref(myQueue), num_ints);
    }
    
    // Create num_consumer consumer threads that dequeue num_ints ints from the ConcurrentQueue.
    for(int i = num_producers; i < vSize; i++){
        threads[i] = std::thread(dequeue, std::ref(myQueue), num_ints);
    }
    
    // Wait for all threads to join.
    for(int i = 0; i < vSize; i++){
        threads[i].join();
    }
    
    // Returns true if the number of elements in the queue matches.
    if( myQueue.size() == (num_producers - num_consumers ) * num_ints + ct_dequeueEmpty ){
        return true;
    }else{
        return false;
    }

}
