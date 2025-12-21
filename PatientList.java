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
    private Node tail;

    public PatientList() {
        this.head = null;
    }

    public void addPatient(Patient patient) {
        Node newNode = new Node(patient);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void removePatient(int id) {
        if (head == null) {
            return;
        }

        // If the patient to be removed is the head
        if (head.patient.id == id) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.patient.id == id) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
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
