from structures.node import Node
from typing import List

class Food(Node): 
    def __init__(self, name: str):
        super().__init__(data=name)

class Intake(Node): 
    def __init__(self, type: str):
        super().__init__(data=type)
        self.foods: List[Food] = []

    def add_food(self, food: Food):
        self.add_child(food)
        self.foods.append(food)

class Day(Node): 
    def __init__(self, number: int):
        super().__init__(data=f"Day {number}")
        self.intakes: List[Intake] = [Intake("Breakfast"), Intake("Mid-morning"), Intake("Lunch"), Intake("Snack"), Intake("Dinner")]

    def add_intake(self, intake: Intake):
        self.add_child(intake)
        self.intakes.append(intake)

class Survey(Node):
    def __init__(self):
        super().__init__(data="Survey")
        self.days: List[Day] = [Day(i) for i in range(1, 7)]

    def add_day(self, day: Day):
        self.add_child(day)
        self.days.append(day)

class Patient(Node):
    def __init__(self, name: str):
        super().__init__(data=name)
        self.surveys: List[Survey] = []

    def add_survey(self, survey: Survey):
        self.add_child(survey)
        self.surveys.append(survey)