import java.util.ArrayList;
import java.util.HashMap;

public class HospitalSystem {
    public PatientList patientList;
    public TreatmentQueue priorityQueue;
    public TreatmentQueue normalQueue;
    public DischargeStack dischargeStack;
    public HashMap<Integer, Patient> patientMap;

    public HospitalSystem() {
        this.patientList = new PatientList();
        this.dischargeStack = new DischargeStack();
        this.patientMap = new HashMap<>();
        this.priorityQueue = new TreatmentQueue();
        this.normalQueue = new TreatmentQueue();
    }

    public void addNewPatient(Patient patient) {
        patientList.addPatient(patient);
        patientMap.put(patient.id, patient);
    }

    public void addTreatmentRequest(TreatmentRequest request) {
        if (request.isPriority) {
            priorityQueue.enqueue(request);
        } else {
            normalQueue.enqueue(request);
        }
    }

    public Patient processTreatment() {
        TreatmentRequest request;
        if (priorityQueue.size() > 0) {
            request = priorityQueue.dequeue();
        } else if (normalQueue.size() > 0) {
            request = normalQueue.dequeue();
        } else {
            return null; // No patients to treat
        }

        DischargeRecord dischargeRecord = new DischargeRecord(request.patientId);
        dischargeStack.push(dischargeRecord);
        return patientMap.get(request.patientId);
    }

    public void printSystemState() {
        System.out.println("Current Patients in System:");
        patientList.printList();

        System.out.println("\nPriority Treatment Queue:");
        priorityQueue.printQueue();

        System.out.println("\nNormal Treatment Queue:");
        normalQueue.printQueue();

        System.out.println("\nDischarge Records:");
        dischargeStack.printStack();
    }

    public void printPatientsSortedBySeverity() {
        ArrayList<Patient> patientListForSorting = new ArrayList<>(patientMap.values());
        for (int i = 0; i < patientListForSorting.size() - 1; i++) {
            for (int j = 0; j < patientListForSorting.size() - 1 - i; j++) {
                if (patientListForSorting.get(j).severity < patientListForSorting.get(j + 1).severity) {
                    Patient tmp = patientListForSorting.get(j);
                    patientListForSorting.set(j, patientListForSorting.get(j + 1));
                    patientListForSorting.set(j + 1, tmp);
                }
            }
        }

        System.out.println("\nPatients sorted by severity (highest first):");
        for (Patient p : patientListForSorting) {
            System.out.println(p);
        }
    }
}
