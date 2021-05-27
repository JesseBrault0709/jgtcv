#!/bin/bash

../app/build/install/app/bin/app src/main/groovy/cv.groovy -o build/cv.tex &&\
cd build &&
pdftex cv.tex &&\
open -a Preview cv.pdf