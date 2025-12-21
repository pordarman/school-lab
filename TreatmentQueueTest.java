public class TreatmentQueueTest {

    public static void main(String[] args) {
        TreatmentQueue queue = new TreatmentQueue();

        // Enqueue test
        queue.enqueue(new TreatmentRequest(1, false));
        queue.enqueue(new TreatmentRequest(2, false));
        queue.enqueue(new TreatmentRequest(3, false));
        queue.enqueue(new TreatmentRequest(4, false));
        queue.enqueue(new TreatmentRequest(5, false));
        queue.enqueue(new TreatmentRequest(6, false));
        queue.enqueue(new TreatmentRequest(7, false));
        queue.enqueue(new TreatmentRequest(8, false));

        // Dequeue test
        TreatmentRequest request = queue.dequeue();
        if (request.patientId != 1) {
            System.out.println("Test Failed: Dequeue operation did not return the correct request: " + request.patientId);
            return;
        }

        request = queue.dequeue();
        if (request.patientId != 2) {
            System.out.println("Test Failed: Dequeue operation did not return the correct request: " + request.patientId);
            return;
        }

        request = queue.dequeue();
        if (request.patientId != 3) {
            System.out.println("Test Failed: Dequeue operation did not return the correct request: " + request.patientId);
            return;
        }

        System.out.println("All tests passed!");        
        queue.printQueue();
    }
}
