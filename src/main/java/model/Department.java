package model;

public class Department {
    private long dept_id;
    private String dept_name;
    private String dept_address;
    private long dept_phone;
    private String dept_task;
    private long dept_manager;

    public Department() {
    }

    public Department(String dept_name, String dept_address, long dept_phone, String dept_task, long dept_manager) {
        this.dept_name = dept_name;
        this.dept_address = dept_address;
        this.dept_phone = dept_phone;
        this.dept_task = dept_task;
        this.dept_manager = dept_manager;
    }

    public Department(long dept_id, String dept_name, String dept_address, long dept_phone, String dept_task, long dept_manager) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.dept_address = dept_address;
        this.dept_phone = dept_phone;
        this.dept_task = dept_task;
        this.dept_manager = dept_manager;
    }

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_address() {
        return dept_address;
    }

    public void setDept_address(String dept_address) {
        this.dept_address = dept_address;
    }

    public long getDept_phone() {
        return dept_phone;
    }

    public void setDept_phone(long dept_phone) {
        this.dept_phone = dept_phone;
    }

    public String getDept_task() {
        return dept_task;
    }

    public void setDept_task(String dept_task) {
        this.dept_task = dept_task;
    }

    public long getDept_manager() {
        return dept_manager;
    }

    public void setDept_manager(long dept_manager) {
        this.dept_manager = dept_manager;
    }

    @Override
    public String toString() {
        return "Department[" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", dept_address='" + dept_address + '\'' +
                ", dept_phone='" + dept_phone + '\'' +
                ", dept_task='" + dept_task + '\'' +
                ", dept_manager=" + dept_manager +
                ']';
    }
}
