package Bai4.model;

public class LabResult {
    private int id;
    private int patientId;
    private double testValue;

    public LabResult() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setTestValue(double testValue) {
        this.testValue = testValue;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getTestValue() {
        return testValue;
    }
}