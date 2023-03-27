package model;

public class Permission {
    private long per_id;
    private String per_name;
    private boolean create_account;
    private boolean view_account;
    private boolean update_account;
    private boolean delete_account;
    private boolean create_staff;
    private boolean view_staff;
    private boolean update_staff;
    private boolean delete_staff;
    private boolean create_dept;
    private boolean view_dept;
    private boolean update_dept;
    private boolean delete_dept;

    public Permission() {
    }

    public Permission(String per_name, boolean create_account, boolean view_account, boolean update_account, boolean delete_account, boolean create_staff, boolean view_staff, boolean update_staff, boolean delete_staff, boolean create_dept, boolean view_dept, boolean update_dept, boolean delete_dept) {
        this.per_name = per_name;
        this.create_account = create_account;
        this.view_account = view_account;
        this.update_account = update_account;
        this.delete_account = delete_account;
        this.create_staff = create_staff;
        this.view_staff = view_staff;
        this.update_staff = update_staff;
        this.delete_staff = delete_staff;
        this.create_dept = create_dept;
        this.view_dept = view_dept;
        this.update_dept = update_dept;
        this.delete_dept = delete_dept;
    }

    public Permission(long per_id, String per_name, boolean create_account, boolean view_account, boolean update_account, boolean delete_account, boolean create_staff, boolean view_staff, boolean update_staff, boolean delete_staff, boolean create_dept, boolean view_dept, boolean update_dept, boolean delete_dept) {
        this.per_id = per_id;
        this.per_name = per_name;
        this.create_account = create_account;
        this.view_account = view_account;
        this.update_account = update_account;
        this.delete_account = delete_account;
        this.create_staff = create_staff;
        this.view_staff = view_staff;
        this.update_staff = update_staff;
        this.delete_staff = delete_staff;
        this.create_dept = create_dept;
        this.view_dept = view_dept;
        this.update_dept = update_dept;
        this.delete_dept = delete_dept;
    }

    public long getPer_id() {
        return per_id;
    }

    public void setPer_id(long per_id) {
        this.per_id = per_id;
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public boolean isCreate_account() {
        return create_account;
    }

    public void setCreate_account(boolean create_account) {
        this.create_account = create_account;
    }

    public boolean isView_account() {
        return view_account;
    }

    public void setView_account(boolean view_account) {
        this.view_account = view_account;
    }

    public boolean isUpdate_account() {
        return update_account;
    }

    public void setUpdate_account(boolean update_account) {
        this.update_account = update_account;
    }

    public boolean isDelete_account() {
        return delete_account;
    }

    public void setDelete_account(boolean delete_account) {
        this.delete_account = delete_account;
    }

    public boolean isCreate_staff() {
        return create_staff;
    }

    public void setCreate_staff(boolean create_staff) {
        this.create_staff = create_staff;
    }

    public boolean isView_staff() {
        return view_staff;
    }

    public void setView_staff(boolean view_staff) {
        this.view_staff = view_staff;
    }

    public boolean isUpdate_staff() {
        return update_staff;
    }

    public void setUpdate_staff(boolean update_staff) {
        this.update_staff = update_staff;
    }

    public boolean isDelete_staff() {
        return delete_staff;
    }

    public void setDelete_staff(boolean delete_staff) {
        this.delete_staff = delete_staff;
    }

    public boolean isCreate_dept() {
        return create_dept;
    }

    public void setCreate_dept(boolean create_dept) {
        this.create_dept = create_dept;
    }

    public boolean isView_dept() {
        return view_dept;
    }

    public void setView_dept(boolean view_dept) {
        this.view_dept = view_dept;
    }

    public boolean isUpdate_dept() {
        return update_dept;
    }

    public void setUpdate_dept(boolean update_dept) {
        this.update_dept = update_dept;
    }

    public boolean isDelete_dept() {
        return delete_dept;
    }

    public void setDelete_dept(boolean delete_dept) {
        this.delete_dept = delete_dept;
    }

    @Override
    public String toString() {
        return "Permission[" +
                "per_id=" + per_id +
                ", per_name='" + per_name + '\'' +
                ", create_account=" + create_account +
                ", view_account=" + view_account +
                ", update_account=" + update_account +
                ", delete_account=" + delete_account +
                ", create_staff=" + create_staff +
                ", view_staff=" + view_staff +
                ", update_staff=" + update_staff +
                ", delete_staff=" + delete_staff +
                ", create_dept=" + create_dept +
                ", view_dept=" + view_dept +
                ", update_dept=" + update_dept +
                ", delete_dept=" + delete_dept +
                ']';
    }
}
