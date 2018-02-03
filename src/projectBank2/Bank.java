package projectBank2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    final BigDecimal DOLAR = new BigDecimal(4.1);
    final BigDecimal POUND = new BigDecimal(4.6);
    final BigDecimal POUNDTODOLAR = new BigDecimal(1.43);

    public BigDecimal moneyIn(BigDecimal pln, BigDecimal gbp, BigDecimal usd, Account account) {

        if (account.getCurrency() == Currency.PLN)
            return account.getMyPLN().add(pln)
                    .add((gbp.multiply(POUND).setScale(2,RoundingMode.HALF_UP))
                    .add(usd.multiply(DOLAR).setScale(2,RoundingMode.HALF_UP)));
        if (account.getCurrency() == Currency.GBP)
            return account.getMyGBP().add(gbp)
                    .add((pln.divide(POUND,2, RoundingMode.HALF_UP)))
                    .add(usd.divide(POUNDTODOLAR,2, RoundingMode.HALF_UP));
        if (account.getCurrency() == Currency.USD)
            return account.getMyUSD().add(usd)
                    .add((pln.divide(DOLAR,2,RoundingMode.HALF_UP)))
                    .add(POUND.multiply(POUNDTODOLAR));
        return account.getMyPLN();
    }

    public BigDecimal moneyOut(BigDecimal pln, BigDecimal gbp, BigDecimal usd, Account account) {

        if (account.getCurrency() == Currency.PLN)
            return account.getMyPLN().subtract(pln)
                    .subtract((gbp.multiply(POUND).setScale(2,RoundingMode.HALF_UP)))
                    .subtract(usd.multiply(DOLAR).setScale(2,RoundingMode.HALF_UP));
        if (account.getCurrency() == Currency.GBP)
            return account.getMyGBP().subtract(gbp)
                    .subtract((pln.divide(POUND,2, RoundingMode.HALF_UP)))
                    .subtract(usd.divide(DOLAR,2, RoundingMode.HALF_UP));
        if (account.getCurrency() == Currency.USD)
            return account.getMyUSD().subtract(usd)
                    .subtract((pln.divide(DOLAR,2, RoundingMode.HALF_UP)))
                    .subtract(POUND.multiply(POUNDTODOLAR));
        return account.getMyPLN();
    }

    public Map<String, BigDecimal> myAccounts(Account account, Account account1, Transfer transfer) {

        transfer.accountTransfer.setMyPLN(new BigDecimal(17000.8).setScale(2,BigDecimal.ROUND_HALF_UP));
        Map<String, BigDecimal> allAccounts = new TreeMap<>();
        allAccounts.put(account.getKontoPLN() + " in " + Currency.PLN, account.getMyPLN());
        allAccounts.put(account1.getKontoGBP() + " in " + Currency.GBP, account1.getMyGBP());
        allAccounts.put(transfer.accountTransfer.getKontoPLNSecond() + " in "
                + Currency.PLN, transfer.accountTransfer.getMyPLN());

        System.out.println("There are 3 accounts in the bank: " + allAccounts);
        return allAccounts;
    }
}

