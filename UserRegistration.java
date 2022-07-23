package com.blz.UserRegistration;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {

    Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    public void addUser() {
        int choice = 0;
        do {
            System.out.println("1. First Name\\n2. Last Name\n3. Email\n4. Mobile Number\n5.0. Exit");
            System.out.println("Enter choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String firstName = stringInput("Enter First Name");
                    addFirstName(firstName);
                    break;
                case 2:
                    String lastName = stringInput("Enter Last Name");
                    addLastName(lastName);
                    break;
                case 3:
                    String email = stringInput("Enter email");
                    addEmail(email);
                    break;
                case 4:
                    String phoneNumber = stringInput("Enter phone number");
                    addPhoneNumber(phoneNumber);
                    break;
                case 5:
                    String password = stringInput("Enter Password");
                    addPassword(password);
                    break;
            }
        } while (choice != 0);
    }

    private String stringInput(String msg) {
        System.out.println(msg);
        String strData = scanner.next();
        return strData;
    }

    public boolean addFirstName(String firstName) {
        boolean isFirstName = Pattern.matches("^[A-Z][a-z]{2,}$", firstName);
        if (isFirstName) {
            userDetails.setFirstName(firstName);
            return true;
        } else {
            System.out.println("Please check First Name");
            return false;
        }
    }

    public boolean addLastName(String lastName) {
        boolean isLastName = Pattern.matches("^[A-Z][a-z]{2,}$", lastName);
        if (isLastName) {
            userDetails.setLastName(lastName);
            return true;
        } else {
            System.out.println("Please check Last Name");
            return false;
        }
    }
    public boolean addEmail(String email) {
        boolean isMailId = Pattern.matches("^([a-z0-9]+([-$%&+.]?[0-9a-z]+))[@][a-z0-9]+[.][a-z]{3,}([.][a-z]{2,})?$", email);
        if (isMailId) {
            userDetails.setEmail(email);
            return true;
        } else {
            System.out.println("Please check email id");
            return false;
        }
    }

    public boolean addPhoneNumber(String phoneNumber) {
        boolean isPhoneNumber = Pattern.matches("^([1-9]+[0-9]+)[\\s][0-9]{10}$", phoneNumber);
        if (isPhoneNumber) {
            userDetails.setPhoneNumber(phoneNumber);
            return true;
        } else {
            System.out.println("Please check Phone Number");
            return false;
        }
    }

    public boolean addPassword(String password) {
        boolean isPassword = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.+[0-9])(?=.*[%^<>?/:'}{()*!|.,;_#&$+=@]).{8,}$", password);
        if (isPassword) {
            userDetails.setPassword(password);
            return true;
        } else {
            System.out.println("Please check Password");
            return false;
        }
    }

}
