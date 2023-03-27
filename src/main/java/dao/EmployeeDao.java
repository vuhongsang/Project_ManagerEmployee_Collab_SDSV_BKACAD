package dao;

import connect.MyConnection;
import model.Employee;
import model.Finance;
import model.Leave;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDao {
    private BaseDao base = new BaseDao();
    private FinanceDao financeDao = new FinanceDao();
    private DepartmentDao departmentDao = new DepartmentDao();
    private LeaveDao leaveDao = new LeaveDao();


    //get --> v || create --> v|| update --> v|| delete --> v||

    public List<Employee> getAllDB() {
        //create list to add Employee to list employee
        List<Employee> employeeList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT * from `Employees`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create account is empty data in order to input
                Employee employee = new Employee();
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

                //add to list
                employeeList.add(employee);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return employeeList;
    }

    //get all employee same dept_id
    public List<Employee> getAllEmployeeSameDeptIDDB(long dept_id) {
        //create list to add Employee to list employee
        List<Employee> employeeList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = String.format("SELECT * from `Employees` WHERE `dept_id`='%d'",dept_id);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create account is empty data in order to input
                Employee employee = new Employee();
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

                //add to list
                employeeList.add(employee);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return employeeList;
    }

    ///get by employee id
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

    //get list employee same fin_id
    public Employee getByEmployeeFinIDDB(long fin_id) {
        Employee employee = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Employees` WHERE `fin_id` = " + fin_id + " LIMIT 1";
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

    //get by name
    public Employee getByEmployeeNameDB(String first_name, String last_name) {
        Employee employee = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = String.format("SELECT * FROM `Employees` WHERE `first_name`= '%s' AND `last_name`='%s'",
                    first_name, last_name
            );
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

    //get by email
    public Employee getByEmployeeEmailDB(String email) {
        Employee employee = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Employees` WHERE `email` = '" + email + "' LIMIT 1";
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

    //get by employee phone
    public Employee getByEmployeePhoneDB(long phone) {
        Employee employee = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = String.format("SELECT * FROM `Employees` WHERE `phone` = '%d' LIMIT 1", phone);
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


    //add new employee
    public void createEmployeeDB(Employee emp) {
        if (getByEmployeeEmailDB(emp.getEmail()) != null) {
            System.out.println("Email has register by other employee");
            return;
        }
        if (getByEmployeePhoneDB(emp.getPhone()) != null) {
            System.out.println("phone has register by other employee");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("INSERT INTO `Employees` (`first_name`,`last_name`,`position`,`birth_of_date`,`gender`,`email`,`phone`,`hire_date`,`end_date`,`fin_id`,`dept_id`) VALUES ('%s','%s','%s','%s','%d','%s','%d','%s','%s','%d','%d')",
                    emp.getFirst_name(), emp.getLast_name(), emp.getPosition(), emp.getBirth_of_date(), emp.getGender(), emp.getEmail(), emp.getPhone(), emp.getHire_date(), emp.getEnd_date(), emp.getFin_id(), emp.getDept_id()
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("create new account fail !!");
            } else {
                System.out.println("create new account successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update employee
    public void updateEmployeeDB(long emp_id, Employee employee) {
        if (getByEmployeeIDDB(emp_id) == null) {
            System.out.println("Employee has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Employees` SET `first_name` = '%s', `last_name` = '%s',`position` = '%s',`birth_of_date` = '%s',`gender` = '%d',`email` = '%s',`phone` = '%d',`hire_date` = '%s',`end_date` = '%s',`fin_id` = '%d',`dept_id` = '%d' WHERE (`emp_id` = '%d')",
                    employee.getFirst_name(), employee.getLast_name(), employee.getPosition(), employee.getBirth_of_date(), employee.getGender(), employee.getEmail(), employee.getPhone(), employee.getHire_date(), employee.getEnd_date(), employee.getFin_id(), employee.getDept_id(), emp_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this Employee (id= %d) be updated completely ^^", emp_id);
            } else {
                System.out.printf("updated Employee (id= %d) is failure :((", emp_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update department of employeee
    public void updateDeptOfEmployeeDB(long emp_id, long dept_id) {
        if (getByEmployeeIDDB(emp_id) == null) {
            System.out.println("Employee has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Employees` SET `dept_id` = '%d' WHERE (`emp_id` = '%d')",
                    dept_id,emp_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this Employee (id= %d, new depart = %d) be updated completely ^^", emp_id,dept_id);
            } else {
                System.out.printf("updated Employee (id= %d) is failure :((", emp_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete employee
    public void deleteEmployeeDB(long emp_id) {
        if (getByEmployeeIDDB(emp_id) == null) {
            System.out.println("Employee have ID not exist");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM `Employees` WHERE `emp_id`= " + emp_id;

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("Delete employee fail !!");
            } else {
                System.out.println("Delete employee successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-----------------------SV-----------------------------------

    public void displayDetailsEmployeeSV(Employee e) {
        System.out.println("------Result Message------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ ");
        System.out.printf("%-4s %-15s %-15s %-10s %-15s %-25s %-20s %-15s %-10s %-7s %-7s\n", "ID", "FullName", "Position", "BOD", "Gender", "Email", "Phone", "HireDate", "EndDate", "FinanceID", "DepartID");
        System.out.printf("%-4d ", e.getEmp_id());
        String full_name = e.getFirst_name() + " " + e.getLast_name();
        System.out.printf("%-15s", full_name);
        System.out.printf("%-15s", e.getPosition());
        System.out.printf("%-15s", e.getBirth_of_date());
        System.out.printf("%-15s", e.getGender());
        System.out.printf("%-25s", e.getEmail());
        System.out.printf("%-20s", e.getPhone());
        System.out.printf("%-15s", e.getHire_date());
        System.out.printf("%-20s", e.getEnd_date());
        System.out.printf("%-10d", e.getFin_id());
        System.out.printf("%-7d ", e.getDept_id());
        System.out.printf("\n");
    }

    //for admin
    public void showListEmployeeNoCondtion() {
        List<Employee> employeeList = getAllDB();
        System.out.println("\n------/LIST ALL EMPLOYEE/----------|FOR ADMIN MODE|------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-15s %-20s %-25s %-20s %-20s %-10s %-15s %-10s\n", "ID", "FullName", "Position", "BOD", "Gender", "Email", "Phone", "HireDate", "EndDate", "FinanceID", "DepartID");
        for (Employee em : employeeList) {
            System.out.printf("%-10d ", em.getEmp_id());
            String full_name = em.getFirst_name() + " " + em.getLast_name();
            System.out.printf("%-20s", full_name);
            System.out.printf("%-20s", em.getPosition());
            System.out.printf("%-20s", em.getBirth_of_date());
            System.out.printf("%-15s", em.getGender());
            System.out.printf("%-30s", em.getEmail());
            System.out.printf("%-20s", em.getPhone());
            System.out.printf("%-20s", em.getHire_date());
            System.out.printf("%-20s", em.getEnd_date());
            System.out.printf("%-15d", em.getFin_id());
            System.out.printf("%-15d ", em.getDept_id());
            System.out.printf("\n");
        }

    }

    //for user
    public void showListEmployeeNoCondtionUS() {
        List<Employee> employeeList = getAllDB();
        System.out.println("\n------/LIST ALL EMPLOYEE/-----------|FOR USER MODE|-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-15s %-20s %-10s\n", "ID", "FullName", "Position", "BOD", "Gender","DepartID");
        for (Employee em : employeeList) {
            System.out.printf("%-10d ", em.getEmp_id());
            String full_name = em.getFirst_name() + " " + em.getLast_name();
            System.out.printf("%-20s", full_name);
            System.out.printf("%-20s", em.getPosition());
            System.out.printf("%-20s", em.getBirth_of_date());
            System.out.printf("%-15s", em.getGender());
            System.out.printf("%-15d ", em.getDept_id());
            System.out.printf("\n");
        }

    }

    public void showListEmployeeSV(List<Employee> employeeList) {
        /*List<Employee> employeeList = getAllDB();*/
        System.out.println("------LIST ALL EMPLOYEE-------------");
        System.out.printf("%-4s %-15s %-15s %-10s %-15s %-25s %-20s %-15s %-10s %-7s %-7s\n", "ID", "FullName", "Position", "BOD", "Gender", "Email", "Phone", "HireDate", "EndDate", "FinanceID", "DepartID");
        for (Employee em : employeeList) {
            System.out.printf("%-4d ", em.getEmp_id());
            String full_name = em.getFirst_name() + " " + em.getLast_name();
            System.out.printf("%-15s", full_name);
            System.out.printf("%-15s", em.getPosition());
            System.out.printf("%-15s", em.getBirth_of_date());
            System.out.printf("%-15s", em.getGender());
            System.out.printf("%-25s", em.getEmail());
            System.out.printf("%-20s", em.getPhone());
            System.out.printf("%-15s", em.getHire_date());
            System.out.printf("%-20s", em.getEnd_date());
            System.out.printf("%-10d", em.getFin_id());
            System.out.printf("%-7d ", em.getDept_id());
            System.out.printf("\n");
        }

    }

    public void getInformationByIDSV() {
        Employee e = new Employee();
        boolean flag_EmpID = false;
        while (!flag_EmpID) {
            String tempEmpID = inputEmployeeIDSV();
            long tempEmpIDL = Long.parseLong(tempEmpID);
            if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null) {
                e = getByEmployeeIDDB(tempEmpIDL);
                System.out.println("\n---------Status Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
                displayDetailsEmployeeSV(e);
                flag_EmpID=true;
                break;
            }
            System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Employee ID not exist, can use option[1] or [3] to improve and solve problem");
            break;
        }
    }

    public String inputQuantityDependentPerson() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input quantity of dependent person : ");
            temp = in.next();
            if (!base.hasOnlyNumber(temp)) {
                System.out.println("Input quantity fail, try again");
                System.out.println("Quantity only include number!!");
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
            if (!base.hasOnlyNumber(temp)) {
                System.out.println("Input Employee ID fail, try again");
                System.out.println("Employee ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputFirstNameSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("------------------------------------------------");
            System.out.printf("Input first name : ");
            temp = in.next();
            if (!base.hasOnlyString(temp)) {
                System.out.println("First name has special symbol or number, input again!!");
                System.out.println("examples : Vu, VU, vu --> OK");
                System.out.println("examples : VU1, V8u --> NG");
                System.out.println("examples : V?* --> NG");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputLastNameSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input last name : ");
            temp = in.next();
            if (!base.hasOnlyString(temp)) {
                System.out.println("Last name has special symbol or number, input again!!");
                System.out.println("examples : Vu, VU, vu --> OK");
                System.out.println("examples : VU1, V8u --> NG");
                System.out.println("examples : V?* --> NG");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputPositionSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Position name : ");
            temp = in.next();
            if (!base.hasOnlyString(temp)) {
                System.out.println("position name has special symbol or number, input again!!");
                System.out.println("examples : Vu, VU, vu --> OK");
                System.out.println("examples : VU1, V8u --> NG");
                System.out.println("examples : V?* --> NG");
                System.out.println("---------------------------------------------------------");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputBODSV() {
        String temp = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input birth of day : ");
            temp = in.next();
            if (base.hasForDate(temp)) {
                return temp;
            }
            System.out.println("Input BOD fail, try again");
            System.out.println("Input BOD like style : dd/MM/yyyy");
            System.out.println("example : 09/11/1989");
            System.out.println("---------------------------------------------------------");
        }
    }

    public long inputGenderSV() {
        long temp = -1;
        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.printf("Only input gender (woman=0,man=1) : ");
                String temps = in.next();
                temp = Long.parseLong(temps);
                if (!base.hasGender01(temp)) {
                    System.out.println("Only input gender value (woman=0,man=1)");
                    System.out.println("Input Again!!");
                    System.out.println("---------------------------------------------------------");
                } else {
                    return temp;
                }
            } catch (Exception e) {
                System.out.println("Input again!!");
            }
        } while (temp != -1);
        return temp;
    }

    public String inputEmailSV() {
        String temp = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Email : ");
            temp = in.next();
            if (base.hasForEmail(temp)) {
                return temp;
            }
            System.out.println("Input email validate failure!!");
            System.out.println("examples OK --> user.name@domain.com, user_name@domain.com, username@yahoo.corporate.in");
            System.out.println("examples NG -->.username@yahoo.com, username@yahoo..com, @yahoo.com, name#1@yahoo.com");

        }
    }

    public String inputPhoneNumbersSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input phone number : ");
            temp = in.next();
            if (!base.hasOnlyNumber(temp)) {
                System.out.println("Input phone number failure!!");
                System.out.println("phone number only number, not include(aZ,symbol)!!");
                System.out.println("Input again :((");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputHireDateSV() {
        String temp = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input hire date (dd/MM/yyyy): ");
            temp = in.next();
            if (base.hasForDate(temp)) {
                return temp;
            }
            System.out.println("------Warning Message------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Input hire date fail, try again");
            System.out.println("Input hire date like style : dd/MM/yyyy");
            System.out.println("example : 09/11/1989");
        }
    }

    public String inputEndDateSV() {
        String temp = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input end date (dd/MM/yyyy): ");
            temp = in.next();
            if (base.hasForDate(temp)) {
                return temp;
            }
            System.out.println("------Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Input end date fail, try again");
            System.out.println("Input end date like style : dd/MM/yyyy");
            System.out.println("example : 09/11/1989");
        }
    }

    public String inputDeptIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input department ID : ");
            temp = in.next();
            if (!base.hasOnlyNumber(temp)) {
                System.out.println("Input department id fail, try again");
                System.out.println("Department ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputFinanceIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input finance ID : ");
            temp = in.next();
            if (!base.hasOnlyNumber(temp)) {
                System.out.println("Input finance id fail, try again");
                System.out.println("finance ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    //create new employee
    public Employee createNewEmployeeSV() {
        System.out.println("------/CREATE NEW EMPLOYEE/--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Employee emp = new Employee();
        String tempFirstName = inputFirstNameSV();
        if (tempFirstName != null) {
            emp.setFirst_name(tempFirstName);
        }
        String tempLastName = inputLastNameSV();
        if (tempLastName != null) {
            emp.setLast_name(tempLastName);
        }
        String tempPosition = inputPositionSV();
        if (tempPosition != null) {
            emp.setPosition(tempPosition);
        }
        String tempBOD = inputBODSV();
        if (tempBOD != null) {
            emp.setBirth_of_date(tempBOD);
        }
        long tempGender = inputGenderSV();
        if (tempGender != (-1)) {
            emp.setGender(tempGender);
        }
        boolean flag_Email = false;
        while (!flag_Email) {
            String tempEmails = inputEmailSV();
            if (tempEmails != null&&getByEmployeeEmailDB(tempEmails)==null) {
                emp.setEmail(tempEmails);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("---Status mesage-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("duplicate email, input again");
        }
        boolean flag_EPhone = false;
        while (!flag_EPhone) {
            String tempEPhone = inputPhoneNumbersSV();
            long tempEphoneL = Long.parseLong(tempEPhone);
            if (tempEPhone != null&&getByEmployeePhoneDB(tempEphoneL)==null) {
                emp.setPhone(tempEphoneL);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("---Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("duplicate employee phone, input again");
        }
        String tempHireDate = inputHireDateSV();
        if (tempHireDate != null) {
            emp.setHire_date(tempHireDate);
        }
        String tempEndDate = inputEndDateSV();
        if (tempEndDate != null) {
            emp.setEnd_date(tempEndDate);
        }
        boolean flag_Dept = false;
        while (!flag_Dept) {
            String tempDeptID = inputDeptIDSV();
            long tempDeptIDL = Long.parseLong(tempDeptID);
            if (tempDeptID != null && departmentDao.getByDepartmentIDDB(tempDeptIDL) != null) {
                emp.setDept_id(tempDeptIDL);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("Dept ID not exist, input again");
        }
        boolean flag_FinID = false;
        while (!flag_FinID) {
            String tempFinID = inputFinanceIDSV();
            long tempFinIDL = Long.parseLong(tempFinID);////>
            if (tempFinID != null && financeDao.getByFinanceIDDB(tempFinIDL) != null) {
                emp.setFin_id(tempFinIDL);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("Fin ID not exist, input again");
        }
        System.out.println("---Status Message----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        createEmployeeDB(emp);
        return emp;
    }

    //delete employee & leaves
    public void deleteEmployeeSV() {
        // delete leave have foreign key emp_id
        System.out.println("\n---|MANAGE EMPLOYEE|-->/DELETE EMPLOYEE/--------------------------------------------------------------------------------------------------------------------------------------------------------");
        boolean flag_EmpID = false;
        long tempEmpIDLx=-1;
        while (!flag_EmpID) {
            String tempEmpID = inputEmployeeIDSV();
            long tempEmpIDL = Long.parseLong(tempEmpID);
            tempEmpIDLx = tempEmpIDL;//copy to save delete
            if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null && leaveDao.getLeaveByEmployeeIDDB(tempEmpIDL).size() != 0) {
                /*System.out.println("exist emp id in leave list");*/
                List<Leave> leaveList = leaveDao.getLeaveByEmployeeIDDB(tempEmpIDL);
                System.out.println("--/LEAVES OF THIS EMPLOYEE ID/-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-20s %-20s %-20s %-20s %-10s \n", "Lev.ID", "Reason", "StartDate", "EndDate", "EmployeeID");
                for (Leave lev : leaveList) {
                    leaveDao.displayDetailsLeave(lev);
                }
                System.out.println("---Status mesage-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                leaveDao.deleteLeaveByEmployeeID(tempEmpIDLx);
                deleteEmployeeDB(tempEmpIDLx);
                break;
            }
            if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null && leaveDao.getLeaveByEmployeeIDDB(tempEmpIDL).size() == 0) {
                System.out.println("---Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("List leave of employee (E.ID= %d) : Empty\n",tempEmpIDLx);
                System.out.println("Process delete is starting>> ");
                deleteEmployeeDB(tempEmpIDLx);
                break;
            }
            System.out.println("---Warning Message--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Employee ID not exist in database, please use [1] or [3] to solve problem ! ");
            break;
        }
        /*leaveDao.deleteLeaveByEmployeeID(tempEmpIDLx);
        deleteEmployeeDB(tempEmpIDLx);*/
        return;

    }

    ///update information of employee
    public void updateEmployeeSV() {
        System.out.println("--/UPDATE EMPLOYEE INFORMATION/-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Employee emp = new Employee();
        boolean flag_EmpID = false;
        while (!flag_EmpID) {
            String tempEmpID = inputEmployeeIDSV();
            long tempEmpIDL = Long.parseLong(tempEmpID);
            if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null) {
                emp.setEmp_id(tempEmpIDL);
                flag_EmpID=true;
                break;
            }
            System.out.println("\n---------Suggest Message------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Employee ID not exist, can use option[1] or [3] to improve and solve problem");
        }
        String tempFirstName = inputFirstNameSV();
        if (tempFirstName != null) {
            emp.setFirst_name(tempFirstName);
        }
        String tempLastName = inputLastNameSV();
        if (tempLastName != null) {
            emp.setLast_name(tempLastName);
        }
        String tempPosition = inputPositionSV();
        if (tempPosition != null) {
            emp.setPosition(tempPosition);
        }
        String tempBOD = inputBODSV();
        if (tempBOD != null) {
            emp.setBirth_of_date(tempBOD);
        }
        long tempGender = inputGenderSV();
        if (tempGender != (-1)) {
            emp.setGender(tempGender);
        }
        boolean flag_Email = false;
        while (!flag_Email) {
            Employee tempEmpOri = getByEmployeeIDDB(emp.getEmp_id());
            String tempEmailOri = tempEmpOri.getEmail();
            String tempEmails = inputEmailSV();
            if (tempEmails != null&&getByEmployeeEmailDB(tempEmails)==null) {
                emp.setEmail(tempEmails);
                flag_Email = true;
                break;
            } else if (tempEmails != null && tempEmails.equalsIgnoreCase(tempEmailOri)) {
                System.out.println("Input same old email of this employee, keep origil");
                emp.setEmail(tempEmails);
                flag_Email = true;
                break;
            }
            System.out.println("\n---------Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Duplicate email, input different name email again");
        }
        boolean flag_EPhone = false;
        while (!flag_EPhone) {
            Employee tempEmpOri2 = getByEmployeeIDDB(emp.getEmp_id());
            long tempPhoneOri = tempEmpOri2.getPhone();
            String tempEPhone = inputPhoneNumbersSV();
            long tempEphoneL = Long.parseLong(tempEPhone);
            if (tempEPhone != null&&getByEmployeePhoneDB(tempEphoneL)==null) {
                emp.setPhone(tempEphoneL);
                flag_EPhone = true;
                break;
            } else if (tempEPhone != null&&tempEphoneL==tempPhoneOri) {
                System.out.println("Input same old phone of this employee, keep origil");
                emp.setPhone(tempEphoneL);
                flag_EPhone = true;
                break;
            }
            System.out.println("\n---------Warning Message---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("duplicate employee phone, input again");
        }
        /*String tempPhone = inputPhoneNumbersSV();
        if (tempPhone != null) {
            emp.setPhone(Long.parseLong(tempPhone));
        }*/
        String tempHireDate = inputHireDateSV();
        if (tempHireDate != null) {
            emp.setHire_date(tempHireDate);
        }
        String tempEndDate = inputEndDateSV();
        if (tempEndDate != null) {
            emp.setEnd_date(tempEndDate);
        }
        boolean flag_Fin = false;
        while (!flag_Fin) {
            String tempFinID = inputFinanceIDSV();
            long tempFinIDL = Long.parseLong(tempFinID);
            if (tempFinID != null && financeDao.getByFinanceIDDB(tempFinIDL) != null) {
                emp.setFin_id(tempFinIDL);
                flag_Fin=true;
                break;
            }
            System.out.println("---------Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Fin ID not exist, get finance ID information and input again");
            break;
        }
        boolean flag_Dept = false;
        while (!flag_Dept) {
            String tempDeptID = inputDeptIDSV();
            long tempDeptIDL = Long.parseLong(tempDeptID);
            if (tempDeptID != null && departmentDao.getByDepartmentIDDB(tempDeptIDL) != null) {
                emp.setDept_id(tempDeptIDL);
                flag_Dept=true;
                break;
            }
            System.out.println("---------Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Dept ID not exist, input again");
            break;
        }
        if (flag_EmpID == true && flag_Fin == true && flag_Dept == true && flag_EPhone == true) {
            System.out.println("\n---------Status Message----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Input completely, update process is running >>");
            updateEmployeeDB(emp.getEmp_id(), emp);
        } else {
            System.out.println("\n---------Warning Message--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Update employee process is failure, maybe input incorrect, try again !");
        }
    }

    ///list search get employee
    public Employee searchEmployeeSV() {
        Employee employee=null;
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("---/SEARCH EMPLOYEE MENU/----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("[1]--> Search employee by _ID");
            System.out.println("[2]--> Search employee by _Name");
            System.out.println("[3]--> Search employee by _Phone");
            System.out.println("[4]--> Search employee by _Email");
            System.out.println("[0]--> exit");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("Input Option: ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("Type of Input-Data is incorrect,must input only number, again!! ");
                continue;
            }
            if (option < 0 || option > 4) {
                System.out.println("Menu hasn't this option, again !! ");
                continue;
            }
            switch (option) {
                case 1:
                    boolean flag_case1 = false;
                    while (!flag_case1) {
                        String tempCase1 = inputEmployeeIDSV();
                        long tempCase1L = Long.parseLong(tempCase1);
                        if (tempCase1 != null&&getByEmployeeIDDB(tempCase1L)!=null) {
                            System.out.println("------Search result------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            displayDetailsEmployeeSV(getByEmployeeIDDB(tempCase1L));
                            employee = getByEmployeeIDDB(tempCase1L);///
                            break;
                        }
                        if (tempCase1 != null&&getByEmployeeIDDB(tempCase1L)==null) {
                            System.out.println("------Search result------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            System.out.println("No exist employee with ID as above !!");
                            break;
                        }
                    }
                    break;
                case 2:
                    boolean flag_case2 = false;
                    while (!flag_case2) {
                        String tempCase2FN = inputFirstNameSV();
                        String tempCase2LN = inputLastNameSV();
                        if (tempCase2LN != null && tempCase2FN != null && getByEmployeeNameDB(tempCase2FN, tempCase2LN) != null) {
                            System.out.println("------Search result------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            displayDetailsEmployeeSV(getByEmployeeNameDB(tempCase2FN, tempCase2LN));
                            employee = getByEmployeeNameDB(tempCase2FN,tempCase2LN);
                            break;
                        }
                        if (tempCase2LN != null && tempCase2FN != null && getByEmployeeNameDB(tempCase2FN, tempCase2LN) == null) {
                            System.out.println("------Warning message----------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            System.out.println("No exist employee with name as above !!");
                            break;
                        }
                    }
                    break;
                case 3:
                    boolean flag_case3 = false;
                    while (!flag_case3) {
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                        String tempCase3PN = inputPhoneNumbersSV();
                        Long tempCase3PNL = Long.parseLong(tempCase3PN);
                        if (tempCase3PN != null && tempCase3PNL != null) {
                            System.out.println("------Search result-------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            if (getByEmployeePhoneDB(tempCase3PNL) == null) {
                                System.out.println("No exist employee with phone number as above !!");
                                break;
                            } else {
                                System.out.println("------Search result----------------------------------------------------------------------------------------------------------------------------------------------------- ");
                                displayDetailsEmployeeSV(getByEmployeePhoneDB(tempCase3PNL));
                                break;
                            }
                        }
                        break;
                    }
                    break;
                case 4:
                    boolean flag_case4 = false;
                    while (!flag_case4) {
                        String tempCase4 = inputEmailSV();
                        if (tempCase4 != null&&getByEmployeeEmailDB(tempCase4)!=null) {
                            System.out.println("------Search result---------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            displayDetailsEmployeeSV(getByEmployeeEmailDB(tempCase4));
                            employee = getByEmployeeEmailDB(tempCase4);
                            break;
                        }
                        if (tempCase4 != null&&getByEmployeeEmailDB(tempCase4)==null) {
                            System.out.println("------Search result----------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            System.out.println("No exist employee with above email !!");
                            break;
                        }
                    }
                    /*break;*/
            }
        } while (option!=0);
        return employee;
    }

    //add employee to department
    public void updateDeptForEmployeeSV() {
        System.out.println("---|MANAGE DEPARTMENT MENU|-->/CHANGE DEPARTMENT FOR EMPLOYEE/--------------------------------------------------------------------------------------------------------------------------------------");
        boolean flag_UDFEE = false; //flag for employee id
        boolean flag_UDFED =false;  //flag for department id
        long tempUDFE_EmpIDL=0;
        long tempUDFE_DeptIDL=0;
        while (true) {
            while (!flag_UDFEE) {
                String tempEmpID = inputEmployeeIDSV();
                long tempEmpIDL = Long.parseLong(tempEmpID);
                if (tempEmpID != null && getByEmployeeIDDB(tempEmpIDL) != null) {
                    tempUDFE_EmpIDL = tempEmpIDL;
                    break;
                }
                System.out.println("---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Employee ID not exist,can you select option [1] or [3] to solve problem");
                break;
            }
            while (!flag_UDFED) {
                String tempDeptID = inputDeptIDSV();
                long tempDeptIDL = Long.parseLong(tempDeptID);
                if (tempDeptID != null && departmentDao.getByDepartmentIDDB(tempDeptIDL) != null) {
                    tempUDFE_DeptIDL = tempDeptIDL;
                    break;
                }
                System.out.println("---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Department ID not exist, can you select option [1] or [3] to solve problem\n");
                break;
            }

            if (tempUDFE_EmpIDL != 0 && tempUDFE_DeptIDL != 0) {
                System.out.println("--//UPDATE DEPARTMENT FOR EMPLOYEE STATUS//--------------------------------------------------------------------------------------------------------------------------------------------------");
                updateDeptOfEmployeeDB(tempUDFE_EmpIDL, tempUDFE_DeptIDL);
                int option = -1;
                Scanner in = new Scanner(System.in);
                do {
                    System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Do you want to see full information this employee ?");
                    System.out.println("[1]--> Yes");
                    System.out.println("[0]--> No and exit");
                    System.out.printf("Input option= ");
                    try {
                        option = Integer.parseInt(in.next());
                    } catch (Exception e) {
                        System.out.print("-----Warning Message------------------------------------------------------------------------------------------------------------------------------------------------------------//--- \n");
                        System.out.println("Type of data-input is incorrect ,again!!");
                        continue;
                    }
                    if (option < 0 || option > 1) {
                        System.out.print("-----Warning Message-----------------------------------------------------------------------------------------------------------------------------------------------------------//--- \n");
                        System.out.println("Only select option 0 OR 1");
                        continue;
                    }
                    switch (option) {
                        case 1:
                            System.out.println("-/EMPLOYEE INFORMATION DETAILS/------------------------------------------------------------------------------------------------------------------------------------------------");
                            displayDetailsEmployeeSV(getByEmployeeIDDB(tempUDFE_EmpIDL));
                            break;
                        case 0:
                            break;
                    }
                } while (option != 0);
            } else {
                System.out.println("Change employee from this department to other department fail, check again");
                break;
            }
            break;
        }
    }

    //calculate personal tax for employee
    public void calculatePersonalTaxSV() {
        System.out.println("---------/CALCULATE PERSONAL TAX OF EMPLOYEE/----------------------------------------------------------------------------------------------------------------------------------------------------");
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("---------Suggest Message----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Do you remember employee id which you want to search tax ?");
            System.out.println("[1]--> Yes, i remember employee information for finance id");
            System.out.println("[0]--> No, exit menu to see finance id again");
            System.out.printf("Input option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("Type of data-input is incorrect, select again!!");
            }
            if (option < 0 || option > 1) {
                System.out.println("Option list have [0] or [1], select again !!");
            }
            switch (option) {
                case 1:
                    /*Employee employee = searchEmployeeSV();*/
                    System.out.println("Input employee ID to get personal tax !!");
                    Employee tempEmp = new Employee();
                    boolean flag_case1 = false;
                    while (!flag_case1) {
                        String tempCase1 = inputEmployeeIDSV();
                        long tempCase1L = Long.parseLong(tempCase1);
                        if (tempCase1 != null&&getByEmployeeIDDB(tempCase1L)!=null) {
                            System.out.println("------/SEARCH RESULT: EMPLOYEE INFORMATION/----------------------------------------------------------------------------------------------------------------------------------");
                            displayDetailsEmployeeSV(getByEmployeeIDDB(tempCase1L));
                            tempEmp = getByEmployeeIDDB(tempCase1L);///
                            break;
                        }
                        if (tempCase1 != null&&getByEmployeeIDDB(tempCase1L)==null) {
                            System.out.println("------/SEARCH RESULT/--------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("No exist employee with ID as above !!");
                            tempEmp=null;
                            break;
                        }
                    }
                    int dQty=0;
                    while (true) {
                        System.out.println("---Suggest Message--------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        String tempQty = inputQuantityDependentPerson();
                        long tempQtyL = Long.parseLong(tempQty);
                        if (tempQty != null) {
                            dQty = (int) tempQtyL;
                            break;
                        }
                    }
                    if (tempEmp != null) {
                        String fullname = tempEmp.getFirst_name() + " " + tempEmp.getLast_name();
                        //get finance by fin_id of employee
                        Finance finance = financeDao.getByFinanceIDDB(tempEmp.getFin_id());

                        //have finance --> calculate salary
                        double personalIncomeTax = 11000000.0; //11,000,000 vnd
                        double depentdentTax = dQty*4400000; // 4,400,000 / person
                        double tempBHXHR = finance.getInsurance();
                        double rateBHXH = tempBHXHR/100.0 /*finance.getInsurance()*/; //8% or depend company
                        double rateBHYT = (1.5 / 100.0); //1,5%
                        double rateBHTN = (1 / 100.0); //1%
                        double tempAllBH = rateBHTN + rateBHXH + rateBHYT;
                        double tempSalary = finance.getSalary_rage();
                        double tempAnnual = finance.getAnnual();


                        double allPerTaxNoAnnual = financeDao.calculatePersonalTax(tempSalary,personalIncomeTax,depentdentTax,0.0);
                        double allPerTaxHasAnnual = financeDao.calculatePersonalTax(tempSalary,personalIncomeTax,depentdentTax,tempAnnual);
                        double allBHTax = tempSalary * tempAllBH;
                        double actualSalaryReceverNoAnnual = (tempSalary + 0) - (allPerTaxNoAnnual) - (allBHTax);
                        double actualSalaryReceverHasAnnual = (tempSalary + tempAnnual) - (allPerTaxNoAnnual) - (allBHTax);
                        System.out.println("---------/PERSONAL TAX OF EMPLOYEE RESULT/-------------------------------------------------------------------------------------------------------------------------//--------");
                        System.out.println("--/PER MONTH/------/NO ANNUAL/---------------------------------------------------------------------------------------------------------------------------------------//------");
                        System.out.printf(" [+] Employee [Name = %s, ID= %d] \n", fullname, tempEmp.getEmp_id());
                        System.out.printf(" [+] SalaryIncome = %.2f\n",tempSalary);
                        System.out.printf(" [+] rate BHXH = %.2f\n",rateBHXH);
                        System.out.printf(" [+] rate BHXH = %.2f\n",rateBHYT);
                        System.out.printf(" [+] rate BHXH = %.2f\n",rateBHTN);
                        System.out.printf(" [+] Rate (BHXH+BHYT+BHTN) = %.3f\n",tempAllBH*100.0);
                        System.out.printf(" [+] All BHXH = %.2f\n",allBHTax);
                        System.out.printf(" [+] Personal Tax per month = %.2f\n",allPerTaxNoAnnual);
                        System.out.printf(" [+] DependPersonQuatity = %d\n",dQty);
                        System.out.printf(" [+] Dependent person tax reduction = %.2f\n",depentdentTax);
                        System.out.printf(" [+] Actual receive Salary = (SalaryIncome - Personal Tax - All BHXH) = %.2f\n ", actualSalaryReceverNoAnnual);

                        System.out.println("--/ON THE DECEMBER/ ------/HAVE ANNUAL/-------------------------------------------------------------------------------------------------------------------------------//----");
                        System.out.printf(" [+] Employee [Name = %s, ID= %d] \n", fullname, tempEmp.getEmp_id());
                        System.out.printf(" [+] SalaryIncome = %.2f\n",tempSalary);
                        System.out.printf(" [+] Annual = %.2f\n",tempAnnual);
                        System.out.printf(" [+] Rate (BHXH+BHYT+BHTN) = %.3f\n",tempAllBH*100.0);
                        System.out.printf(" [+] All BHXH = %.2f\n",allBHTax);
                        System.out.printf(" [+] Personal Tax per month = %.2f\n",allPerTaxHasAnnual);
                        System.out.printf(" [+] DependPersonQuatity = %d\n",dQty);
                        System.out.printf(" [+] Dependent person tax reduction = %.2f\n",depentdentTax);
                        System.out.printf(" [+] Actual receive Salary = (SalaryIncome + Annual - Personal Tax - All BHXH) = %.2f\n ", actualSalaryReceverHasAnnual);

                    }
                    System.out.println("Back to menu >>");
                    break;
                case 0:
                    break;
            }
            break;// after select case 1, exit break.
        } while (option!=0);
    }

    //menu manageDepartmentSV for admin
    private static void showEmployeeMenuSV(){
        System.out.println("---/MANAGE EMPLOYEE MENU/-----|ADMIN|-----------------------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all employee");
        System.out.println("[2] --> Get employee information by ID");
        System.out.println("[3] --> Search employee more options ");
        System.out.println("[4] --> Calculate Personal Tax for employee");
        System.out.println("[5] --> Create new employee");
        System.out.println("[6] --> Update or edit employee information");
        System.out.println("[7] --> Change department of employee");
        System.out.println("[8] --> Delete employee");
        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }

    //for admin
    public void manageEmployeeSV() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n---------------|FOR ADMIN|----------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showEmployeeMenuSV();
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
                    showListEmployeeNoCondtion(); //
                    break;
                case 2:
                    getInformationByIDSV();
                    break;
                case 3:
                    searchEmployeeSV(); ///
                    break;
                case 4:
                    calculatePersonalTaxSV(); ///?
                    break;
                case 5:
                    createNewEmployeeSV(); //bug : cant out loop update department id
                    break;
                case 6:
                    updateEmployeeSV(); // if not exist, can out loop dept id
                    break;
                case 7:
                    updateDeptForEmployeeSV(); //can out loop or must insert all to break
                    break;
                case 8:
                    deleteEmployeeSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }


    //menu manageDepartmentSV USER
    private static void showEmployeeMenuSVUS(){
        System.out.println("---/MANAGE EMPLOYEE MENU/-----|FOR USER MODE|-----------------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all employee");
        System.out.println("[2] --> Get employee information by ID");
        System.out.println("[3] --> Search employee more options ");
        System.out.println("[4] --> Calculate Personal Tax for employee");

        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }
    //for user
    public void manageEmployeeSVUS() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showEmployeeMenuSVUS();
            System.out.printf("Input Option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input data is wrong, again");
                continue;
            }
            if (option < 0 || option > 4) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input option again, out option !!");
                continue;
            }
            switch (option) {
                case 1:
                    showListEmployeeNoCondtionUS(); //USER
                    break;
                case 2:
                    getInformationByIDSV();
                    break;
                case 3:
                    searchEmployeeSV(); ///
                    break;
                case 4:
                    calculatePersonalTaxSV(); ///?
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }


}
