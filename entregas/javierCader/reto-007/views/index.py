from models.index import Patient, Intake

class View:
    HEADER = '\033[95m'  
    OKBLUE = '\033[94m' 
    OKGREEN = '\033[92m'  
    WARNING = '\033[93m'  
    FAIL = '\033[91m'    
    ENDC = '\033[0m'     
    BOLD = '\033[1m'     
    UNDERLINE = '\033[4m'  

    @staticmethod
    def print_patient_data(patient: Patient):
        print(f"{View.BOLD}Patient: {patient.data}{View.ENDC}")
        for survey in patient.surveys:
            print(f"  {View.OKBLUE}{survey.data}{View.ENDC}")  
            for day in survey.days:
                print(f"    {View.OKGREEN}{day.data}{View.ENDC}") 
                for intake in day.intakes:
                    print(f"      {View.WARNING}{intake.data}{View.ENDC}") 
                    View.print_foods(intake)

    @staticmethod
    def print_foods(intake: Intake):
        if intake.foods:
            foods_str = ", ".join(food.data for food in intake.foods)
            print(f"        {View.HEADER}Foods: {foods_str}{View.ENDC}")
        else:
            print(f"        Foods: {View.FAIL}None{View.ENDC}") 

    @staticmethod
    def display_header(title: str):
        print("\n" + View.BOLD + View.UNDERLINE + title + View.ENDC)
        print(" ")

    @staticmethod
    def display_prompt(prompt: str):
        print(View.BOLD + View.WARNING + prompt + View.ENDC)
    
