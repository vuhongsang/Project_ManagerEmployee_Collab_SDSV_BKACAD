package model;

public class Leave {
    private long lev_id;
    private String lev_reason;
    private String lev_start_date;
    private String lev_end_date;
    private long emp_id;

    public Leave() {
    }

    public Leave(String lev_reason, String lev_start_date, String lev_end_date) {
        this.lev_reason = lev_reason;
        this.lev_start_date = lev_start_date;
        this.lev_end_date = lev_end_date;
    }

    public Leave(String lev_reason, String lev_start_date, String lev_end_date, long emp_id) {
        this.lev_reason = lev_reason;
        this.lev_start_date = lev_start_date;
        this.lev_end_date = lev_end_date;
        this.emp_id = emp_id;
    }

    public Leave(long lev_id, String lev_reason, String lev_start_date, String lev_end_date, long emp_id) {
        this.lev_id = lev_id;
        this.lev_reason = lev_reason;
        this.lev_start_date = lev_start_date;
        this.lev_end_date = lev_end_date;
        this.emp_id = emp_id;
    }

    public long getLev_id() {
        return lev_id;
    }

    public void setLev_id(long lev_id) {
        this.lev_id = lev_id;
    }

    public String getLev_reason() {
        return lev_reason;
    }

    public void setLev_reason(String lev_reason) {
        this.lev_reason = lev_reason;
    }

    public String getLev_start_date() {
        return lev_start_date;
    }

    public void setLev_start_date(String lev_start_date) {
        this.lev_start_date = lev_start_date;
    }

    public String getLev_end_date() {
        return lev_end_date;
    }

    public void setLev_end_date(String lev_end_date) {
        this.lev_end_date = lev_end_date;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Leave[" +
                "lev_id=" + lev_id +
                ", lev_reason='" + lev_reason + '\'' +
                ", lev_start_date='" + lev_start_date + '\'' +
                ", lev_end_date='" + lev_end_date + '\'' +
                ", emp_id=" + emp_id +
                ']';
    }

}
