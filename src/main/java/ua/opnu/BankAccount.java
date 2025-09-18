package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        double totalDeduction = amount + transactionFee;

        if (balance >= totalDeduction) {
            balance -= totalDeduction;
            return true;
        } else {
            return false;
        }
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) {
            return false;
        }

        double totalDeduction = amount + transactionFee;

        if (balance >= totalDeduction) {
            balance -= totalDeduction;
            receiver.balance += amount;
            return true;
        } else {
            return false;
        }
    }
}