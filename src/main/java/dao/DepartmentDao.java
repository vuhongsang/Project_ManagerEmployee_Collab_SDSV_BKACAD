package dao;

import connect.MyConnection;
import model.Department;
import model.Employee;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DepartmentDao {
    private BaseDao baseDao = new BaseDao();
    //get all information of departments
    public List<Department> getAllDepartmentDB() {
        //create list to add department to  department list
        List<Department> departmentList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT * from `Departments`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create Department is empty data in order to input
                Department department = new Department();
                department.setDept_id(resultSet.getLong("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setDept_address(resultSet.getString("dept_address"));
                department.setDept_phone(resultSet.getLong("dept_phone"));
                department.setDept_task(resultSet.getString("dept_task"));
                department.setDept_manager(resultSet.getLong("dept_manager"));
                //add to list
                departmentList.add(department);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return departmentList;
    }

    //get department by department ID
    public Department getByDepartmentIDDB(long dept_id) {
        Department department = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Departments` WHERE `dept_id` = " + dept_id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                department = new Department();
                department.setDept_id(resultSet.getLong("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setDept_address(resultSet.getString("dept_address"));
                department.setDept_phone(resultSet.getLong("dept_phone"));
                department.setDept_task(resultSet.getString("dept_task"));
                department.setDept_manager(resultSet.getLong("dept_manager"));
            }

            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    //get department by dept phone
    public Department getByDepartmentPhoneDB(long dept_phone) {
        Department department = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Departments` WHERE `dept_phone` = " + dept_phone + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                department = new Department();
                department.setDept_id(resultSet.getLong("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setDept_address(resultSet.getString("dept_address"));
                department.setDept_phone(resultSet.getLong("dept_phone"));
                department.setDept_task(resultSet.getString("dept_task"));
                department.setDept_manager(resultSet.getLong("dept_manager"));
            }

            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    //get department by manager ID
    public Department getByManagerID(long dept_manager) {
        Department department = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Departments` WHERE `dept_manager` = " + dept_manager + " LIMIT 10";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                department = new Department();
                department.setDept_id(resultSet.getLong("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setDept_address(resultSet.getString("dept_address"));
                department.setDept_phone(resultSet.getLong("dept_phone"));
                department.setDept_task(resultSet.getString("dept_task"));
                department.setDept_manager(resultSet.getLong("dept_manager"));
            }

            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    //get department by Department Name
    public Department getByDepartmentNameDB(String dept_name) {
        Department department = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = String.format("SELECT * FROM `Departments` WHERE `dept_name` = '%s' LIMIT 10",dept_name);
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                department = new Department();
                department.setDept_id(resultSet.getLong("dept_id"));
                department.setDept_name(resultSet.getString("dept_name"));
                department.setDept_address(resultSet.getString("dept_address"));
                department.setDept_phone(resultSet.getLong("dept_phone"));
                department.setDept_task(resultSet.getString("dept_task"));
                department.setDept_manager(resultSet.getLong("dept_manager"));
            }

            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }

    //create department
    public void createDepartmentDB(Department dept) {
        if (getByDepartmentIDDB(dept.getDept_id()) != null) {
            System.out.println("can't create Department, ID is duplicate");
            return;
        }
        if (getByDepartmentNameDB(dept.getDept_name()) != null) {
            System.out.println("can't create Department, department name is duplicate");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("INSERT INTO `Departments` (`dept_name`,`dept_address`,`dept_phone`,`dept_task`,`dept_manager`) VALUES ('%s','%s','%d','%s','%d')",
                    dept.getDept_name(),dept.getDept_address(),dept.getDept_phone(),dept.getDept_task(),dept.getDept_manager()
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("create new department fail !!");
            } else {
                System.out.println("create new department successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete department with searching ID
    public void deleteDepartmentWithIDDB(long dept_id) {
        if (getByDepartmentIDDB(dept_id)==null) {
            System.out.println("Department have ID not exist");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM `Departments` WHERE `dept_id`= " + dept_id;

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete department fail !!");
            } else {
                System.out.println("Delete department successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete department by searching Department Name
    public void deleteDepartmentWithDeptNameDB(String dept_name) {
        if (getByDepartmentNameDB(dept_name)==null) {
            System.out.println("can't delete,department have ID not exist");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `Departments` WHERE `dept_name`='%s'",dept_name);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete department fail !!");
            } else {
                System.out.println("delete department successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update information department or edit
    public void updateDepartmentWithIDDB(long dept_id,Department dept) {
        if (getByDepartmentIDDB(dept_id)==null) {
            System.out.println("Department has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Departments` SET `dept_name` = '%s',`dept_address` = '%s',`dept_phone` = '%d',`dept_task` = '%s',`dept_manager` = '%d' WHERE (`dept_id` = '%d')",
              dept.getDept_name(),dept.getDept_address(),dept.getDept_phone(),dept.getDept_task(),dept.getDept_manager(),dept_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this department (id= %d) be updated completely ^^",dept_id);
            } else {
                System.out.printf("updated department (id= %d) is failure :((",dept_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update department by name
    public void updateDepartmentWithNameDB(String dept_name,Department dept)    {
        if (getByDepartmentNameDB(dept_name)==null) {
            System.out.println("Department has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Departments` SET `dept_name` = '%s',`dept_address` = '%s',`dept_phone` = '%d',`dept_task` = '%s',`dept_manager` = '%d' WHERE (`dept_name` = '%s')",
                    dept.getDept_name(),dept.getDept_address(),dept.getDept_phone(),dept.getDept_task(),dept.getDept_manager(),dept_name
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this department (name= %s) be updated completely ^^",dept_name);
            } else {
                System.out.printf("updated department (name= %s) is failure :((",dept_name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------ESC-------------------------------------------------------

    //get list employee same deptID
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

    //update department for employee same deptId
    public void updateDeptOfEmployeeDB(long emp_id, long dept_id) {
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

    //-----------------------Service-------------------------------------------------

    public void displayDetailsDepartmentSV(Department dept) {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s \n", "Dept.ID", "Dept.Name", "Dept.Address", "PhoneNumber", "Task", "ManagerID");
        System.out.printf("%-20d ", dept.getDept_id());
        System.out.printf("%-22s", dept.getDept_name());
        System.out.printf("%-22s", dept.getDept_address());
        System.out.printf("%-20d", dept.getDept_phone());
        System.out.printf("%-20s ", dept.getDept_task());
        System.out.printf("%-20s ", dept.getDept_manager());
        System.out.printf("\n");
    }

    public void showListDepartmentSV() {
        List<Department> departmentList = getAllDepartmentDB();
        System.out.println("\n------|MANAGE DEPARTMENT|-->/SHOW LIST DEPARTMENT/-----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-25s %-20s %-20s %-40s %-20s \n", "Dept.ID", "Dept.Name", "Dept.Address", "PhoneNumber", "Task", "ManagerID");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Department dept : departmentList) {
            System.out.printf("%-20d ", dept.getDept_id());
            System.out.printf("%-25s", dept.getDept_name());
            System.out.printf("%-22s", dept.getDept_address());
            System.out.printf("%-20d ", dept.getDept_phone());
            System.out.printf("%-40s ", dept.getDept_task());
            System.out.printf("%-20s ", dept.getDept_manager());
            System.out.printf("\n");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void getInformationByDeptIDSV() {
        System.out.println("\n------|MANAGE DEPARTMENT|-->/GET INFORMATION BY DEPT.ID /--------------------------------------------------------------------------------------------------------------------");
        Employee employee = new Employee();
        boolean flag_DeptID = false;
        while (!flag_DeptID) {
            String tempDeptID = inputDepartmentIDSV();
            long tempDeptIDL = Long.parseLong(tempDeptID);
            if (tempDeptID != null && getByDepartmentIDDB(tempDeptIDL) != null) {
                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                displayDetailsDepartmentSV(getByDepartmentIDDB(tempDeptIDL));
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("---------Waring Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Department ID not exist, input again");
            break;
        }
    }

    public String inputDepartmentIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Department ID : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input Department ID fail, try again");
                System.out.println("Department ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputDepartmentNameSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.printf("Input department name : ");
            temp = in.next();//
            if (!baseDao.hasOnlyNumbersAndLetter(temp)) {
                System.out.println("Name has special symbol or number, input again!!");
                System.out.println("examples : Vu1, VU, vu --> OK");
                System.out.println("examples : V?* --> NG");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputDeptAddressSV() {
            String temp = null;
            do {
                Scanner in = new Scanner(System.in);
                System.out.printf("Input department address : ");
                temp = in.next();
                if (temp.length() == 0) {
                    System.out.println("must input content, not null");
                } else {
                    return temp;
                }
            } while (temp != null);
            return null;
    }

    public String inputDeptPhoneSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input dept phone: ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input phone number failure!!");
                System.out.println("phone number only number, not include(aZ,symbol)!!");
                System.out.println("Input again :((");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputDeptTaskSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input department task : ");
            temp = in.next();
            if (temp.length() == 0) {
                System.out.println("must input content, not empty");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputDeptManagerSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input manager ID (null=0): ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input manager id fail, try again");
                System.out.println("Manager ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public void createNewDepartmentSV() {
        System.out.println("---|MANAGE DEPARTMENT|-->/CREATE NEW DEPARTMENT/------------------------------------------------------------------------------------------------------------------------------");
        Department dept = new Department();

        boolean flag_DeptName = false;
        while (!flag_DeptName) {
            String tempDeptName = inputDepartmentNameSV();
            if (tempDeptName != null&&getByDepartmentNameDB(tempDeptName)==null) {
                dept.setDept_name(tempDeptName);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Duplicate department name, input again !");
        }
        String tempDeptAddress = inputDeptAddressSV();
        if (tempDeptAddress != null) {
            dept.setDept_address(tempDeptAddress);
        }
        String tempDeptPhone = inputDeptPhoneSV();
        if (tempDeptPhone != null) {
            dept.setDept_phone(Long.parseLong(tempDeptPhone));
        }
        String tempDeptTask = inputDeptTaskSV();
        if (tempDeptTask != null) {
            dept.setDept_task(tempDeptTask);
        }
        String tempDepManager = inputDeptManagerSV();
        if (tempDeptPhone != null) {
            dept.setDept_phone(Long.parseLong(tempDeptPhone));
        }
        createDepartmentDB(dept);
    }

    public void updateDepartmentSV() {
        System.out.println("------/MANAGE DEPARTMENT/>>/UPDATE DEPARTMENT/ -----------------------------------------------------------------------------------------------------------------------------------");
        Department dept = new Department();

        //dept ID
        boolean flag_DeptID = false;
        while (!flag_DeptID) {
            String tempDeptID = inputDepartmentIDSV();
            long tempDeptIDL = Long.parseLong(tempDeptID);
            if (tempDeptID != null && getByDepartmentIDDB(tempDeptIDL) != null) {
                dept.setDept_id(tempDeptIDL);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Department ID not exist, input again");
        }

        //DeptName
        boolean flag_DeptName = false;
        while (!flag_DeptName) {
            String tempDeptName = inputDepartmentNameSV();
            Department tempDN = getByDepartmentIDDB(dept.getDept_id());
            String tempDN2 = tempDN.getDept_name();
            if (tempDeptName != null && tempDN2.equalsIgnoreCase(tempDeptName)) {
                System.out.println("Same old name department, no change ^^");
                dept.setDept_name(tempDeptName);
                break;
            }
            if (tempDeptName != null&&getByDepartmentNameDB(tempDeptName)==null) {
                dept.setDept_name(tempDeptName);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("duplicate department name, input again");
        }

        //deptAdress
        String tempDeptAddress = inputDeptAddressSV();
        if (tempDeptAddress != null) {
            dept.setDept_address(tempDeptAddress);
        }

        //deptPhone
        boolean flag_DeptPhone = false;
        while (!flag_DeptPhone) {
            String tempDeptPhone = inputDeptPhoneSV();
            long tempDeptPhoneL = Long.parseLong(tempDeptPhone);
            Department tempDP = getByDepartmentIDDB(dept.getDept_id());
            long tempDPL = tempDP.getDept_phone();
            if (tempDeptPhone != null && (tempDeptPhoneL == tempDPL)) {
                System.out.println("old phone number, no change");
                dept.setDept_phone(tempDeptPhoneL);
                break;
            }
            else if (tempDeptPhone != null && getByDepartmentPhoneDB(tempDeptPhoneL) == null) {
                dept.setDept_phone(tempDeptPhoneL);
                /*insert ok and no duplicate*/
                break;
            }
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Duplicate dept phone with others, input again");
        }

        //dept task
        String tempDeptTask = inputDeptTaskSV();
        if (tempDeptTask != null) {
            dept.setDept_task(tempDeptTask);
        }

        //deptManager
        boolean flag_DeptManager = false;
        while (!flag_DeptManager) {
            String tempDeptM = inputDeptManagerSV();
            long tempDeptML = Long.parseLong(tempDeptM);
            if (tempDeptM != null && getByManagerID(tempDeptML) != null) {
                dept.setDept_manager(tempDeptML);
                /*System.out.println("insert finID OK");*/
                break;
            }
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Department only 1 manager per dept, input again");
        }
        updateDepartmentWithIDDB(dept.getDept_id(),dept);
        /*System.out.println(dept.getDept_id());
        System.out.println(dept);*/
    }

    public void deleteDepartmentSV() {
        System.out.println("-----|MANAGE DEPARTMENT|-->/DELETE DEPARTMENT/---------------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("B1: Input |department ID from| && |department ID To| for moving ");
        System.out.println("B2: Delete Department");
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("---------Suggest Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Do u remember your department information ?");
            System.out.println("[1] --> No, show list department");
            System.out.println("[0] --> Yes, skip");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- -------------------");
            System.out.printf("Input option= ");

            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Type of data-input is incorrect, select again!!");
            }
            if (option < 0 || option > 1) {
                System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Option list have [0] or [1], select again !!");
            }
            switch (option) {
                case 0:
                    break;
                case 1:
                    showListDepartmentSV();
                    break;
            }
        } while (option!=0);
        /*in.close();*/

        //get ID of department From & department To
        long tempDeptFromID=0;
        long tempDeptToID=0;
        //-----------------------------------------------------------
        boolean flag_DeptIDF = false;
        while (!flag_DeptIDF) {
            System.out.printf("-----DEPARTMENT.ID FROM----------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
            String tempDeptID = inputDepartmentIDSV();
            long tempDeptIDL = Long.parseLong(tempDeptID);
            if (tempDeptID != null && getByDepartmentIDDB(tempDeptIDL) != null) {
                tempDeptFromID=tempDeptIDL;
                break;
            }
            System.out.print("-----Warning Message---------------------------------------------------------------------------------------------------------------------------------------------------//---- \n");
            System.out.println("Department ID not exist, input again");
        }
        //get List employee of department from
        List<Employee> listEOFM = getAllEmployeeSameDeptIDDB(tempDeptFromID);
        if (listEOFM.size() == 0) {
            System.out.println("------DELETE DEPARTMENT STATUS-------------------\\--------------------------");
            System.out.println("No any employee has department id. Delete old department --> start !");
            deleteDepartmentWithIDDB(tempDeptFromID);
        }else {
            boolean flag_DeptIDT = false;
            while (!flag_DeptIDT) {
                System.out.print("-----DEPARTMENT.ID TO---------------------------------------------------------------------------------------------------------------------------------------------------//---- \n");
                String tempDeptID = inputDepartmentIDSV();
                long tempDeptIDL = Long.parseLong(tempDeptID);
                if (tempDeptID != null && getByDepartmentIDDB(tempDeptIDL) != null) {
                    tempDeptToID = tempDeptIDL;
                    break;
                }
                System.out.print("-----Warning Message---------------------------------------------------------------------------------------------------------------------------------------------------//---- \n");
                System.out.println("Department ID not exist, input again");
            }
            System.out.printf("----STATUS MOVE EMPLOYEE FROM DEPARTMENT ID /%d/ TO /%d/----------------------------------------------------------------------------------------------------------------------\n", tempDeptFromID, tempDeptToID);
            for (Employee e : listEOFM) {
                updateDeptOfEmployeeDB(e.getEmp_id(), tempDeptToID);
            }
            System.out.println("All employees be set new department. Can delete old department !!");
            System.out.println("------/Delete Department Status/----------------------------------------------------------------------------------------------------------------------------------------------------");
            deleteDepartmentWithIDDB(tempDeptFromID);
        }
    }

    //for admin
    private static void showDepartmentMenuSV(){
        System.out.println("---/MANAGER DEPARTMENT MENU/-------------------|FOR ADMIN MODE|--------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all department");
        System.out.println("[2] --> Get information of department by ID");
        System.out.println("[3] --> Create new department");
        System.out.println("[4] --> Update or edit department");
        System.out.println("[5] --> Delete department");
        System.out.println("[0] --> Exit ");
        System.out.println("-------------------------------------------------//--------------------------------------------------------------------------------------------------------------------------//-");

    }

    //for admin
    public void manageDepartmentSV() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n---------------------|FOR ADMIN MODE|-----------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showDepartmentMenuSV();
            System.out.printf("Input Option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input data is wrong, again");
                continue;
            }
            if (option < 0 || option > 5) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input option again, out option !!");
                continue;
            }
            switch (option) {
                case 1:
                    showListDepartmentSV();
                    break;
                case 2:
                    getInformationByDeptIDSV();
                    break;
                case 3:
                    createNewDepartmentSV();
                    break;
                case 4:
                    updateDepartmentSV();
                    break;
                case 5:
                    deleteDepartmentSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

    //for user
    private static void showDepartmentMenuSVUS(){
        System.out.println("---/MANAGER DEPARTMENT MENU/-------------------|FOR USER MODE|--------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all department");
        System.out.println("[2] --> Get information of department by ID");
        System.out.println("[0] --> Exit ");
        System.out.println("-------------------------------------------------//--------------------------------------------------------------------------------------------------------------------------//-");

    }

    //for user
    public void manageDepartmentSVUS() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showDepartmentMenuSVUS();
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
                    showListDepartmentSV();
                    break;
                case 2:
                    getInformationByDeptIDSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

}
