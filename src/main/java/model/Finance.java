package model;

import java.text.DecimalFormat;

public class Finance {
    private long fin_id;
    private String fin_name;
    private double salary_rage; //muc luong
    private double insurance; //bao hiem
    private double annual; // thuong nam

    public Finance() {
    }

    public Finance(String fin_name, double salary_rage, double insurance, double annual) {
        this.fin_name = fin_name;
        this.salary_rage = salary_rage;
        this.insurance = insurance;
        this.annual = annual;
    }

    public Finance(long fin_id, String fin_name, double salary_rage, double insurance, double annual) {
        this.fin_id = fin_id;
        this.fin_name = fin_name;
        this.salary_rage = salary_rage;
        this.insurance = insurance;
        this.annual = annual;
    }

    public long getFin_id() {
        return fin_id;
    }

    public void setFin_id(long fin_id) {
        this.fin_id = fin_id;
    }

    public String getFin_name() {
        return fin_name;
    }

    public void setFin_name(String fin_name) {
        this.fin_name = fin_name;
    }

    public double getSalary_rage() {
        return salary_rage;
    }

    public void setSalary_rage(double salary_rage) {
        this.salary_rage = salary_rage;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getAnnual() {
        return annual;
    }

    public void setAnnual(double annual) {
        this.annual = annual;
    }

    @Override
    public String toString() {
        return "Finance[" +
                "fin_id=" + fin_id +
                ", fin_name='" + fin_name + '\'' +
                ", salary_rage=" + salary_rage +
                ", insurance=" + insurance +
                ", annual=" + annual +
                ']';
    }
}
