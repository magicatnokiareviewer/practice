package projectBank2;

import java.math.BigDecimal;

public class Transfer {

    Account account;
    Account accountTransfer = new Account();
    Currency currency;
    BigDecimal howMuch = new BigDecimal(1000.01);


    public Transfer(Account account, Currency currency) {
        this.account = account;
        this.currency = currency;
    }

    public BigDecimal transferTo() {
        howMuch = howMuch.setScale(2, BigDecimal.ROUND_HALF_UP);
        account.getMyPLN();
        System.out.println("After transfering " + howMuch + " to: " + account.getKontoPLN() +
                ": the balance is " + (account.getMyPLN().add(howMuch) + " " + currency));
        return (account.getMyPLN().add(howMuch));
    }

    public BigDecimal transferFrom() {

        System.out.println("After transfering " + howMuch + " out: " + account.getKontoPLNSecond() +
                ": the balance is " + (accountTransfer.getMyPLN().subtract(howMuch) + " " + currency));
        return (accountTransfer.getMyPLN().subtract(howMuch));
    }

}
