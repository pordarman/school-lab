public class DischargeStack {
    private static class Node {
        DischargeRecord record;
        Node next;

        Node(DischargeRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top;

    public DischargeStack() {
        this.top = null;
    }

    public void push(DischargeRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }

    public DischargeRecord pop() {
        if (top == null) {
            return null;
        }

        // Declare a variable to hold the record to return and update the top pointer
        DischargeRecord record = top.record;
        top = top.next;
        return record;
    }

    public DischargeRecord peek() {
        if (top == null) {
            return null;
        }
     
        return top.record;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println("Patient ID: " + current.record.patientId + ", Discharge Time: " + current.record.dischargeTime);
            current = current.next;
        }
    }

}
