public class PatientList {
    private static class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }
    
    private Node head;

    public PatientList() {
        this.head = null;
    }

    public void addPatient(Patient patient) {
        Node newNode = new Node(patient);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removePatient(int id) {
        if (head == null) {
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.patient.id != id) {
            previous = current;
            current = current.next;
        }

        // If patient not found
        if (current == null) {
            return;
        }

        // If previous is null, we're removing the head
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
    }

    public Patient findPatient(int id) {
        Node current = head;
        while (current != null) {
            if (current.patient.id == id) {
                return current.patient;
            }
            current = current.next;
        }

        // If patient not found
        return null;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.patient.id + ", Name: " + current.patient.name
                    + ", Severity: " + current.patient.severity + ", Age: " + current.patient.age);
            current = current.next;
        }
    }
}
