# CH_TakeHomeAssignment
This is a implementation of a solution for [CloudHumans](https://www.cloudhumans.com)'s backend Take Home Assignment.

# How To Run
To run this program, just run the ApiProjectApplication class.

# Technical Decisions
This project is made in [Java](https://www.java.com/pt-BR/), using [springboot](https://spring.io) to create the requested API.

The class ApiProjectApplication executes the API does the input and output of the program.

The class Pro, in conjunction with the classes InternetTest and PastExperiences, stores the data recieved through the API and processes them to return the requested JSON object.
The score of the pro is calculated in a series of in/else statements and is used to define which projects the pro can and cannot participate along with the project that he is allocated to work.

The name of the projects is stored in a ArrayList and is removed from it if the pro is'nt qualified to work on them, being added to the inelegible projects ArrayList.
