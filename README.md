# jgtcv
A Java program for modeling CVs/Résumés and outputting formatted TeX files.

Two examples are included: exampleCV and programmingCV. Each is a gradle project so as to allow IDE autocompletion. 
Each includes a shell script (to be used on macOS) to build the example and display it in Preview. To do so:

1) Run `gradle dist`
2) Run `cd exampleCV && ./build.sh` or `cd programmingCV && ./build.sh`
