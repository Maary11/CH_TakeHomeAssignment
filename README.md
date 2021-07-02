# CH_TakeHomeAssignment
This is an implementation of a solution for [CloudHumans](https://www.cloudhumans.com)'s backend Take Home Assignment.

# How To Run
To run this program, run the ApiProjectApplication class, located [here](https://github.com/Maatty11/CH_TakeHomeAssignment/tree/main/API_Project/src/main/java/com/CloudHumans/API_Project).

Access the API at http://localhost:8080/post

# Technical Decisions
This project is made in [Java](https://www.java.com/pt-BR/), using [springboot](https://spring.io) to create the requested API.

The class ApiProjectApplication executes the API that does the input and output of the program.

The class Pro, in conjunction with the classes InternetTest and PastExperiences, stores the data received through the API and processes them to return the requested JSON object.
The score of the pro is calculated in a series of if/else statements and is used to define which projects the pro can and cannot participate along with the project that he is allocated to.

The names of the projects are stored in the eligible projects ArrayList and are removed from it if the pro isn't qualified to work on them, being added to the ineligible projects ArrayList.
