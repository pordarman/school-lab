public class PatientListTest {

    public static void main(String[] args) {
        PatientList patientList = new PatientList();

        // Initialize PatientList and add patients
        System.out.println("Adding patients to the patient list...");
        patientList.addPatient(new Patient(1, "Ayşe", 5, 30));
        patientList.addPatient(new Patient(2, "Mehmet", 8, 45));
        patientList.addPatient(new Patient(3, "Fatma", 3, 25));
        patientList.addPatient(new Patient(4, "Ahmet", 7, 40));
        patientList.addPatient(new Patient(5, "Emre", 4, 28));
        System.out.println("All patients added.");

        // Test findPatient
        Patient patient = patientList.findPatient(2);
        if (patient == null || !patient.name.equals("Mehmet")) {
            System.out.println("Test Failed: findPatient did not return the correct patient.");
            return;
        } else {
            System.out.println("findPatient test passed for patient ID 2: " + patient.name);
        }

        // Test removePatient
        patientList.removePatient(2);
        patient = patientList.findPatient(2);
        if (patient != null) {
            System.out.println("Test Failed: removePatient did not remove the patient.");
            return;
        } else {
            System.out.println("removePatient test passed for patient ID 2.");
        }

        System.out.println("All tests passed!");
        patientList.printList();
    }
}
