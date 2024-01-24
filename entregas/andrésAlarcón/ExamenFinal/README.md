# Project Overview - Nutrimet / Patient Survey System

This project is a console-based Java application that allows a patient to fill out a survey about their food intake over a period of five days. The application provides an interactive menu for the user to fill out the survey for a specific day, display the current structure of the survey, or exit the program.

## Class Descriptions
`Main`: This is the entry point of the application. It creates an instance of the SurveySystem class and starts the execution.

`SurveySystem`: This class handles the interaction with the user. It provides a menu for the user to fill out a survey for a day, display the current structure of the survey, or exit the program.

`Patient`: This class represents a patient. It contains the patient’s name and a list of Day objects representing each day of the survey.

`Day`: This class represents a day in the survey. It contains a list of Intake objects representing each type of intake (Breakfast, Mid-morning, Lunch, Snack, Dinner) for that day.

`Intake`: This class represents a type of intake. It contains a list of Food objects representing each food item consumed during that intake.

`Food`: This class represents a food item. It contains the name of the food item.

## How to Run
To run the application, compile all the .java files and then run the Main class. The application will start in the console. Follow the prompts to interact with the application.

## Note
This is a simple application and does not persist data between runs. Once the application is closed, all data will be lost.