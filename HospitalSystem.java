
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

        // Merge sort implementation
        mergeSortBySeverity(patientListForSorting, 0, patientListForSorting.size() - 1);

        System.out.println("\nPatients sorted by severity (highest first):");
        for (Patient p : patientListForSorting) {
            System.out.println(p);
        }
    }

    private void mergeSortBySeverity(ArrayList<Patient> list, int left, int right) {

        // If left index is less than right index (more than one element)
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSortBySeverity(list, left, mid);
            mergeSortBySeverity(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(ArrayList<Patient> list, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        ArrayList<Patient> leftList = new ArrayList<>();
        ArrayList<Patient> rightList = new ArrayList<>();

        for (int idx = 0; idx < leftSize; idx++) {
            leftList.add(list.get(left + idx));
        }
        for (int idx = 0; idx < rightSize; idx++) {
            rightList.add(list.get(mid + 1 + idx));
        }

        int leftIndex = 0, rightIndex = 0;
        int mergedIndex = left;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftList.get(leftIndex).severity >= rightList.get(rightIndex).severity) {
                list.set(mergedIndex, leftList.get(leftIndex));
                leftIndex++;
            } else {
                list.set(mergedIndex, rightList.get(rightIndex));
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftSize) {
            list.set(mergedIndex, leftList.get(leftIndex));
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightSize) {
            list.set(mergedIndex, rightList.get(rightIndex));
            rightIndex++;
            mergedIndex++;
        }
    }
}
