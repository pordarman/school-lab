public class TreatmentRequest {
    int patientId;
    long arrivalTime;
    boolean isPriority;

    public TreatmentRequest(int patientId, boolean isPriority) {
        this.patientId = patientId;
        this.isPriority = isPriority;
        this.arrivalTime = System.currentTimeMillis();
    }
}
