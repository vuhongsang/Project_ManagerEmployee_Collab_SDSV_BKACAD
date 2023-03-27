package dao;

import connect.MyConnection;
import model.Employee;
import model.Leave;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaveDao {
    private BaseDao baseDao = new BaseDao();
    //get all information of list leaves
    public List<Leave> getAllLeave() {
        //create list to add leave to  leave list
        List<Leave> leaveList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT * from `Leaves`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create Department is empty data in order to input
                Leave leave = new Leave();
                leave.setLev_id(resultSet.getLong("lev_id"));
                leave.setLev_reason(resultSet.getString("lev_reason"));
                leave.setLev_start_date(resultSet.getString("lev_start_date"));
                leave.setLev_end_date(resultSet.getString("lev_end_date"));
                leave.setEmp_id(resultSet.getLong("emp_id"));

                //add to list
                leaveList.add(leave);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return leaveList;
    }

    //get some information by emp_id
    public List<Leave> getLeaveByEmployeeIDDB(long emp_id) {
        List<Leave> leaveList = new ArrayList<>();
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = String.format("SELECT * FROM `Leaves` WHERE `emp_id` = '%d' ",emp_id);
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Leave leave = new Leave();
                leave.setLev_id(resultSet.getLong("lev_id"));
                leave.setLev_reason(resultSet.getString("lev_reason"));
                leave.setLev_start_date(resultSet.getString("lev_start_date"));
                leave.setLev_end_date(resultSet.getString("lev_end_date"));
                leave.setEmp_id(resultSet.getLong("emp_id"));

                //add to list
                leaveList.add(leave);
            }

            // close connect
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*if (leaveList.size() == 0) {
            System.out.println("list empty");
        }*/
        return leaveList;
    }

    //get some information by leave id
    public Leave getLeaveByLeaveIDDB(long lev_id) {
        Leave leave = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = String.format("SELECT * FROM `Leaves` WHERE `lev_id` = '%d' ",lev_id);
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                leave = new Leave();
                leave.setLev_id(resultSet.getLong("lev_id"));
                leave.setLev_reason(resultSet.getString("lev_reason"));
                leave.setLev_start_date(resultSet.getString("lev_start_date"));
                leave.setLev_end_date(resultSet.getString("lev_end_date"));
                leave.setEmp_id(resultSet.getLong("emp_id"));
            }

            // close connect
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leave;
    }

    //create leave
    public void createLeaveDB(Leave lev) {

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("INSERT INTO `leaves` (`lev_reason`, `lev_start_date`, `lev_end_date`, `emp_id`) VALUES ('%s', '%s', '%s', '%d')",
                    lev.getLev_reason(),lev.getLev_start_date(),lev.getLev_end_date(),lev.getEmp_id());

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("create new leave fail !!");
            } else {
                System.out.println("create new leave successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete leave
    public void deleteLeaveByLevID(long lev_id) {
        if (getLeaveByLeaveIDDB(lev_id)==null) {
            System.out.println("This leave have ID not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM `Leaves` WHERE `lev_id`= " + lev_id;

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete leave fail !!");
            } else {
                System.out.println("delete leave successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete leave by employee ID
    public void deleteLeaveByEmployeeID(long emp_id) {
        if (getLeaveByEmployeeIDDB(emp_id)==null) {
            System.out.println("This leave have ID not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM `Leaves` WHERE `emp_id`= " + emp_id;

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.printf("delete leave with (Emp ID = %d)  fail !!",emp_id);
            } else {
                System.out.printf("delete leave with (Emp ID =%d) successfully ^^\n",emp_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete leave with LevId & EmployeeID
    public void deleteLeaveByLevIDAndEmpID(long lev_id,long emp_id) {
        if (getLeaveByLeaveIDDB(lev_id)==null) {
            System.out.println("This leave has not leave ID exist");
            return;
        }
        if (getLeaveByEmployeeIDDB(emp_id).size()==0) {
            System.out.println("this leave has not employee exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `Leaves` WHERE `lev_id`='%d' AND `emp_id`='%d' ",lev_id,emp_id);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete leave fail !!");
            } else {
                System.out.println("delete leave successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update leave
    public void updateLeaveByLev_id(long lev_id, Leave lev)  {
        if (getLeaveByLeaveIDDB(lev_id)==null) {
            System.out.println("Leave has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Leaves` SET `lev_reason` = '%s', `lev_start_date` = '%s', `lev_end_date` = '%s' WHERE (`lev_id` = '%d')",
                    lev.getLev_reason(),lev.getLev_start_date(),lev.getLev_end_date(),lev_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this leave (lev_id= %d) be updated completely ^^",lev_id);
            } else {
                System.out.printf("updated finance (lev_id= %d) is failure :((",lev_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //--------------------------ETC----------------------------------------------------------------------------------------
    public Employee getByEmployeeIDDB(long emp_id) {
        Employee employee = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Employees` WHERE `emp_id` = " + emp_id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmp_id(resultSet.getLong("emp_id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setBirth_of_date(resultSet.getString("birth_of_date"));
                employee.setGender(resultSet.getLong("gender"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getLong("phone"));
                employee.setHire_date(resultSet.getString("hire_date"));
                employee.setEnd_date(resultSet.getString("end_date"));
                employee.setFin_id(resultSet.getLong("fin_id"));
                employee.setDept_id(resultSet.getLong("dept_id"));
            }

            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //-------------------------SERVICE----------------------------------------------------------------------------------

    public String inputLeaveIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input leave ID : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input Leave ID fail, try again");
                System.out.println("Leave ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputLeaveReasonSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("------------------------------------------------");
            System.out.printf("Input leave reason: ");
            temp = in.next();
            if (!baseDao.hasOnlyNumbersAndLetter(temp)) {
                System.out.println("Content has special symbol or number, input again!!");
                System.out.println("examples : Vu, VU, vu, VU1, V8u --> OK");
                System.out.println("examples : V?* --> NG");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputLeaveStartSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input leave start (dd//MM//yyyy): ");
            temp = in.next();
            if (!baseDao.isValidFormat("dd//MM//yyyy", temp)) {
                System.out.println("Input leave start fail, try again");
                System.out.println("Input leave start like style : dd//MM//yyyy");
                System.out.println("example : 09//11//1989");
                System.out.println("---------------------------------------------------------");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputLeaveEndSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input leave end (dd//MM//yyyy): ");
            temp = in.next();
            if (!baseDao.isValidFormat("dd//MM//yyyy", temp)) {
                System.out.println("Input leave end fail, try again");
                System.out.println("Input leave end like style : dd//MM//yyyy");
                System.out.println("example : 09//11//1989");
                System.out.println("---------------------------------------------------------");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputEmployeeIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Employee ID : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input Employee ID fail, try again");
                System.out.println("Employee ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public void displayDetailsLeave(Leave lev) {
        System.out.printf("%-20s",lev.getLev_id());
        System.out.printf("%-20s", lev.getLev_reason());
        System.out.printf("%-20s", lev.getLev_start_date());
        System.out.printf("%-25s", lev.getLev_end_date());
        System.out.printf("%-10d", lev.getEmp_id());
        System.out.printf("\n");
    }

    public void showAllFinanceNonConditionSV() {
        List<Leave> leaveList = getAllLeave();
        System.out.println("------|MANAGE LEAVES|-->/LIST ALL LEAVES INFORMATION/---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Leave.ID", "Reason", "Start date", "End date", "EmployeeID");
        for (Leave liv  : leaveList) {
            System.out.printf("%-20s", liv.getLev_id());
            System.out.printf("%-20s", liv.getLev_reason());
            System.out.printf("%-20s", liv.getLev_start_date());
            System.out.printf("%-25s", liv.getLev_end_date());
            System.out.printf("%-10d ", liv.getEmp_id());
            System.out.printf("\n");
        }
    }

    public void getInformationByIDSV() {
        List<Leave> leaveList = new ArrayList<>();
        boolean flag_leaveEmpID = false;
        while (!flag_leaveEmpID) {
            String tempEmpID = inputEmployeeIDSV();
            long tempEmpIDL = Long.parseLong(tempEmpID);
            if (tempEmpID != null && getLeaveByEmployeeIDDB(tempEmpIDL).size()!=0) {
                leaveList = getLeaveByEmployeeIDDB(tempEmpIDL);
                System.out.println("\n---------Status Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Leave.ID", "Reason", "Start date", "End date", "EmployeeID");
                for (Leave liv : leaveList) {
                    displayDetailsLeave(liv);
                }
                flag_leaveEmpID = true;
                break;
                }
            System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Employee ID not exist !!");
            break;
        }
    }

    //create new employee
    public Leave createNewLeaveSV() {
        System.out.println("------/CREATE NEW LEAVES FOR EMPLOYEE/---------");
        Leave leave = new Leave();
        String tempReason = inputLeaveReasonSV();
        if (tempReason != null) {
            leave.setLev_reason(tempReason);
        }
        String tempStartDate = inputLeaveStartSV();
        if (tempStartDate != null) {
            leave.setLev_start_date(tempStartDate);
        }
        String tempEndDate = inputLeaveEndSV();
        if (tempEndDate != null) {
            leave.setLev_end_date(tempEndDate);
        }

        boolean flag_EmpID = false;
        while (!flag_EmpID) {
            String tempEmpID = inputEmployeeIDSV();
            long tempEmpIDL = Long.parseLong(tempEmpID);
            if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null) {
                leave.setEmp_id(tempEmpIDL);
                flag_EmpID=true;
                break;
            }
            System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Employee ID not exist");
        }
        System.out.println("---Status message-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        createLeaveDB(leave);
        return leave;
    }

    //----------------menu--------------------------------------------------------------------

    //for admin
    private static void showLeavesMenuSV(){
        System.out.println("---/MANAGE LEAVES MENU/-------|FOR ADMIN MODE|--------------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all leaves");
        System.out.println("[2] --> Get leaves information of 1 employee ID");
        System.out.println("[3] --> Create leaves for employee ");
        System.out.println("[4] --> Delete leaves");
        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
    }

    //for admin
    public void manageLeavesSV() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n-------------------|FOR ADMIN MODE|-------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showLeavesMenuSV();
            System.out.printf("Input Option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input data is wrong, again");
                continue;
            }
            if (option < 0 || option > 8) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input option again, out option !!");
                continue;
            }
            switch (option) {
                case 1:
                    showAllFinanceNonConditionSV();
                    break;
                case 2:
                   getInformationByIDSV();
                    break;
                case 3:
                    createNewLeaveSV();
                    break;
                case 4:
                    System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                    System.out.println("No use, delete employee will delete leave ");
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

    //for user
    private static void showLeavesMenuSVUS(){
        System.out.println("---/MANAGE LEAVES MENU/------------|FOR USER MODE|---------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all leaves");
        System.out.println("[2] --> Get leaves information of 1 employee ID");
        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
    }

    //for user
    public void manageLeavesSVUS() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showLeavesMenuSVUS();
            System.out.printf("Input Option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input data is wrong, again");
                continue;
            }
            if (option < 0 || option > 2) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input option again, out option !!");
                continue;
            }
            switch (option) {
                case 1:
                    showAllFinanceNonConditionSV();
                    break;
                case 2:
                    getInformationByIDSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

}
