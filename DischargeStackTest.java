public class DischargeStackTest {

    public static void main(String[] args) {
        DischargeStack stack = new DischargeStack();

        // Push test
        System.out.println("Pushing discharge records onto stack...");
        stack.push(new DischargeRecord(1));
        stack.push(new DischargeRecord(2));
        stack.push(new DischargeRecord(3));
        stack.push(new DischargeRecord(4));
        stack.push(new DischargeRecord(5));
        System.out.println("All records pushed.");

        // Pop test
        DischargeRecord record = stack.pop();
        if (record.patientId != 5) {
            System.out.println("Test Failed: Pop operation did not return the correct record: " + record.patientId);
            return;
        } else {
            System.out.println("Popped record for patient ID: " + record.patientId);
        }

        record = stack.pop();
        if (record.patientId != 4) {
            System.out.println("Test Failed: Pop operation did not return the correct record: " + record.patientId);
            return;
        } else {
            System.out.println("Popped record for patient ID: " + record.patientId);
        }

        System.out.println("All tests passed!");
        stack.printStack();
    }
}
