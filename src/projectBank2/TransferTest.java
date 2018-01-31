package projectBank2;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)

public class TransferTest {


    @DataProvider
    public static Object[][] checkingTransfer() {
        return new Object[][]{
                {new BigDecimal(60.5), new BigDecimal(32), new BigDecimal(92.5).setScale(2,BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(100), new BigDecimal(110), new BigDecimal(210).setScale(2,BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(81), new BigDecimal(91), new BigDecimal(172).setScale(2,BigDecimal.ROUND_HALF_UP)},
                {new BigDecimal(80), new BigDecimal(90), new BigDecimal(170).setScale(2,BigDecimal.ROUND_HALF_UP)},
        };
    }

    @Test
    @UseDataProvider("checkingTransfer")

    public void IsTransferTo(BigDecimal stan, BigDecimal send, BigDecimal after) {
        //given
        Account account = new Account();
        Transfer transfer = new Transfer(account, Currency.PLN);
        //when
        account.setMyPLN(stan);
        transfer.howMuch = send;
        BigDecimal result = transfer.transferTo();
        //then
        Assertions.assertThat(result).isEqualTo(after);
    }

    @DataProvider
    public static Object[][] checkingTransfer2() {
        return new Object[][]{

                {new BigDecimal(60), new BigDecimal(32), new BigDecimal(28)},
                {new BigDecimal(199), new BigDecimal(109), new BigDecimal(90)},
                {new BigDecimal(1000), new BigDecimal(110), new BigDecimal(890)},
                {new BigDecimal(811), new BigDecimal(11), new BigDecimal(800)},
                {new BigDecimal(80), new BigDecimal(9), new BigDecimal(71)},
        };
    }

    @Test
    @UseDataProvider("checkingTransfer2")

    public void IsTransferFrom(BigDecimal stan2, BigDecimal send2, BigDecimal after2) {
        //given
        Account accountTransfer = new Account();
        Transfer transfer = new Transfer(accountTransfer, Currency.PLN);
        //when
        transfer.accountTransfer.setMyPLN(stan2);
        transfer.howMuch = send2;
        BigDecimal result1 = transfer.transferFrom();
        //then
        Assertions.assertThat(result1).isEqualTo(after2);
    }
}