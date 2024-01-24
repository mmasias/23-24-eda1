# Patient Survey System

This is a simple console-based application in Java that allows a patient to fill out a survey about their food intake over a period of five days.

## Features

- The patient can fill out a survey for each day, specifying the type of intake (Breakfast, Mid-morning, Lunch, Snack, Dinner) and the foods they had for that intake.
- The patient can view the current structure of their survey data, which shows the patient's name, the survey day, the type of intake, and the foods for each intake.
- The patient's name and survey data are stored in a `Patient` object. Each day's data is represented as a `List` of intakes, and each intake is a `List` that starts with the intake type and is followed by the foods for that intake.

## Classes

- `Node`: Represents a node in a singly linked list.
- `List`: A singly linked list that stores the survey data.
- `Patient`: Represents a patient with a name and survey data.
- `SurveySystem`: The main class that handles the user interaction and manages the survey data.
- `Main`: The entry point of the application.

## How to Run

Compile and run the `Main` class. Follow the prompts in the console to enter the patient's name, fill out the survey for a day, or display the current structure of the survey data.

## PlantUM Diagram

Here’s a simple class diagram for the program:

![](Diagram.svg)
