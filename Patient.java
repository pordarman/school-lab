public class Patient {
    public int id;
    public String name;
    public int severity;
    public int age;

    public Patient(int id, String name, int severity, int age) {
        this.id = id;
        this.name = name;
        this.severity = severity;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Severity: " + severity + ", Age: " + age;
    }
}