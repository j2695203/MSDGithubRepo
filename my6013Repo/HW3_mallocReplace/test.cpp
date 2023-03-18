//
// Created by Jinny Jeng on 3/17/23.
//
//#define CATCH_CONFIG_RUNNER
#include "catch.h"
#include "myMalloc.h"
#include <iostream>

TEST_CASE("test1"){

    myMalloc m1;

    SECTION("initial status"){
        CHECK(m1._tableCapacity == 5);
        CHECK(m1._tableSize == 0);
    }

    // 1. First Allocate(without growing): allocate without growing table (load factor < 0.8)
    void *addr1 = m1.allocate(100);
    void *addr2 = m1.allocate(4000);

    SECTION("First Allocate(without growing)"){
        CHECK(m1._tableCapacity == 5);
        CHECK(m1._tableSize == 2);
        CHECK(m1._hashTable[m1.findIndex(addr1)].addr == addr1);
        CHECK(m1._hashTable[m1.findIndex(addr2)].addr == addr2);
        CHECK(m1._hashTable[m1.findIndex(addr1)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr2)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr1)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr2)].lazyDelete == false);
    }
//    // print to check
//    std::cout << "\n[First Allocate]\n";
//    for( int i = 0; i < m1._tableCapacity ; i++ ){
//        std::cout << i << " addr: " << m1._hashTable[i].addr << " ";
//        std::cout << "  size: " << m1._hashTable[i].size << " ";
//        std::cout << "  lazy: " << m1._hashTable[i].lazyDelete << std::endl;
//    }

    // 2. Second allocate(with growing): allocate again with growing table (load factor > 0.8)
    void *addr3 = m1.allocate(8191);
    void *addr4 = m1.allocate(8192);
    void *addr5 = m1.allocate(8193);

    SECTION("Second allocate(with growing)"){
        CHECK(m1._tableCapacity == 11);
        CHECK(m1._tableSize == 5);

        CHECK(m1._hashTable[m1.findIndex(addr1)].addr == addr1);
        CHECK(m1._hashTable[m1.findIndex(addr2)].addr == addr2);
        CHECK(m1._hashTable[m1.findIndex(addr3)].addr == addr3);
        CHECK(m1._hashTable[m1.findIndex(addr4)].addr == addr4);
        CHECK(m1._hashTable[m1.findIndex(addr5)].addr == addr5);

        CHECK(m1._hashTable[m1.findIndex(addr1)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr2)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr3)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr4)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr5)].size == 12288);

        CHECK(m1._hashTable[m1.findIndex(addr1)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr2)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr3)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr4)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr5)].lazyDelete == false);
    }
//    // print to check
//    std::cout << "\n[Second Allocate]\n";
//    for( int i = 0; i < m1._tableCapacity ; i++ ){
//        std::cout << i << " addr: " << m1._hashTable[i].addr << " ";
//        std::cout << "  size: " << m1._hashTable[i].size << " ";
//        std::cout << "  lazy: " << m1._hashTable[i].lazyDelete << std::endl;
//    }

    // 3. Deallocate
    m1.deallocate(addr1);
    m1.deallocate(addr2);

    SECTION("Deallocate"){
        CHECK(m1._tableCapacity == 11);
        CHECK(m1._tableSize == 3);

        CHECK(m1._hashTable[m1.findIndex(addr1)].addr == addr1);
        CHECK(m1._hashTable[m1.findIndex(addr2)].addr == addr2);
        CHECK(m1._hashTable[m1.findIndex(addr3)].addr == addr3);
        CHECK(m1._hashTable[m1.findIndex(addr4)].addr == addr4);
        CHECK(m1._hashTable[m1.findIndex(addr5)].addr == addr5);

        CHECK(m1._hashTable[m1.findIndex(addr1)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr2)].size == 4096);
        CHECK(m1._hashTable[m1.findIndex(addr3)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr4)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr5)].size == 12288);
        // only lazyDelete of addr1 & addr2 will change
        CHECK(m1._hashTable[m1.findIndex(addr1)].lazyDelete == true);
        CHECK(m1._hashTable[m1.findIndex(addr2)].lazyDelete == true);
        CHECK(m1._hashTable[m1.findIndex(addr3)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr4)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr5)].lazyDelete == false);
    }
//    // print to check
//    std::cout << "\n[Deallocate]\n";
//    for( int i = 0; i < m1._tableCapacity ; i++ ){
//        std::cout << i << " addr: " << m1._hashTable[i].addr << " ";
//        std::cout << "  size: " << m1._hashTable[i].size << " ";
//        std::cout << "  lazy: " << m1._hashTable[i].lazyDelete << std::endl;
//    }

    // 4. Third allocate(without growing): allocate again to check overwriting table
    void *addr6 = m1.allocate(13000);
    void *addr7 = m1.allocate(13000);
    void *addr8 = m1.allocate(13000);
    void *addr9 = m1.allocate(16385);
    void *addr10 = m1.allocate(16385);

    SECTION("Third allocate(with growing)"){
        CHECK(m1._tableCapacity == 11);
        CHECK(m1._tableSize == 8);

        CHECK(m1._hashTable[m1.findIndex(addr3)].addr == addr3);
        CHECK(m1._hashTable[m1.findIndex(addr4)].addr == addr4);
        CHECK(m1._hashTable[m1.findIndex(addr5)].addr == addr5);
        CHECK(m1._hashTable[m1.findIndex(addr6)].addr == addr6);
        CHECK(m1._hashTable[m1.findIndex(addr7)].addr == addr7);
        CHECK(m1._hashTable[m1.findIndex(addr8)].addr == addr8);
        CHECK(m1._hashTable[m1.findIndex(addr9)].addr == addr9);
        CHECK(m1._hashTable[m1.findIndex(addr10)].addr == addr10);

        CHECK(m1._hashTable[m1.findIndex(addr3)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr4)].size == 8192);
        CHECK(m1._hashTable[m1.findIndex(addr5)].size == 12288);
        CHECK(m1._hashTable[m1.findIndex(addr6)].size == 16384);
        CHECK(m1._hashTable[m1.findIndex(addr7)].size == 16384);
        CHECK(m1._hashTable[m1.findIndex(addr8)].size == 16384);
        CHECK(m1._hashTable[m1.findIndex(addr9)].size == 20480);
        CHECK(m1._hashTable[m1.findIndex(addr10)].size == 20480);

        CHECK(m1._hashTable[m1.findIndex(addr3)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr4)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr5)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr6)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr7)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr8)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr9)].lazyDelete == false);
        CHECK(m1._hashTable[m1.findIndex(addr10)].lazyDelete == false);
    }
//    // print to check
//    std::cout << "\n[Third Allocate]\n";
//    for( int i = 0; i < m1._tableCapacity ; i++ ){
//        std::cout << i << " addr: " << m1._hashTable[i].addr << " ";
//        std::cout << "  size: " << m1._hashTable[i].size << " ";
//        std::cout << "  lazy: " << m1._hashTable[i].lazyDelete << std::endl;
//    }

}