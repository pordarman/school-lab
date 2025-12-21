public class DischargeStack {

    // Create a Node class
    private static class Node {
        DischargeRecord record;
        Node next;

        Node(DischargeRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top;

    public void push(DischargeRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }

    public DischargeRecord pop() {

        // If the top is null, return null
        if (top == null) return null;

        // Pop the top record
        DischargeRecord record = top.record;
        top = top.next;
        return record;
    }

    public DischargeRecord peek() {
        return top == null ? null : top.record;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println("Patient ID: " + current.record.patientId + " | Discharge Time: " + current.record.dischargeTime);
            current = current.next;
        }
    }

}
