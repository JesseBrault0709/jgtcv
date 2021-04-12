#!/bin/bash

../app/build/install/app/bin/app cv.groovy -o result.tex &&\
pdftex cv.tex &&\
open -a Preview cv.pdf