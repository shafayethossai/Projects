package com.mycompany.main_class;

class Account_Create extends Account_Class implements Interface_Class  {
    private final String password;
    private String street;
    private String city;

    Account_Create(String name, String a_t, String password, String street, String city, int initialBalance) {
        super(name, a_t, generateAccountNumber(), initialBalance);

        this.password = password;
        this.street = street;
        this.city = city;
    }

    void display_details() {
        System.out.println("Depositor Name: " + name);
        System.out.println("Account Number: " + Acc_num);
        System.out.println("Account Balance: " + Acc_Balance);
        System.out.println("Account Type: " + acc_type);
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
    }

    void deposite(int money) {
        Acc_Balance += money;
    }

    int withdraw(int withdraw) {
        if (withdraw > Acc_Balance || (Acc_Balance-withdraw) < 1000) {
            System.out.println("\t\t\t\t\t\t\"INSUFFICIENT BALANCE. WITHDRAWAL CANCELED\"");
        }
        else if (withdraw <= Acc_Balance) {
            Acc_Balance -= withdraw;
        } 
        return Acc_Balance;
    }

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Generate a unique account number
    private static int generateAccountNumber() {
        return (int) ((Math.random() * 9000) + 1000);
    }
}
