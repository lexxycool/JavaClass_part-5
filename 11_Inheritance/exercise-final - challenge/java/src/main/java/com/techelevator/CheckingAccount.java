package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{

        public CheckingAccount(String accountHolder, String accountNumber, BigDecimal balance) {
            super(accountHolder, accountNumber, balance);
        }

        public CheckingAccount(String accountHolder, String accountNumber) {
            super(accountHolder, accountNumber);
        }

        @Override
        public BigDecimal withdraw(BigDecimal amountToWithdraw) {
            // Only allow the withdraw if the balance isn't going to go below -$100
            if (getBalance().subtract(amountToWithdraw).compareTo(new BigDecimal("-100")) > 0) {
                // Withdraw the $$
                super.withdraw(amountToWithdraw);
                // If the balance dips below 0, assess $10 charge
                if (getBalance().compareTo(new BigDecimal(0)) < 0) {
                    super.withdraw(new BigDecimal(10));
                }
            }
            return getBalance();
        }

}
