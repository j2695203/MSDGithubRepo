#include <iostream>
#include "SerialQueue.hpp"
#include "ConcurrentQueue.hpp"

void SeriialTest();

bool testQueue(int num_producers, int num_consumers, int num_ints);

int main(int argc, char **argv) {
    
    // Test Serial Queue
    SeriialTest();
    
    // Test Concurrent Queue
    if( argc == 4 ){
        // read command line
        int num_producers = std::stoi(argv[1]);
        int num_consumers = std::stoi(argv[2]);
        int num_ints = std::stoi(argv[3]);
        
        // call testQueue and check return value
        if(testQueue(num_producers, num_consumers, num_ints)){
            std::cout << "Concurrent queue tests passed. \n";
        }else{
            std::cout << "Concurrent queue tests failed. \n";
        }
    }
    return 0;
}
