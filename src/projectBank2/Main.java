package projectBank2;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Account account = new Account();
        account.setMyPLN(new BigDecimal(25000.7).setScale(2,BigDecimal.ROUND_HALF_UP));
        account.setCurrency(Currency.PLN);

        Account account1 = new Account();
        account1.setMyGBP(new BigDecimal(1250.6).setScale(2,BigDecimal.ROUND_HALF_UP));
        account1.setCurrency(Currency.GBP);
        Transfer transfer = new Transfer(account,Currency.PLN);

        Bank bank = new Bank();

        account.setMyPLN(bank.moneyIn((new BigDecimal(10)),
                new BigDecimal(29),
                new BigDecimal(99), account));
        System.out.println("Account balance after paying in: "+account.getKontoPLN()
                +" : "+account.getMyPLN()+" "+account.getCurrency());

        account.setMyPLN(bank.moneyOut((new BigDecimal(200)),
                new BigDecimal(10),
                new BigDecimal(10),account));
        System.out.println("Account balance after withdrawal: "+account.getKontoPLN()
                +" :"+account.getMyPLN()+" "+account.getCurrency());

        account1.setMyGBP(bank.moneyIn((new BigDecimal(10)),
                new BigDecimal(29),
                new BigDecimal(99),account1));
        System.out.println("Account balance after paying in: "+account1.getKontoGBP()
                +" : "+account1.getMyGBP()+" "+account1.getCurrency());

        account1.setMyGBP(bank.moneyOut((new BigDecimal(200)),
                new BigDecimal(10),
                new BigDecimal(10),account1));
        System.out.println("Account balance after withdrawal: "+account1.getKontoGBP()
                +": "+account1.getMyGBP()+" "+account1.getCurrency());

        bank.myAccounts(account,account1,transfer);

        transfer.transferTo();
        transfer.transferFrom();
    }
}
