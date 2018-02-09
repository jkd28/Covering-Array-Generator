## Author: John Dott
## Purpose:
This program was created for the 5th project for CS 1632: Software Quality Assurance at the University of Pittsburgh.
## Pairwise Covering Array Generator
This program takes a series of parameters as input and generates a Combinatorial Test Plan/Covering Array for pair-wise interactions between those parameters.  Not only did this assignment gauge my understanding of Combinatorial Testing, but it also gave me more experience with static code analysis and unit testing.  

I used Checkstyle as the linter for this assignment.  My instructor provided a modified version of Google's style guide for this assignment. In addition to linting, I regularly used FindBugs to check for deficiencies in my code.  You can run the unit tests and the linter by following the instructions below.  

## Usage   
Compile:  
`javac Pairwise.java`  
Run:  
`java Pairwise <2 or more strings>`

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

# Summary
I started this project by first running both `FindBugs` and `Checkstyle` on some of my previous assignments.  This allowed me to get a good feel for the types of issues that the two tools would identify with a lot of my coding practices.  Thankfully, there were not many issues that weren't easily resolved simply by focusing a bit more on my style and coding practices.  

The major issue I ran into was with `Checkstyle`.  I was not aware we were required to write JavaDoc comments in order to meet the standards.  This was not a huge setback, as it didn't affect the code itself, only the way I commented things.  This was an easy issue to resolve, simply because I just needed to add some more detailed description to each new method I created.  Otherwise, I would occasionally forget to space things out, like `for` and `{` that began the methods.

As I worked on the project, I was particularly mindful of my coding practices so that I wouldn't have too much to worry about when I used `FindBugs`.  I also ran `FindBugs` every time that I implemented new code, which kept me on course and minimized the issues I ran into.  The only time I actually ran into any "bugs" that were not "Dead Local Stores" was when I had string concatenation with the `+` operator in a loop.  I remedied this bug by switching to `StringBuilder`.
