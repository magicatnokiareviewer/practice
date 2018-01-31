package projectBank2;

import java.math.BigDecimal;

public class Account {

    private BigDecimal myPLN;
    private BigDecimal myGBP;
    private BigDecimal myUSD;
    private String kontoPLN;
    private String kontoGBP;
    private String kontoPLNSecond;

    public Account() {
        kontoPLN = "Account number: 123456";
        kontoGBP = "Account number: 654321";
        kontoPLNSecond = "Account number: 223399";
    }

    public String getKontoPLNSecond() {
        return kontoPLNSecond;
    }

    public void setKontoPLNSecond(String kontoPLNSecond) {
        this.kontoPLNSecond = kontoPLNSecond;
    }

    public void setKontoPLN(String kontoPLN) {
        this.kontoPLN = kontoPLN;
    }

    public void setKontoGBP(String kontoGBP) {
        this.kontoGBP = kontoGBP;
    }

    public String getKontoPLN() {
        return kontoPLN;
    }

    public String getKontoGBP() {
        return kontoGBP;
    }

    public BigDecimal getMyUSD() {
        return myUSD;
    }

    public void setMyUSD(BigDecimal myUSD) {
        this.myUSD = myUSD;
    }

    public BigDecimal getMyGBP() {
        return myGBP;
    }

    public void setMyGBP(BigDecimal myGBP) {
        this.myGBP = myGBP;
    }

    public BigDecimal getMyPLN() {
        return myPLN;
    }

    public void setMyPLN(BigDecimal myPLN) {
        this.myPLN = myPLN;
    }

    Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
