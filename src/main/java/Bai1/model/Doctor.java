package Bai1.model;

public class Doctor {
    private int id;
    private String code;
    private String name;
    private String pass;
    private String specialization;

    public Doctor() {
    }

    public Doctor(int id, String code, String name, String pass, String specialization) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.pass = pass;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
