public class DischargeRecord {
    public int patientId;
    public long dischargeTime;

    public DischargeRecord(int patientId) {

        // Initialize discharge record with patient ID and current time
        this.patientId = patientId;
        this.dischargeTime = System.currentTimeMillis();
    }
}
