package com.rj.Challenge_3_4_5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class BankAccount {

    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
     }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }


/*    public void deposit(double amount)
    {
        lock.lock();
        try
        {
            balance += amount;
        }
        finally
        {
            lock.unlock();
        }
    }

    public void withdraw(double amount)
    {
        lock.lock();
        try
        {
            balance -= amount;
        }
        finally
        {
            lock.unlock();
        }
    }*/

    public void deposit(double amount) {
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch(InterruptedException e) {
            // do something here
        }
    }

    public void withdraw(double amount) {
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }

        } catch(InterruptedException e) {
            // do something here
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}












