******** Word Counter ******

SUMMARY : This is a command line java application which takes in a file path as an argument and counts the distinct words in it. And then sorts it and prints on the console.

REQUIREMENT : 
- build a command line application that takes a file path as argument.
- count the frequency of distinct words from the file.
- Display the distinct words and its count in descending order. ie word with most frequency should be printed first along with its count and so on.

ASSUMPTIONS :
- While parsing the lines in the file all the punctuations have been ignored.
- It is a case in-sensitive count. Example LONDON,london,LOnden are considered same and displayed as london with count 3.
- The application will minimum need 2 arguments to run. And a maximum of 4 arguments are accepted.

EXTRA FEATURES ADDED :
- An optional ordering argument is added which can sort the result on need basis.


SYSTEM REQUIREMENTS :
- This is a plane java application which requires the latest java LTS version ie. Java17.
- Maven is the build tool to build the application.


HOW TO BUILD AND PACKAGE : The word counter application can be cloned into an ide of choice and can be built and packaged using the below command.
- Navigate to the directory where POM.xml is located
- run the command "**mvn clean package shade:shade**"
- This command will build the application --> executes all the TESTS--> and generates the adp-1.0.jar under target folder.


HOW TO RUN THE APPLICATION : The application can be run from command line using the below sample command and arguments :
Command  : **java -jar adpExercise.jar -filepath <path-name> -order <asc>**
here, adpExercise.jar -> This is the executable jar generated from mvn build.
      -filepath       -> Argument acts as an identifier for following argument which is <path-name>.
      <path-name>     -> Argument is the placeholder for the full path of the file from where the words will be counted and displayed on console.
      -order          -> It is an optional argument and need to be passed only if there is a requirement to sort the word count in ascending or descending order.
      <asc>           -> Argument is an identifier for the explicit sorting order. Valid values are asc for ascending and dsc for descending order.

Note : -filepath and <path-name> are mandatory arguments and in the same sequence.
        -order and <asc> are the optional arguments, if any of it is not passed then the default sorting will be used ie DESCENDING.

Example commands : java -jar adp-1.0.jar -filepath /Users/pawankumar/adp/src/main/resources/input.txt
                   java -jar adp-1.0.jar -filepath /Users/pawankumar/adp/src/main/resources/input.txt -order asc
                   java -jar adp-1.0.jar -filepath /Users/pawankumar/adp/src/main/resources/input.txt -order dsc


