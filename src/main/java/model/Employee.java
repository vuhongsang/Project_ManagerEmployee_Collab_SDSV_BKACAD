package model;

public class Employee {
    private long emp_id;
    private String first_name;
    private String last_name;
    private String position;
    private String birth_of_date;
    private long gender;
    private String email;
    private long phone;
    private String hire_date;
    private String end_date;
    private long fin_id;
    private long dept_id;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String position, String birth_of_date, long gender, String email, long phone, String hire_date, String end_date, long fin_id, long dept_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.birth_of_date = birth_of_date;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.hire_date = hire_date;
        this.end_date = end_date;
        this.fin_id = fin_id;
        this.dept_id = dept_id;
    }

    public Employee(long emp_id, String first_name, String last_name, String position, String birth_of_date, long gender, String email, long phone, String hire_date, String end_date, long fin_id, long dept_id) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.birth_of_date = birth_of_date;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.hire_date = hire_date;
        this.end_date = end_date;
        this.fin_id = fin_id;
        this.dept_id = dept_id;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirth_of_date() {
        return birth_of_date;
    }

    public void setBirth_of_date(String birth_of_date) {
        this.birth_of_date = birth_of_date;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public long getFin_id() {
        return fin_id;
    }

    public void setFin_id(long fin_id) {
        this.fin_id = fin_id;
    }

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "emp_id=" + emp_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", position='" + position + '\'' +
                ", birth_of_date='" + birth_of_date + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hire_date='" + hire_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", fin_id=" + fin_id +
                ", dept_id=" + dept_id +
                ']';
    }
}
