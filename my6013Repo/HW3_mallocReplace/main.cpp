
#define CATCH_CONFIG_RUNNER
#include "catch.h"
#include "timeTest.h"


int main(int argc, char **argv) {

    // run unit test
    Catch::Session().run(argc, argv);

    // time test for allocate (choose myAllocate() or built-in malloc() in testing method)
    testAllocateTime();

    // time test for deallocate (choose myDeallocate() or built-in free() in testing method)
    testDeallocateTime();

    return 0;
}
