from controllers.index import Clinic_Controller
from models.index import Survey
from structures.tree import Tree
from factories.index import PatientFactory

class Clinic:
    def __init__(self):
        self.patient_tree = Tree()
        self.patient_factory = PatientFactory()
        self.patient = None

    def receive_patient(self):
        self.patient = self.patient_factory.create_patient("Jose Manuel R.", "2021-01-24")

    def run_clinic(self):
        self.receive_patient()
        self.patient_tree.add_node(None, self.patient)
        self.patient.add_survey(Survey())

        controller = Clinic_Controller(self.patient)
        controller.run()

if __name__ == "__main__":
    clinic = Clinic()
    clinic.run_clinic()
