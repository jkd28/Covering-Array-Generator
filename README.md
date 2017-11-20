## Author: John Dott
## Purpose:
This program was created for the 5th project for CS 1632: Software Quality Assurance at the University of Pittsburgh.
## Pairwise Covering Array Generator
This program takes a series of parameters as input and generates a Combinatorial Test Plan/Covering Array for pair-wise interactions between those parameters.  

To use:   
Compile: `javac Pairwise.java`  
Run: `java Pairwise <2 or more parameters>`
## Tests
I have written Unit Tests for this program.  
To run the tests:    
`./test.sh`  
OR  
`javac -cp .:jars/hamcrest-core-1.3.jar:jars/junit-4.12.jar *.java`  
`java -cp .:jars/hamcrest-core-1.3.jar:jars/junit-4.12.jar TestRunner`

## Linter
The linter `checkstyle` was used for this assignment with a configuration file that was provided by my instructor.   
To run the linter:  
`./checkstyle`  
OR  
`java -jar ./checkstyle-7.0-all.jar -c ./google_checks_modified.xml Pairwise.java
`
