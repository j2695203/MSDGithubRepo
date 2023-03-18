#ifndef HW3_MALLOCREPLACE_MYMALLOC_H
#define HW3_MALLOCREPLACE_MYMALLOC_H


struct TableNode{
    void* addr;
    size_t size;
    bool lazyDelete;
};


class myMalloc {

public:
    // member variables
    int _tableCapacity;
    int _tableSize;
    TableNode* _hashTable; // save address and allocation size

    // constructor & destructor
    myMalloc();
    ~myMalloc();

    // methods
    void* allocate(size_t bytesToAllocate);
    void deallocate(void* ptr);

    // helping methods for hash table
    void updateHashTable(void* addr, size_t len);
    void growHashTable();
    void addToHashTable(TableNode node);
    unsigned long hashFunctor(void* addr);
    int findIndex(void* addr);
};


#endif //HW3_MALLOCREPLACE_MYMALLOC_H
