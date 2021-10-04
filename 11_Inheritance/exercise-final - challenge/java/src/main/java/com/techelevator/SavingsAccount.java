package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolder, String accountNumber, BigDecimal balance) {
        super(accountHolder, accountNumber, balance);
    }

    public SavingsAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        // only perform transaction of positive $ and room for fee
        if ((getBalance().subtract(amountToWithdraw)).compareTo(new BigDecimal(2)) > 0) {
            super.withdraw(amountToWithdraw);
            // Assess $2 fee if it goes below $150
            if (getBalance().compareTo(new BigDecimal(150)) < 0) {
                super.withdraw(new BigDecimal(2));
            }
        }
        return getBalance();
    }
}

