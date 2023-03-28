package dao;

import connect.MyConnection;
import model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDao {
    private BaseDao baseDao = new BaseDao();
    //search by account ID
    public Account getByAccountIdDB(long ac_id) {
        Account account = null;
        try {
            // create connection
            Connection conn = MyConnection.getConnection();
            //prepare statement and action
            String sql = "SELECT * FROM `accounts` WHERE `ac_id` = " + ac_id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // result
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                account = new Account();
                account.setAc_id(resultSet.getLong("ac_id"));
                account.setUser_name(resultSet.getString("user_name"));
            }
            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    //Search by user_name && user_pass
    public Account getByUserNameAndPasswordDB(String user_name, String user_pass) {
        Account account = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("SELECT ac_id, user_name, account_level FROM accounts WHERE user_name='%s' AND user_pass='%s' LIMIT 1 ",
                    user_name, user_pass);

            // THUC THI
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {
                account = new Account();
                account.setAc_id(resultSet.getLong("ac_id"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setAccount_level(resultSet.getLong("account_level"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    //get account_level by username and password


    //check by user
    public boolean getByUserNameExistDB(String user_name) {
        boolean exist = false;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("SELECT ac_id, user_name FROM accounts WHERE user_name='%s'  LIMIT 1 ",
                    user_name);

            // statement
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            //check exist
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    //get all for ac_id, user_name,...,ugr_id// add permission
    public List<Account> getAllInformationDB() {
        //create list to add account to list account
        List<Account> accountList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT `ac_id`,`user_name`,`account_level` from `Accounts`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create account is empty data in order to input
                Account account =new Account();
                account.setAc_id(resultSet.getLong("ac_id"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setAccount_level(resultSet.getLong("account_level"));
                accountList.add(account);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public List<Account> getAllInformationDBAD() {
        //create list to add account to list account
        List<Account> accountList = new ArrayList<>();
        try {
            // get connection
            Connection conn = MyConnection.getConnection();

            // set data send
            String sql = "SELECT * from `Accounts`";

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                // create account is empty data in order to input
                Account account =new Account();
                account.setAc_id(resultSet.getLong("ac_id"));
                account.setUser_name(resultSet.getString("user_name"));
                account.setUser_pass(resultSet.getString("user_pass"));
                account.setAccount_level(resultSet.getLong("account_level"));
                accountList.add(account);
            }
            //close connection
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    //add new account : u
    public void createAccountDB(String user_name, String user_pass) {
        if (getByUserNameExistDB(user_name)) {
            System.out.println("Account has registered by other people :((");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("INSERT INTO `Accounts` (`user_name`,`user_pass`) VALUES ('%s','%s')",
                    user_name,user_pass
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

    //delete new account : user_name// true --> display succes//false --> display false
    public void deleteAccountByUserNameDB(String user_name) {
        if (!getByUserNameExistDB(user_name)) {
            System.out.println("Account is used to delete not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `Accounts` WHERE `user_name` = '%s'",user_name);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (user_name= %s) be deleted completely ^^",user_name);
            } else {
                System.out.printf("Delete (user_name= %s) is failure :((",user_name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //delete account by search account ID
    public void deleteAccountByAccountIDDB(long ac_id) {
        if (getByAccountIdDB(ac_id)==null) {
            System.out.println("Account has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `Accounts` WHERE `ac_id` = '%d'",ac_id);

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (ac_id= %d) be deleted completely ^^",ac_id);
            } else {
                System.out.printf("Delete (user_name= %d) is failure :((",ac_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update account by search account ID
    public void updateAccountByAccountIDDB(long ac_id,String user_name,String user_pass) {
        if (getByAccountIdDB(ac_id)==null) {
            System.out.println("Account has ID as above be not exist");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Accounts` SET `user_name` = '%s', `user_pass` = '%s' WHERE (`ac_id` = '%d')",
                    user_name,user_pass,ac_id
                    );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (ac_id= %d) be updated completely ^^",ac_id);
            } else {
                System.out.printf("updated (ac_id= %d) is failure :((",ac_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //update account by search username
    public void updateAccountByUserNameAndPasswordDB(String user_name,String user_pass) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `Accounts` SET `user_name` = '%s', `user_pass` = '%s' WHERE (`user_name` = '%s')",
                    user_name,user_pass,user_name
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (user_name= %s) be updated completely ^^",user_name);
            } else {
                System.out.printf("update (user_name= %s) is failure :((",user_name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAccountAdminDB(long ac_id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `accounts` SET `account_level` = '1' WHERE (`ac_id` = '%d')",
                    ac_id
                    );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (ac_id= %d) be updated to admin level completely ^^",ac_id);
            } else {
                System.out.printf("updated (ac_id= %d) is failure :((",ac_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAccountAdminToUserDB(long ac_id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("UPDATE `accounts` SET `account_level` = '0' WHERE (`ac_id` = '%d')",
                    ac_id
            );

            // setting and check result receive back
            Statement stmt = conn.createStatement();
            long resultSet = stmt.executeUpdate(sql);
            if (resultSet != 0) {
                System.out.printf("this account (ac_id= %d) be updated to admin level completely ^^",ac_id);
            } else {
                System.out.printf("updated (ac_id= %d) is failure :((",ac_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------SERVICE-----------------------------------------

    public String inputAccountIDSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input account ID : ");
            temp = in.next();
            if (!baseDao.hasOnlyNumber(temp)) {
                System.out.println("Input account id fail, try again");
                System.out.println("account ID only include number!!");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputAccountNameSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input account name : ");
            temp = in.next();
            if (!baseDao.hasForAccountName(temp)) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input account name failure, try again");
                System.out.println("Username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase");
                System.out.println("Username allowed of the dot (.), underscore (_), and hyphen (-).");
                System.out.println("The dot (.), underscore (_), or hyphen (-) must not be the first or last character");
                System.out.println("The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public String inputAccountPasswordSV() {
        String temp = null;
        do {
            Scanner in = new Scanner(System.in);
            System.out.printf("Input account password : ");
            temp = in.next();
            if (!baseDao.hasForAccountPassword(temp)) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println(">> Input account password failure, try again");
                System.out.println(">> At least 8 characters");
                System.out.println(">> Contains at least one digit");
                System.out.println(">> Contains at least one lower alpha and one upper alpha");
                System.out.println(">> Contains at least one character in a set of special characters ( @#%$^ etc.)");
                System.out.println(">> Does not contain spaces, tabs, etc.");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-\n");
            } else {
                return temp;
            }
        } while (temp != null);
        return null;
    }

    public void showListAccountNoConditionSV() {
        List<Account> accountList = getAllInformationDBAD();
        System.out.println("\n------/LIST ALL ACCOUNT INFORMATION/-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-30s %-25s %-25s \n", "ID", "User Name", "User Pass", "Account Level");
        for (Account a : accountList) {
            System.out.printf("%-10s", a.getAc_id());
            System.out.printf("%-30s", a.getUser_name());
            System.out.printf("%-30s", a.getUser_pass());
            System.out.printf("%-30d", a.getAccount_level());
            System.out.println();
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void showListAccountNoConditionSVUS() {
        List<Account> accountList = getAllInformationDBAD();
        System.out.println("\n------/LIST ALL ACCOUNT INFORMATION/-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-30s %-25s \n", "ID", "User Name","Account Level");
        for (Account a : accountList) {
            System.out.printf("%-10s", a.getAc_id());
            System.out.printf("%-30s", a.getUser_name());
            System.out.printf("%-30d", a.getAccount_level());
            System.out.println();
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public boolean login(String user_name, String user_pass) {
        Account account = getByUserNameAndPasswordDB(user_name, user_pass);
        if(account == null){
            return false;
        }
        // Login completely ^^
        return true;
    }

    public void createNewDefaultAccountSV() {
        System.out.println("---|MANAGE ACCOUNT|-->/CREATE NEW ACCOUNT/------------------------------------------------------------------------------------------------------------------------------");
        /*Account account = new Account();*/
        boolean flag_accName = false;
        boolean flag_accPass = false;
        String tempName=null;
        String tempPass = null;
        while (true) {
            String tempAccountName = inputAccountNameSV();
            if (tempAccountName != null&& !getByUserNameExistDB(tempAccountName)) {
                tempName = tempAccountName;
                flag_accName = true;
                break;
            }
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Anyone has register with account name, input again !");
        }
        while (true) {
            String tempAccountPassword = inputAccountPasswordSV();
            if (tempAccountPassword != null) {
                tempPass = tempAccountPassword;
                flag_accPass = true;
                break;
            }
        }
        System.out.println(tempName);
        System.out.println(tempPass);
        if (flag_accName && flag_accPass) {
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            createAccountDB(tempName, tempPass);
        } else {
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Create new default account failure, try later !!");
        }
    }

    public void setAccountAdminSV() {
        System.out.println("---/SET ACCOUNT TO BECOME ADMIN/-----------------------------------------------------------------------------------------------------------------------------------");
        while (true) {
            String tempAID = inputAccountIDSV();
            long tempAIDL = Long.parseLong(tempAID);
            if (tempAID != null && getByAccountIdDB(tempAIDL) != null) {
                System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
                setAccountAdminDB(tempAIDL);
                System.out.println("This account has switched level from User --> Admin, please login again");
                System.exit(0);
                break;
            }
            System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Account ID not exist, try again !");
            break;
        }
    }

    public void setAccountAdminToUserSV() {
        System.out.println("---/SET ACCOUNT FROM ADMIN TO BECOME USER/------|FOR ADMIN MODE|------------------------------------------------------------------------------------------------------------------------");
        while (true) {
            String tempAID = inputAccountIDSV();
            long tempAIDL = Long.parseLong(tempAID);
            if (tempAID != null && getByAccountIdDB(tempAIDL) != null&& tempAIDL!=1) {
                System.out.println("\n---------Suggest Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                setAccountAdminToUserDB(tempAIDL);
                System.out.println("This account has switched level from User --> Admin, please login again");
                System.exit(0);
                break;
            }
            System.out.println("\n---------Suggest Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Account ID not exist or (Root) account ID can change to down user!");
            break;
        }
    }

    public void changePassWordSV() {
        System.out.println("--//CHANGE PASSWORD//------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String tempNameCPW = null;
        String tempPassCPW = null;
        boolean flag_accName;
        boolean flag_accPass;
        while (true) {
            String tempAccountName = inputAccountNameSV();
            if (tempAccountName != null&& getByUserNameExistDB(tempAccountName)) {
                tempNameCPW = tempAccountName;
                flag_accName = true;
                break;
            }
            System.out.println("---------Warning Message---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Account name incorrect, no exist !!");
            flag_accName = false;
            break;
        }
        while (true) {
            String tempAccountPass = inputAccountPasswordSV();
            if (tempAccountPass != null) {
                tempPassCPW = tempAccountPass;
                flag_accPass = true;
                break;
            }
            System.out.println("---------Warning Message----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Password incorrect, try again !!");
            flag_accPass = false;
            break;
        }
        if (flag_accName && flag_accPass && getByUserNameAndPasswordDB(tempNameCPW, tempPassCPW) != null) {
            System.out.println("---------Request Set New Password Message------------------------------------------------------------------------------------------------------------------------------------------");
            String tempPassNew = inputAccountPasswordSV();
            if (tempPassNew != null) {
                updateAccountByUserNameAndPasswordDB(tempNameCPW, tempPassNew);
                System.out.println("---------System Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Change password successfully, login again with new password");
                System.exit(0);
            }
        } else {
            System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Check information account incorrect, change failure");
        }
    }

    public void deleteAccountSV() {
        System.out.println("--//DELETE ACCOUNT BY ID//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            System.out.println("[1] --> Delete account by account name");
            System.out.println("[2] --> Delete account by account ID");
            System.out.println("[0] --> Exit, choose later");
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
                        String tempAccountName = inputAccountNameSV();
                        if (tempAccountName != null&& getByUserNameExistDB(tempAccountName)) {
                            deleteAccountByUserNameDB(tempAccountName);
                            break;
                        }
                        System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Account name incorrect, no exist !!");
                        break;
                case 2:
                        String tempAccountID = inputAccountIDSV();
                        long tempAccountIDL=Long.parseLong(tempAccountID);
                        if (tempAccountID != null&& getByAccountIdDB(tempAccountIDL)!=null) {
                            deleteAccountByAccountIDDB(tempAccountIDL);
                            break;
                        }
                        System.out.println("---------Warning Message-------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Account id incorrect, no exist !!");
                        break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

    //for admin
    private static void showAccountMenuSV(){
        System.out.println("---/MANAGE ACCOUNT MENU/---------|FOR ADMIN MODE|----------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list all account");
        System.out.println("[2] --> Create new default account");
        System.out.println("[3] --> Set default account to become admin account ");
        System.out.println("[4] --> Set admin account to become user account ");
        System.out.println("[5] --> Change password");
        System.out.println("[6] --> Delete account more options");
        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }

    //for admin
    public void manageAccountSV() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n------------------------|FOR ADMIN MODE|--------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showAccountMenuSV();
            System.out.printf("Input Option= ");
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input data is wrong, again");
                continue;
            }
            if (option < 0 || option > 6) {
                System.out.println("--------/Warning Message/---------------------------------------------------------------------------------------------------------------------------------------------------//-");
                System.out.println("Input option again, out option !!");
                continue;
            }
            switch (option) {
                case 1:
                    showListAccountNoConditionSV();
                    break;
                case 2:
                    createNewDefaultAccountSV();
                    break;
                case 3:
                    setAccountAdminSV();
                case 4:
                    setAccountAdminToUserSV();
                    break;
                case 5:
                    changePassWordSV();
                    break;
                case 6:
                    deleteAccountSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

    //FOR USER
    private static void showAccountMenuSVUS(){
        System.out.println("---/MANAGE ACCOUNT MENU/--------|FOR USER MODE|-------------------------------------------------------------------------------------------------------------------------------//-");
        System.out.println("[1] --> Show list account lite");
        System.out.println("[2] --> Change password");
        System.out.println("[0] --> Exit ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");

    }

    //for USER
    public void manageAccountSVUS() {
        int option=-1;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//-");
            System.out.println("Please select option in menu as below");
            showAccountMenuSVUS();
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
                    showListAccountNoConditionSVUS();//USER
                    break;
                case 2:
                    changePassWordSV();
                    break;
                case 0:
                    break;
            }
        } while (option!=0);
    }

}
