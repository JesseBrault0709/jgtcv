#!/bin/bash

../app/build/install/app/bin/app cv.groovy &&\
pdftex cv.tex &&\
open -a Preview cv.pdf