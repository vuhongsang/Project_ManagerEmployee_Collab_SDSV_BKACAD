package model;

public class Account {
    private long ac_id;
    private String user_name;
    private String user_pass;
    private long account_level;

    public Account() {
    }

    public Account(String user_name, String user_pass) {
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public Account(String user_name, String user_pass, long account_level) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.account_level = account_level;
    }

    public long getAc_id() {
        return ac_id;
    }

    public void setAc_id(long ac_id) {
        this.ac_id = ac_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public long getAccount_level() {
        return account_level;
    }

    public void setAccount_level(long account_level) {
        this.account_level = account_level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ac_id=" + ac_id +
                ", user_name='" + user_name + '\'' +
                ", account_level=" + account_level +
                '}';
    }
}
