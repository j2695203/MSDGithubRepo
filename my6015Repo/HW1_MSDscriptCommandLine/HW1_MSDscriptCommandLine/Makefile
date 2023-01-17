# Makefile - CS6015 HW1
#
# To build a target, enter:
# make <target>
#
# Target:
# all - build everything
# clean - delete derived files from make


CXXSOURCE = main.cpp cmdline.cpp

HEADERS = cmdline.hpp

all: msdscript

msdscript: $(CXXSOURCE) $(HEADERS)
	$(CXX) -c $(CXXSOURCE)
	$(CXX) -o msdscript $(CXXSOURCE)


.PHONY: clean

clean:
	rm -f *.o msdscript

