package com.sdabyd2.programowanie;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Pozycja implements Serializable {

    protected String nazwaTowaru;
    protected int ileSztuk;
    protected double cena;
    private double rabat;

    public Pozycja() {

    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setItemName(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    public void setIleSztuk(int ileSztuk) {
        this.ileSztuk = ileSztuk;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double obliczWartosc() {

        double wartoscZamowienia;
        wartoscZamowienia = ileSztuk * cena;

        return wartoscZamowienia;
    }

    public double obliczWartoscZRabatem() {
        final double PIEC = 0.05;
        final double DZIESIEC = 0.1;
        final double PIETNASCIE = 0.15;

        if (ileSztuk >= 5 && ileSztuk <= 10) {
            System.out.println("rabat za " + getNazwaTowaru() + ": " + PIEC * 100 + " %");
            return rabat += obliczWartosc() * PIEC;
        } else if (ileSztuk > 10 && ileSztuk <= 20) {
            System.out.println("rabat za " + getNazwaTowaru() + ": " + DZIESIEC * 100 + " %");
            return rabat += obliczWartosc() * DZIESIEC;
        } else if (ileSztuk > 20) {
            System.out.println("rabat za " + getNazwaTowaru() + ": " + PIETNASCIE * 100 + " %");
            return rabat += obliczWartosc() * PIETNASCIE;
        }
        return rabat;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-10s%-10s%-10s", nazwaTowaru, cena + " zł", ileSztuk + " szt.", obliczWartosc() + " zł");
    }

    @Override
    public void zapiszZamowienie(Zamowienie z, String nazwaPliku) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            File fieName = new File(nazwaPliku);
            fieName.createNewFile();
            mapper.writeValue(fieName, z);
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(z);
            System.out.println(jsonInString);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        wczytajZamowienie(nazwaPliku);
    }

    @Override
    public Zamowienie wczytajZamowienie(String nazwaPliku) {

        Zamowienie zamowienie = new Zamowienie();
        ObjectMapper mapper = new ObjectMapper();
        try {
            zamowienie = mapper.readValue(new File(nazwaPliku), Zamowienie.class);
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(zamowienie);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zamowienie;
    }
}
