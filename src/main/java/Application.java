import dao.*;
import model.Account;
import model.Department;
import model.Employee;
import model.Finance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static boolean isLoginSuccess = false;

    private static AccountDao accountDao=new AccountDao();
    private static EmployeeDao employeeDao = new EmployeeDao();
    private static DepartmentDao departmentDao = new DepartmentDao();
    private static FinanceDao financeDao = new FinanceDao();
    private static LeaveDao leaveDao = new LeaveDao();
    private static BaseDao baseDao = new BaseDao();

    private static void showMenuUS(){
        System.out.printf("\n-|HOME|--/MANAGER EMPLOYEE SYSTEM/--------|FOR USER MODE|---|account name: %s|------------------------------------------------------------------------------------------------------------------//-\n",tempAcc);
        System.out.println("[1] --> Manage Department");
        System.out.println("[2] --> Manage Employee");
        System.out.println("[3] --> Manage Finance");
        System.out.println("[4] --> Manage Leaves");
        System.out.println("[5] --> Manage Account");
        System.out.println("[0] --> Exit ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }
     static String tempAcc="";
    private static void showMenuAD(){
        System.out.printf("\n-|HOME|--/MANAGER EMPLOYEE SYSTEM/--------|FOR ADMIN MODE|----|account name: %s|-----------------------------------------------------------------------------------------------------------------//-\n",tempAcc);
        System.out.println("[1] --> Manage Department");
        System.out.println("[2] --> Manage Employee");
        System.out.println("[3] --> Manage Finance");
        System.out.println("[4] --> Manage Leaves");
        System.out.println("[5] --> Manage Account");
        System.out.println("[0] --> Exit ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countLoginFailure=0;
        long mode= 0;
        while (countLoginFailure < 3) {
            if(isLoginSuccess== false){
                //login & invalidate
                System.out.printf("\n--------/LOGIN ACCOUNT/--------|Login failure count %d|-------------------------------------------------------------------------------------------------------------------------------------------//-\n",countLoginFailure);
                String username=accountDao.inputAccountNameSV();
                String password = accountDao.inputAccountPasswordSV();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
                // check the resul of login (success or not )
                if (isLoginSuccess = accountDao.login(username, password)) {
                    tempAcc=username;
                    mode=accountDao.getByUserNameAndPasswordDB(username, password).getAccount_level();
                    countLoginFailure=0;
                    break;
                }
                countLoginFailure++;
                System.out.println("\n--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.printf("\nLogin failure, username or password is incorrect \n",countLoginFailure);
            }
        }
        if (countLoginFailure == 3) {
            System.out.println("You login account failure 3 time, exit to system ");
            System.exit(0);
        }
        if (mode == 0) {
            System.out.println("Login account for user mode completely !!");
            int optionUS=-1;
            do {
                System.out.println();
                System.out.println("Please select option in menu as below");
                showMenuUS();
                System.out.printf("Input Option= ");
                try {
                    optionUS = Integer.parseInt(in.next());
                } catch (Exception e) {
                    System.out.println("Input data is wrong, again");
                    continue;
                }
                if (optionUS < 0 || optionUS > 5) {
                    System.out.println("Input option again, out option !!");
                    continue;
                }
                switch (optionUS) {
                    case 1:
                        departmentDao.manageDepartmentSVUS();
                        break;
                    case 2:
                        employeeDao.manageEmployeeSVUS();
                        break;
                    case 3:
                        financeDao.manageFinanceSVUS();
                        break;
                    case 4:
                        leaveDao.manageLeavesSVUS();
                        break;
                    case 5:
                        accountDao.manageAccountSVUS();
                        break;
                    case 0:
                        break;
                }
            } while (optionUS!=0);
        }
        if(mode==1) {
            System.out.println("Login account for admin mode completely !!");
            int option = -1;
            do {
                System.out.println();
                System.out.println("Please select option in menu as below");
                showMenuAD();
                System.out.printf("Input Option= ");
                try {
                    option = Integer.parseInt(in.next());
                } catch (Exception e) {
                    System.out.println("Input data is wrong, again");
                    continue;
                }
                if (option < 0 || option > 5) {
                    System.out.println("Input option again, out option !!");
                    continue;
                }
                switch (option) {
                    case 1:
                        departmentDao.manageDepartmentSV();
                        break;
                    case 2:
                        employeeDao.manageEmployeeSV();
                        break;
                    case 3:
                        financeDao.manageFinanceSV();
                        break;
                    case 4:
                        leaveDao.manageLeavesSV();
                        break;
                    case 5:
                        accountDao.manageAccountSV();
                        break;
                    case 0:
                        break;
                }
            } while (option != 0);

            ///close input screen
        }
        in.close();
    }
}
