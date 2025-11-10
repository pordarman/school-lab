
public class TreatmentQueue {

    private static class Node {

        TreatmentRequest request;
        Node next;

        Node(TreatmentRequest request) {
            this.request = request;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int currentSize;

    public TreatmentQueue() {
        this.front = null;
        this.rear = null;
        this.currentSize = 0;
    }

    public void enqueue(TreatmentRequest request) {
        Node newNode = new Node(request);

        // If the queue is empty, add the new node as both front and rear
        if (front == null) {
            front = newNode;
            rear = newNode;
            currentSize++;
            return;
        }

        rear.next = newNode;
        rear = newNode;
        currentSize++;
    }

    public TreatmentRequest dequeue() {
        if (front == null) {
            return null;
        }

        // Declare a variable to hold the request to return and delete the front node
        TreatmentRequest request = front.request;
        front = front.next;
        currentSize--;

        // If the queue becomes empty, update rear to null
        if (front == null) {
            rear = null;
        }
        
        return request;
    }

    public int size() {
        return currentSize;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println("Patient ID: " + current.request.patientId + ", Arrival Time: " + current.request.arrivalTime);
            current = current.next;
        }
    }
}
