//
//  msd_test_coverage.m
//  msd_test_coverage
//
//  Created by Jinny Jeng on 2/2/23.
//

#import <XCTest/XCTest.h>
#include "run.hpp"

@interface test : XCTestCase
@end

@implementation test
- (void)testAll {
    if (!run_tests()) XCTFail(@"failed");
}
@end
