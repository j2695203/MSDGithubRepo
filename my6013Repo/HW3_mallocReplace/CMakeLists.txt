cmake_minimum_required(VERSION 3.24)
project(HW3_mallocReplace)

set(CMAKE_CXX_STANDARD 17)

add_executable(HW3_mallocReplace main.cpp myMalloc.cpp myMalloc.h catch.h test.cpp timeTest.cpp timeTest.h)
