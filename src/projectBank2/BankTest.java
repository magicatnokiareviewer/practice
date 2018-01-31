package projectBank2;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.security.PublicKey;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class BankTest {

    @DataProvider
    public static Object[][] checkBank() {
        return new Object[][]{

                {new BigDecimal(1000), new BigDecimal(60), new BigDecimal(20), new BigDecimal(10), new BigDecimal(1193).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(1070).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(100), new BigDecimal(110), new BigDecimal(210), new BigDecimal(21), new BigDecimal(1262.10).setScale(2, BigDecimal.ROUND_HALF_UP)},
        };
    }

    @Test
    @UseDataProvider("checkBank")
    public void IsmMoneyIn(BigDecimal acco, BigDecimal pln, BigDecimal gbp, BigDecimal usd, BigDecimal afterPayingIn) {
        //given
        Bank bank = new Bank();
        Account account = new Account();
        //when
        account.setCurrency(Currency.PLN);
        account.setMyPLN(acco);
        BigDecimal result = bank.moneyIn(pln, gbp, usd, account);
        //then
        Assertions.assertThat(result).isEqualTo(afterPayingIn);

    }

    @DataProvider
    public static Object[][] checkBank2() {
        return new Object[][]{

                {new BigDecimal(1000), new BigDecimal(60), new BigDecimal(20), new BigDecimal(10), new BigDecimal(807.00).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(1000), new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(30.00).setScale(2, BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(23456), new BigDecimal(110), new BigDecimal(210), new BigDecimal(21), new BigDecimal(22293.90).setScale(2, BigDecimal.ROUND_HALF_UP)},
        };
    }

    @Test
    @UseDataProvider("checkBank2")
    public void IsmMoneyOut(BigDecimal acco1, BigDecimal pln1, BigDecimal gbp1, BigDecimal usd1, BigDecimal afterPayingIn1) {
        //given
        Bank bank = new Bank();
        Account account2 = new Account();
        //when
        account2.setMyPLN(acco1);
        account2.setCurrency(Currency.PLN);
        BigDecimal result2 = bank.moneyOut(pln1, gbp1, usd1, account2);
        //then
        Assertions.assertThat(result2).isEqualTo(afterPayingIn1);
    }
}

