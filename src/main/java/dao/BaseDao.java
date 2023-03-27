package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BaseDao {

    public boolean hasOnlyNumbersAndLetter(String s) {
        final String regex = "[a-zA-Z0-9]+";
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }
    public boolean hasOnlyString(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches("[a-zA-Z]+")) { // check that the input only contains letters
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }
    public  boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            System.out.println("Input type incorrect!!! ");
        }
        return date != null;
    }
    public boolean hasGender01(long x) {
        final String regex = "[0-1]";
        String s = String.valueOf(x);
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }
    public boolean hasOnlyNumber(String s) {
        final String regex = "[0-9]+";
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOnlyNumberAndOneDot(String s) {
        final String regex = "^\\d+(\\.\\d)?$";
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }

    public boolean hasForAccountName(String s) {
        final String regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }
    public boolean hasForAccountPassword(String s) {
        final String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        if (s.isEmpty()) {
            return false;
        }
        if (s.matches(regex)) {
            // okay so exit loop
            return true;
        } else {
            return false;
        }
    }




}

