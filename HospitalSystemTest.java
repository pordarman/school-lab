
public class HospitalSystemTest {

    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();

        // Create and add 10 patients
        System.out.println("Adding patients to the system...");
        for (int i = 0; i < 10; i++) {
            Patient patient = new Patient(i + 1, "Patient " + (i + 1), i % 5 + 1, 20 + i);
            system.addNewPatient(patient);
        }
        System.out.println("All patients added.");

        // Create and add treatment requests (some priority, some normal)
        System.out.println("Adding treatment requests to the system...");
        system.addTreatmentRequest(new TreatmentRequest(1, false));
        system.addTreatmentRequest(new TreatmentRequest(2, true));
        system.addTreatmentRequest(new TreatmentRequest(3, false));
        system.addTreatmentRequest(new TreatmentRequest(4, false));
        system.addTreatmentRequest(new TreatmentRequest(5, true));
        system.addTreatmentRequest(new TreatmentRequest(6, false));
        system.addTreatmentRequest(new TreatmentRequest(7, true));
        system.addTreatmentRequest(new TreatmentRequest(8, false));
        System.out.println("All treatment requests added.");

        // Add 2 discharge records to simulate prior discharges
        System.out.println("Adding discharge records to the system...");
        system.addDischargeRecord(new DischargeRecord(9));
        system.addDischargeRecord(new DischargeRecord(10));
        System.out.println("All discharge records added.");
        
        // Print initial system state
        system.printSystemState();

        // Process 4 treatments
        for (int i = 0; i < 4; i++) {
            Patient treatedPatient = system.processTreatment();
            if (treatedPatient != null) {
                System.out.println("Treated patient: ID " + treatedPatient.id + ", Name: " + treatedPatient.name);
            } else {
                System.out.println("No patient for treatment.");
            }
        }

        // Print final system state
        System.out.println("\n--- SYSTEM STATE AFTER PROCESSING ---");
        system.printSystemState();
    }
}
