from controllers.index import Clinic_Controller
from models.index import Patient, Survey
from structures.tree import Tree

class Clinic:
    def __init__(self):
        self.patient_tree = Tree()

    def run_clinic(self):
        patient = Patient("Jose Manuel R.")
        self.patient_tree.add_node(None, patient)
        patient.add_survey(Survey())

        controller = Clinic_Controller(patient)
        controller.run()

if __name__ == "__main__":
    clinic = Clinic()
    clinic.run_clinic()
