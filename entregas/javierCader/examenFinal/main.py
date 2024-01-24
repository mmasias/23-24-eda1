from controllers.index import Clinic_Controller
from structures.tree import Tree
from factories.index import PatientFactory
from models.index import Survey
class Clinic:
    def __init__(self):
        self.patient_tree = Tree()
        self.patient_factory = PatientFactory()

    def receive_patient(self):
        patient = self.patient_factory.create_patient("Jose Manuel R.", "2021-01-24")
        self.patient_tree.add_node(None, patient) 
        return patient

    def run_clinic(self):
        patient = self.receive_patient()
        survey = Survey()
        patient.add_survey(survey)
        self.patient_tree.add_node(patient, survey) 

        controller = Clinic_Controller(self.patient_tree, patient)
        controller.run()


if __name__ == "__main__":
    clinic = Clinic()
    clinic.run_clinic()
