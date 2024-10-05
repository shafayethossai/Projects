package com.mycompany.main_class;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_Class {

    public static void main(String[] args) {
        List <Account_Create> accounts = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Scanner strng = new Scanner(System.in);
        int Choice;
        boolean Exit = true;
        
        displayWelcomeMessage();
        
        do {
            System.out.println("Choose Our Services : ");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. to quit: \n");
            System.out.print("Enter Your Choice: ");
            Choice = input.nextInt();

            switch (Choice) {
                case 1 : {
                    System.out.print("\nEnter your Name: ");
                    String user_name = strng.nextLine();
                    System.out.print("Enter Account Type: ");
                    String type = strng.nextLine();
                    System.out.print("Enter Password: ");
                    String password = strng.nextLine();
                    System.out.print("Enter Street: ");
                    String street = strng.nextLine();
                    System.out.print("Enter City: ");
                    String city = strng.nextLine();
                    System.out.print("Set an initial balance: ");
                    int initialBalance = input.nextInt();
                    
                    Account_Create user = new Account_Create(user_name, type, password, street, city, initialBalance);
                    accounts.add(user);
                    
                    System.out.println("\n\t\t\t\t\t\t   \"Your Account Details\"");
                    System.out.println("\t\t\t\t\t\t\"Don't Forget Account Number\"\n");
                    System.out.println("\t\t\t\t\t********************************************");
                    user.display_details();
                    break;
                }
                case 2 : {
                    if (accounts.isEmpty()) {
                        System.out.println("\t\t\t\t\t\"NO ACCOUNTS CREATED YET. PLEASE CREATE AN ACCOUNT FIRST\"");
                        break;
                    }
                    else {
                        System.out.print("\nEnter Account Number: ");
                        int accountNumberDeposit = input.nextInt();
                        Account_Create depositAccount = findAccount(accounts, accountNumberDeposit);
                        
                        if (depositAccount == null) {
                            System.out.println("\t\t\t\t\t\t\"ACCOUNT NOT FOUND\"");
                            break;
                        }
                        else {
                            System.out.print("Enter Password: ");
                            String inputPassword = strng.nextLine();
                            
                            if (depositAccount.authenticate(inputPassword)) {
                                System.out.print("Enter Amount Of Money: ");
                                int depositAmount = input.nextInt();
                                depositAccount.deposite(depositAmount);
                                System.out.println("\t\t\t\t\t\t\"Deposit Successful!!\"");
                            } 
                            else {
                                System.out.println("\t\t\t\t\t\t\"WRONG PASSWORD\"");
                            }
                        }
                    }
                    break;
                }
                case 3 : {
                    if (accounts.isEmpty()) {
                        System.out.println("\t\t\t\t\t\"NO ACCOUNTS CREATED YET. PLEASE CREATE AN ACCOUNT FIRST.\"");
                        break;
                    }
                    else {
                        System.out.print("\nEnter Account Number: ");
                        int accountNumberWithdraw = input.nextInt();
                        Account_Create withdrawAccount = findAccount(accounts, accountNumberWithdraw);
                        
                        if (withdrawAccount == null) {
                            System.out.println("\t\t\t\t\t\t\"ACCOUNT NOT FOUND\"");
                            break;
                        }
                        else {
                            System.out.print("Enter Password: ");
                            String inputPasswordWithdraw = strng.nextLine();
                            
                            if (withdrawAccount.authenticate(inputPasswordWithdraw)) {
                                System.out.print("Enter Amount Of Money to Withdraw: ");
                                int withdrawAmount = input.nextInt();
                                int cb = withdrawAccount.withdraw(withdrawAmount);
                                System.out.println("Withdraw Successful!!\nYour Current Balance: " + cb);
                            } 
                            else {
                                System.out.println("\t\t\t\t\t\t\"WRONG PASSWORD\"");
                            }
                        }
                    }
                    break;
                }
                case 4 : {
                    if (accounts.isEmpty()) {
                        System.out.println("\t\t\t\t\t\"NO ACCOUNTS CREATED YET. PLEASE CREATE AN ACCOUNT FIRST\"");
                        break;
                    }
                    else {
                        System.out.print("\nEnter Account Number: ");
                        int accountNumberCheck = input.nextInt();
                        Account_Create checkAccount = findAccount(accounts, accountNumberCheck);
                        
                        if (checkAccount == null) {
                            System.out.println("\t\t\t\t\t\t\"ACCOUNT NOT FOUND\"");
                            break;
                        }
                        else {
                            System.out.print("\nYour Current Balance: " + checkAccount.Acc_Balance);
                        }
                    }
                    break;
                }
                case 5 : {
                    if (accounts.isEmpty()) {
                        System.out.println("\t\t\t\t\t\"NO ACCOUNTS CREATED YET. PLEASE CREATE AN ACCOUNT FIRST\"");
                        break;
                    }
                    else {
                        System.out.print("\nEnter Account Number: ");
                        int accountNumberDisplay = input.nextInt();
                        Account_Create displayAccount = findAccount(accounts, accountNumberDisplay);
                        
                        if (displayAccount == null) {
                            System.out.println("\t\t\t\t\t\t\"ACCOUNT NOT FOUND\"");
                            break;
                        }
                        else {
                            System.out.print("\n");
                            displayAccount.display_details();
                        }
                    }
                    break;
                }
                case 6 :{ 
                    Exit = false;
                    break;
                }
                default : { 
                    System.out.println("\t\t\t\t\t\t\"WRONG CHOICE\"");
                }
            }
            System.out.println("\n");
        } while (Exit);
        System.out.println("\t\t\t\t\t\t\"THANKS FOR COMING!\"");
    }
    
    private static Account_Create findAccount(List<Account_Create> accounts, int accountNumber) {
        for (Account_Create account : accounts) {
            if (account.Acc_num == accountNumber) {
                return account;
            }
        }
        return null;
    }
    
    public static void displayWelcomeMessage() {
        System.out.println("\t\t\t\t\t      WELCOME TO OUR \"UITS BANK\"");
        System.out.println("\t\t\t\t  ===================================================");
        System.out.println("\t\t\t   We are here to serve you! Remember: \"Saving today for a better tomorrow.\"");
        System.out.println("\t\t\t\t\tLet's get started with managing your accounts...");

        try {
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
