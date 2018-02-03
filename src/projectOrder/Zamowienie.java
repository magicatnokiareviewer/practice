package com.sdabyd2.programowanie;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zamowienie implements Serializable {

    int ileDodanych;
    int maksRozmiar;
    List<Pozycja> pozycja = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    double calkowitaWartoscZamowienia;
    int iloscMax;

    public List<Pozycja> getPozycja() {
        return pozycja;
    }

    public void setPozycja(List<Pozycja> pozycja) {
        this.pozycja = pozycja;
    }

    public Zamowienie() {
        this.maksRozmiar = 20;

    }

    public Zamowienie(int ileDodanych) {
        this.ileDodanych = ileDodanych;
    }

    public void dodajPozycje(Pozycja p) {

        pozycja.add(p);

        for (int i = 0; i < pozycja.size(); i++) {
            iloscMax += pozycja.get(i).getIleSztuk();
            for (int j = 0; j < pozycja.size(); j++) {
                if (pozycja.get(i).getNazwaTowaru().equals(pozycja.get(j).getNazwaTowaru()) && i != j) {
                    pozycja.get(i).setIleSztuk(pozycja.get(i).getIleSztuk() + pozycja.get(j).getIleSztuk());
                    pozycja.remove(j);
                }
            }
        }
    }

    public double obliczWartoscCala() {

        for (int i = 0; i < pozycja.size(); i++) {
            calkowitaWartoscZamowienia += pozycja.get(i).obliczWartosc() - pozycja.get(i).obliczWartoscZRabatem();
            if (pozycja.get(i).getRabat() > 0)
                System.out.println("kwota rabatu za: " + pozycja.get(i).getNazwaTowaru() + ": " + (String.format("%.2f", pozycja.get(i).getRabat())) + " zł");

        }
        return calkowitaWartoscZamowienia;
    }

    @Override
    public String toString() {

        System.out.println("\nZamowienie: ");
        for (int i = 0; i < pozycja.size(); i++) {
            System.out.println(pozycja.get(i));

        }
        return "\nwartość całkowita po uwzglednieniu rabatu : " + obliczWartoscCala() + " zł";
    }

    public void usunPozycje(int indeks) {
        pozycja.remove(indeks);
    }

    void edytujPozycje(int indeks, double cena, int sztuk, String nazwa) {
        pozycja.get(indeks).cena = cena;
        pozycja.get(indeks).ileSztuk = sztuk;
        pozycja.get(indeks).nazwaTowaru = nazwa;
    }

    @Override
    public void zapiszZamowienie(Zamowienie z, String fileName) {

        try {
            File fieName = new File(fileName);
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
    }

    @Override
    public Zamowienie wczytajZamowienie(String fileName) {

        Zamowienie zamowienie = new Zamowienie();
        ObjectMapper mapper = new ObjectMapper();
        try {
            zamowienie = mapper.readValue(new File(fileName), Zamowienie.class);
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
