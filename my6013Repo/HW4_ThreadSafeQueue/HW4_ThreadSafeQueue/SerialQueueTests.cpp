#include <stdio.h>
#include "SerialQueue.hpp"
#include <iostream>

void SeriialTest(){
/*
 Static Allocation
 */
    SerialQueue<int> testStc;

    // initial constructor
    if( testStc.size() != 0 )
        throw std::runtime_error("wrong size");
    
    // 1st & 2nd enqueue
    testStc.enqueue(10);
    testStc.enqueue(20);
    
    if( testStc.size() != 2 )
        throw std::runtime_error("wrong size");

    
    int* ret1 = new int;
    
    // 1st dequeue
    if( testStc.dequeue(ret1) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testStc.size() != 1 )
        throw std::runtime_error("wrong size");
    if( *ret1 != 10 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // 2nd dequeue
    if( testStc.dequeue(ret1) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testStc.size() != 0 )
        throw std::runtime_error("wrong size");
    if( *ret1 != 20 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // dequeue empty queue
    if( testStc.dequeue(ret1) != false )
        throw std::runtime_error("wrong return bool for dequeue");
    
    // 3rd enqueue
    testStc.enqueue(30);
    if( testStc.size() != 1 )
        throw std::runtime_error("wrong size");
    
    // 3rd dequeue
    if( testStc.dequeue(ret1) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testStc.size() != 0 )
        throw std::runtime_error("wrong size");
    if( *ret1 != 30 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // dequeue empty queue again
    if( testStc.dequeue(ret1) != false )
        throw std::runtime_error("wrong return bool for dequeue");
    
    
/*
 Dynamic Allocation
 */
    SerialQueue<int>* testDyn = new SerialQueue<int>();

    // initial constructor
    if( testDyn->size() != 0 )
        throw std::runtime_error("wrong size");
    
    // 1st & 2nd enqueue
    testDyn->enqueue(10);
    testDyn->enqueue(20);
    
    if( testDyn->size() != 2 )
        throw std::runtime_error("wrong size");

    
    int* ret = new int;
    
    // 1st dequeue
    if( testDyn->dequeue(ret) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testDyn->size() != 1 )
        throw std::runtime_error("wrong size");
    if( *ret != 10 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // 2nd dequeue
    if( testDyn->dequeue(ret) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testDyn->size() != 0 )
        throw std::runtime_error("wrong size");
    if( *ret != 20 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // dequeue empty queue
    if( testDyn->dequeue(ret) != false )
        throw std::runtime_error("wrong return bool for dequeue");
    
    // 3rd enqueue
    testDyn->enqueue(30);
    if( testDyn->size() != 1 )
        throw std::runtime_error("wrong size");
    
    // 3rd dequeue
    if( testDyn->dequeue(ret) != true )
        throw std::runtime_error("wrong return bool for dequeue");
    if( testDyn->size() != 0 )
        throw std::runtime_error("wrong size");
    if( *ret != 30 )
        throw std::runtime_error("wrong ret for dequeue");
    
    // dequeue empty queue again
    if( testDyn->dequeue(ret) != false )
        throw std::runtime_error("wrong return bool for dequeue");
    
    // deallocation
    testDyn->~SerialQueue();
    
    std::cout << "Serial queue tests passed.\n";
}

