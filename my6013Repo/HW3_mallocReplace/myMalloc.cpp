//
// Created by Jinny Jeng on 3/16/23.
//

#include <cstdio>
#include <map>
#include <sys/mman.h>
#include "myMalloc.h"

/*
 * Constructor
 */
myMalloc::myMalloc() {
    _tableCapacity = 5; // whatever
    _tableSize = 0;
    _hashTable = static_cast<TableNode *>(mmap(nullptr, _tableCapacity * sizeof(TableNode), PROT_READ | PROT_WRITE, MAP_ANON | MAP_PRIVATE, -1, 0));
}

/*
 * Destructor
 */
myMalloc::~myMalloc() {
    // call munmap(), check system call
    if( munmap(_hashTable, sizeof(TableNode) * _tableCapacity) == -1 ){
        throw std::runtime_error("munmap failed");
    }
    _hashTable = nullptr;
    _tableCapacity = 0;
    _tableSize = 0;
}

/*
 * allocate: call mmap() to allocate memory
 */
void *myMalloc::allocate(size_t bytesToAllocate) {

    // round up the allocation size to the next multiple of the page size
    size_t pageSize = 4096;
    size_t len = ((bytesToAllocate + pageSize - 1) / pageSize) * pageSize;

    // allocate memory with mmap, and check system call
    void* addr = mmap(nullptr, len, PROT_READ | PROT_WRITE, MAP_ANON | MAP_PRIVATE, -1, 0);
    if( addr == MAP_FAILED ){
        throw std::runtime_error("mmap failed");
    }

    // insert the returned pointer and the allocation size in the hash table
    updateHashTable(addr, len);
    return addr;
}

/*
 * updateHashTable: grow table size (if needed) and add elements into table
 */
void myMalloc::updateHashTable(void* addr, size_t len){

    // resize and rehash if load factor >= 0.8
    if( _tableSize * 1.0 / _tableCapacity >= 0.8 ){
        growHashTable();
    }
    // add nodes to hash table
    TableNode node;
    node.addr = addr;
    node.size = len;
    node.lazyDelete = false;
    addToHashTable(node);
}

/*
 * find next prime: return a next prime number for growing hash table capacity
 */
int findNextPrime(int input){
    bool isPrime = true;

    // if input can be divided by i, input is not a prime number
    for( int i = 2; i < input; i++){
        if( input % i == 0 ){
            isPrime = false;
            break;
        }
    }
    // return input if it is a prime number
    if( isPrime ){
        return input;
    }
    // else keep finding the next prime number
    return findNextPrime(input+1);
}

/*
 * grow HashTable
 */
void myMalloc::growHashTable(){
    // resize
    int oldCapacity = _tableCapacity;
    _tableCapacity = findNextPrime(_tableCapacity*2);
    _tableSize = 0;

    // rehash
    TableNode* oldHashTable = _hashTable;
    _hashTable = static_cast<TableNode *>(mmap(nullptr, _tableCapacity * sizeof(TableNode), PROT_READ | PROT_WRITE, MAP_ANON | MAP_PRIVATE, -1, 0));

    // check system call
    if( _hashTable == MAP_FAILED ){
        throw std::runtime_error("mmap failed");
    }

    // (add nodes from old table to new table)
    for( int i = 0; i < oldCapacity; i++ ){
        if( oldHashTable[i].addr != nullptr && !oldHashTable[i].lazyDelete ){
            addToHashTable( oldHashTable[i] );
        }
    }
}

/*
 * hash functor: hash addr to get the index of table
 */
unsigned long myMalloc::hashFunctor(void *addr) {
    unsigned long hash = 0;
    for (int i = 0; i < 10 ; i++) {
        hash = (unsigned long) addr + (hash << 5) + hash;
    }
    return hash % _tableCapacity;
}

/*
 * Add to hash table: add the node into hash table, and use linear probing when collision happens
 */
void myMalloc::addToHashTable(TableNode node){
    // hash index
    unsigned long index = hashFunctor(node.addr);
    // linear probing
    while(true){
        // add if there's no item (or lazy delete) in this position
        if( _hashTable[index].addr == nullptr || (_hashTable[index].addr != nullptr && _hashTable[index].lazyDelete) ){
            _hashTable[index] = node;
            _tableSize++;
            break;
        }else{
            index = (index + 1) % _tableCapacity;
        }
    }
}

/*
 * Deallocate
 */
void myMalloc::deallocate(void *ptr) {
    // find the address pointer in the hash table
    int index = findIndex(ptr);
    _hashTable[index].lazyDelete = true;
    _tableSize--;
    // munmap(), check system call
    if( munmap(ptr,_hashTable[index].size) == -1 ){
        throw std::runtime_error("munmap failed");
    }
}

/*
 * return the real index of address pointer(after hash and linear probing)
 */
int myMalloc::findIndex(void *ptr){
    int index = (int) hashFunctor(ptr);
    while( _hashTable[index].addr != ptr ){
        index = (index + 1) % _tableCapacity;
    }
    return index;
}



