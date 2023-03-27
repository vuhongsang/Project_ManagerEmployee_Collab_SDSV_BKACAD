package dao;

import connect.MyConnection;
import model.Employee;
import model.Finance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceDao {
    private BaseDao baseDao = new BaseDao();
    private DepartmentDao departmentDao = new DepartmentDao();

    //get all information about finances
    public List<Finance> getAllFinanceDB() {
        //create list to add finance to  finance list
        List<Finance> financeList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT * from `Finances`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create Department is empty data in order to input
                Finance finance = new Finance();
                finance.setFin_id(resultSet.getLong("fin_id"));
                finance.setFin_name(resultSet.getString("fin_name"));
                finance.setSalary_rage(resultSet.getDouble("salary_rage"));
                finance.setInsurance(resultSet.getDouble("insurance"));
                finance.setAnnual(resultSet.getDouble("annual"));
                //add to list
                financeList.add(finance);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return financeList;
    }

    //get information by searching ID
    public Finance getByFinanceIDDB(long fin_id) {
        Finance finance = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Finances` WHERE `fin_id` = " + fin_id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                finance = new Finance();
                finance.setFin_id(resultSet.getLong("fin_id"));
                finance.setFin_name(resultSet.getString("fin_name"));
                finance.setSalary_rage(resultSet.getDouble("salary_rage"));
                finance.setInsurance(resultSet.getDouble("insurance"));
                finance.setAnnual(resultSet.getDouble("annual"));
            }

            // close connect
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finance;
    }

    //get information by searching fin_name
    public Finance getByFinanceNameDB(String fin_name) {
        Finance finance = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `Finances` WHERE `fin_name` = '" + fin_name + "' LIMIT 10";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                finance = new Finance();
                finance.setFin_id(resultSet.getLong("fin_id"));
                finance.setFin_name(resultSet.getString("fin_name"));
                finance.setSalary_rage(resultSet.getDouble("salary_rage"));
                finance.setInsurance(resultSet.getDouble("insurance"));
                finance.setAnnual(resultSet.getDouble("annual"));
            }

            // close connect
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finance;
    }

    //create new finances
    public void createFinanceDB(Finance fin) {
        if (getByFinanceIDDB(fin.getFin_id()) != null) {
            System.out.println("can't create Finance, ID is duplicate");
            return;
        }
        if (getByFinanceNameDB(fin.getFin_name()) != null) {
            System.out.println("can't create Finance, finance name is duplicate");
            return;
        }

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("INSERT INTO `Finances` (`fin_name`,`salary_rage`,`insurance`,`annual`) VALUES ('%s','%.2f','%.2f','%.2f')",
                fin.getFin_name(),fin.getSalary_rage(),fin.getInsurance(),fin.getAnnual()
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("create new finance fail !!");
            } else {
                System.out.println("create new finance successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete finance by searching ID
    public void deleteFinanceByIDDB(long fin_id) {
        if (getByFinanceIDDB(fin_id)==null) {
            System.out.println("This finance have ID not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM `Finances` WHERE `fin_id`= " + fin_id;

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete finance fail !!");
            } else {
                System.out.println("delete finance successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete finance by searching finance name
    public void deleteFinanceByNameDB(String fin_name) {
        if (getByFinanceNameDB(fin_name)==null) {
            System.out.println("This finance have ID not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `Finances` WHERE `fin_name`= '%s'",fin_name);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet == 0) {
                System.out.println("delete finance fail !!");
            } else {
                System.out.println("delete finance successfully ^^");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update finance
    public void updateFinanceWithIDDB(long fin_id, Finance fin)  {
        if (getByFinanceIDDB(fin_id)==null) {
            System.out.println("Finance has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Finances` SET `fin_name` = '%s', `salary_rage` = '%.2f', `insurance` = '%.2f',`annual` = '%.2f' WHERE (`fin_id` = '%d')",
                    fin.getFin_name(),fin.getSalary_rage(),fin.getInsurance(),fin.getAnnual(),fin_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this finance (id= %d) be updated completely ^^",fin_id);
            } else {
                System.out.printf("updated finance (id= %d) is failure :((",fin_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------ETC-------------------------------

    //get list employee same fin_id
    public List<Employee> getAllEmployeeSameFinIDDB(long fin_id) {
        //create list to add Employee to list employee
        List<Employee> employeeList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = String.format("SELECT * from `Employees` WHERE `fin_id`='%d'",fin_id);

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

    //update finance for employee same fin_id
    public void updateFinOfEmployeeDB(long emp_id, long fin_id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Employees` SET `fin_id` = '%d' WHERE (`emp_id` = '%d')",
                    fin_id,emp_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this Employee (id= %d, new finance id = %d) be updated completely ^^", emp_id,fin_id);
            } else {
                System.out.printf("updated employee (id= %d) is failure :((", emp_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------SV Service--------------------------
    public String inputFinanceIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Finance ID : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input Finance ID fail, try again");
                System.out.println("Finance ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputFinanceNameSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("------------------------------------------------");
            System.out.printf("Input finance name : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumbersAndLetter(temp)) {
                System.out.println("finance name has special symbol or number, input again!!");
                System.out.println("examples : Vu, VU, vu, VU1, V8u --> OK");
                System.out.println("examples : V?* --> NG");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputFinanceSalaryRangeSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input salary range : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumberAndOneDot(temp)) {
                System.out.println("Input salary range fail, try again");
                System.out.println("Salary only include number and 1 dot  (2.3 2 -->OK | 2. 2? 2a --> NG)!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputInsuranceSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input Insurance : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumberAndOneDot(temp)) {
                System.out.println("Input insurance fail, try again");
                System.out.println("Insurance only include number and 1 dot  (2.3 2 --> OK | 2. 2? 2a -->NG) !! ");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputAnnualSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input annual : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumberAndOneDot(temp)) {
                System.out.println("Input annual fail, try again");
                System.out.println("Annual only include number and 1 dot (2.3 2 -->OK | 2. 2? 2a --> NG)!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public void showAllFinanceNonConditionSV() {
            List<Finance> financeList = getAllFinanceDB();
            System.out.println("------LIST ALL FINANCE INFORMATION-------------");
            System.out.printf("%-15s %-25s %-20s %-25s %-25s \n", "fin_id", "fin_name", "salary_rage", "insurance(%)", "annual");
            for (Finance fin  : financeList) {
                System.out.printf("%-15s", fin.getFin_id());
                System.out.printf("%-25s", fin.getFin_name());
                System.out.printf("%-25.2f", fin.getSalary_rage());
                System.out.printf("%-25.2f", fin.getInsurance());
                System.out.printf("%-25.2f ", fin.getAnnual());
                System.out.printf("\n");
            }
    }

    public void showFinanceByFinIDSV(Finance fin) {
        System.out.printf("%-20s %-25s %-25s %-25s %-25s \n", "fin_id", "fin_name", "salary_rage", "insurance","annual");
        System.out.printf("%-20s", fin.getFin_id());
        System.out.printf("%-25s", fin.getFin_name());
        System.out.printf("%-25.2f", fin.getSalary_rage());
        System.out.printf("%-25.2f", fin.getInsurance());
        System.out.printf("%-25.2f ", fin.getAnnual());
        System.out.printf("\n");
    }

    public void getAllFinanceByFinIDSV() {
        System.out.println("-------/FINANCE INFORMATION BY SEARCHING ID/----------------------------------------------------------------------------------------------------------------------------------------");
        boolean flag_FinID = false;
        while (!flag_FinID) {
            String tempFinID = inputFinanceIDSV();
            long tempFinIDL = Long.parseLong(tempFinID);
            if (tempFinID != null&&getByFinanceIDDB(tempFinIDL)!=null) {
                System.out.println("------Search result-------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                showFinanceByFinIDSV(getByFinanceIDDB(tempFinIDL));
                break;
            }
            if (tempFinID != null&&getByFinanceIDDB(tempFinIDL)==null) {
                System.out.println("------Search result--------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                System.out.println("No exist finance with ID as above !!");
                break;
            }
        }
    }

    //create new finance
    public Finance createNewFinanceSV() {
        System.out.println("------CREATE NEW FINANCE---------");
        Finance finance  = new Finance();

        boolean flag_FinName = false;
        while (!flag_FinName) {
            String tempFinName = inputFinanceNameSV();
            if (tempFinName != null&&getByFinanceNameDB(tempFinName)==null) {
                finance.setFin_name(tempFinName);
                break;
            }
            System.out.println("duplicate finance name, input again");
        }

        String tempSalary = inputFinanceSalaryRangeSV();
        double tempSalaryL = Double.parseDouble(tempSalary);
        if (tempSalary != null) {
            finance.setSalary_rage(tempSalaryL);
        }

        String tempInsurance = inputInsuranceSV();
        double tempInsuranceL = Double.parseDouble(tempInsurance);
        if (tempInsurance != null) {
            finance.setInsurance(tempInsuranceL);
        }

        String tempAnnual = inputAnnualSV();
        double tempAnnualL = Double.parseDouble(tempAnnual);
        if (tempAnnual != null) {
            finance.setAnnual(tempAnnualL);
        }

        createFinanceDB(finance);
        return finance;
    }

    //update and edit finance
    public void updateFinanceSV() {
        System.out.println("------UPDATE FINANCE INFORMATION ----------------------------------------------------------------------");
        Finance finance = new Finance();

        //dept ID
        boolean flag_FinID = false;
        while (!flag_FinID) {
            String tempFinID = inputFinanceIDSV();
            long tempFinIDL = Long.parseLong(tempFinID);
            if (tempFinID != null && getByFinanceIDDB(tempFinIDL) != null) {
                finance.setFin_id(tempFinIDL);
                break;
            }
            System.out.println("Finance ID not exist, input again");
        }

        //DeptName
        boolean flag_FinName = false;
        while (!flag_FinName) {
            String tempFinName = inputFinanceNameSV();
            Finance tempFN = getByFinanceIDDB(finance.getFin_id());
            String tempFN2 = tempFN.getFin_name();
            if (tempFinName != null && tempFN2.equalsIgnoreCase(tempFinName)) {
                System.out.println("Same old name department, no change ^^");
                finance.setFin_name(tempFinName);
                break;
            }
            if (tempFinName != null&&getByFinanceNameDB(tempFinName)==null) {
                finance.setFin_name(tempFinName);
                /*System.out.println("insert deptID OK");*/
                break;
            }
            System.out.println("duplicate finance name, input again");
        }

        //deptPhone
        boolean flag_FinSalary = false;
        while (!flag_FinSalary) {
            String tempFinSalary = inputFinanceSalaryRangeSV();
            double tempFinSalaryL = Double.parseDouble(tempFinSalary);
            Finance tempFS = getByFinanceIDDB(finance.getFin_id());
            double tempFSL = tempFS.getSalary_rage();
            if (tempFinSalaryL == tempFSL) {
                System.out.println("same old salary, no change value");
                finance.setSalary_rage(tempFinSalaryL);
                break;
            }
                finance.setSalary_rage(tempFinSalaryL);
                break;
        }

        boolean flag_FinInsurance = false;
        while (!flag_FinInsurance) {
            String tempFinInsurance = inputInsuranceSV();
            double tempFinInsuranceL = Double.parseDouble(tempFinInsurance);
            Finance tempFI = getByFinanceIDDB(finance.getFin_id());
            double tempFIL = tempFI.getInsurance();
            if (tempFinInsuranceL == tempFIL) {
                System.out.println("same old insurance, no change value");
                finance.setInsurance(tempFinInsuranceL);
                break;
            }
            finance.setInsurance(tempFinInsuranceL);
            break;
        }

        boolean flag_FinAnnual = false;
        while (!flag_FinAnnual) {
            String tempFinAnnual = inputAnnualSV();
            double tempFinAnnualL = Double.parseDouble(tempFinAnnual);
            Finance tempFA = getByFinanceIDDB(finance.getFin_id());
            double tempFAL = tempFA.getAnnual();
            if (tempFinAnnualL == tempFAL) {
                System.out.println("same old annual, no change value");
                finance.setAnnual(tempFinAnnualL);
                break;
            }
            finance.setAnnual(tempFinAnnualL);
            break;
        }

        updateFinanceWithIDDB(finance.getFin_id(),finance);
        /*System.out.println(finance.getFin_id());
        System.out.println(finance);*/
    }

    //delete finance
    public void deleteFinanceSV() {
        System.out.println("------DELETE FINANCE ------------------------------------------------------------------------------------");
        System.out.println("B1: Input |finance ID from| && |finance ID To| ");
        System.out.println("--> change employee have old finance ID to other finance");
        System.out.println("B2: Delete |finance from|");
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Do u remember your finance information ?");
            System.out.println("[1] --> No, show list");
            System.out.println("[0] --> Yes, skip");
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
                case 0:
                    break;
                case 1:
                    showAllFinanceNonConditionSV();
                    break;
            }
        } while (option!=0);

        //get ID of finance From & finance To
        long tempFinFromID=0;
        long tempFinToID=0;
        //-----------------------------------------------------------
        boolean flag_FinIDF = false;
        while (!flag_FinIDF) {
            System.out.printf("-----FINANCE.ID FROM---------------------//----- : \n");
            String tempFinID = inputFinanceIDSV();
            long tempFinIDL = Long.parseLong(tempFinID);
            if (tempFinID != null && getByFinanceIDDB(tempFinIDL) != null) {
                tempFinFromID=tempFinIDL;
                break;
            }
            System.out.println("Finance ID not exist, input again");
        }

        //get List employee have same old finance id
        List<Employee> listAESF = getAllEmployeeSameFinIDDB(tempFinFromID);
        if (listAESF.size() == 0) {
            System.out.println("----------------------------//--------------------------------//-----------------");
            System.out.println("No any employee has finance id. Delete old finance --> start !");
            deleteFinanceByIDDB(tempFinFromID);
        } else {
            boolean flag_FinIDT = false;
            while (!flag_FinIDT) {
                System.out.printf("-----FINANCE.ID TO ----------------------//---- \n");
                String tempFinID = inputFinanceIDSV();
                long tempFinIDL = Long.parseLong(tempFinID);
                if (tempFinID != null && getByFinanceIDDB(tempFinIDL) != null) {
                    tempFinToID = tempFinIDL;
                    break;
                }
                System.out.println("Finance ID not exist, input again");
            }

            System.out.printf("----STATUS CHANGE EMPLOYEE INFORMATION HAVE FINANCE ID FROM /%d/ TO /%d/-----------------\n", tempFinFromID, tempFinToID);
            for (Employee e : listAESF) {
                updateFinOfEmployeeDB(e.getEmp_id(), tempFinToID);
            }
            System.out.println("\nAll employees have already set new finance id, can delete old finance ");
            System.out.println("\n------DELETE FINANCE STATUS-------------------\\--------------------------");
            deleteFinanceByIDDB(tempFinFromID);
        }
    }

    //Personal income
    public double calculatePersonalTax(double salaryIncome, double personalIncomeTaxReduction, double dependentTaxReduction,double annual) {

        //salary after calculated personal tax and family tax and
        double allSalaryReceive=(salaryIncome+annual)-(personalIncomeTaxReduction+dependentTaxReduction);
        double allTax=0;

        if (allSalaryReceive >= 0 && allSalaryReceive <= 5000000) {
            allTax = allSalaryReceive * (5.0 / 100);
        }

        if (allSalaryReceive > 5000000 && allSalaryReceive <= 10000000) {
            allTax = allSalaryReceive * (10.0 / 100)-250000.0;
        }

        if (allSalaryReceive > 10000000 && allSalaryReceive <= 18000000) {
            allTax = allSalaryReceive * (15.0 / 100)-750000.0;
        }

        if (allSalaryReceive > 18000000 && allSalaryReceive <= 32000000) {
            allTax = allSalaryReceive * (20.0 / 100)-1650000.0;
        }

        if (allSalaryReceive > 32000000 && allSalaryReceive <= 52000000) {
            allTax = allSalaryReceive * (25.0 / 100)-3250000.0;
        }

        if (allSalaryReceive > 52000000 && allSalaryReceive <= 80000000) {
            allTax = allSalaryReceive * (30.0 / 100)-5850000.0;
        }
        if (allSalaryReceive > 80000000) {
            allTax = allSalaryReceive * (35.0 / 100)-9850000.0;
        }
        if (allSalaryReceive < 0) {
            allTax = 0;
        }
        return allTax;
    }


    //for admin
    private static void showFinanceMenuSV(){
        System.out.println("---/MANAGE FINANCE MENU/---------|FOR ADMIN MODE|-----------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all finances");
        System.out.println("[2] --> Get finance information by ID");
        System.out.println("[3] --> Create new finance");
        System.out.println("[4] --> Update or edit finance");
        System.out.println("[5] --> Delete finance");
        System.out.println("[0] --> Exit");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
    }
    public void manageFinanceSV() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n---------------------------|FOR ADMIN MODE|-----------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showFinanceMenuSV();
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
                    showAllFinanceNonConditionSV();
                    break;
                case 2:
                    getAllFinanceByFinIDSV();
                    break;
                case 3:
                    createNewFinanceSV();
                    break;
                case 4:
                    updateFinanceSV();
                    break;
                case 5:
                    deleteFinanceSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

    //for user
    private static void showFinanceMenuSVUS(){
        System.out.println("---/MANAGE FINANCE MENU/---------|FOR USER MODE|-----------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all finances");
        System.out.println("[2] --> Get finance information by ID");
        System.out.println("[0] --> Exit");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
    }
    public void manageFinanceSVUS() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showFinanceMenuSVUS();
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
                    getAllFinanceByFinIDSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

}
