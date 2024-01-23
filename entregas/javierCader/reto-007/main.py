from controllers.index import Controller
from models.index import Patient, Survey
from data_structures.tree import Tree

def main():
    patient_tree = Tree()
    patient = Patient("Jose Manuel R.")
    patient_tree.add_node(None, patient)
    patient.add_survey(Survey())
    
    controller = Controller(patient)
    controller.run()

if __name__ == "__main__":
    main()
