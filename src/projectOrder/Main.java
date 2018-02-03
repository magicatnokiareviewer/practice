package com.sdabyd2.programowanie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String destination = "Zamowienie.json";

        Pozycja pozycja1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja1);
        Pozycja pozycja2 = new Pozycja("Cukier", 3, 4.5);
        System.out.println(pozycja2);
        Pozycja pozycja3 = new Pozycja("mleko", 2, 2.25);
        System.out.println(pozycja3);
        Pozycja pozycja4 = new Pozycja("Chleb", 7, 3.5);
        System.out.println(pozycja4);
        Pozycja pozycja5 = new Pozycja("jogurt", 1, 4.5);
        System.out.println(pozycja5);
        Pozycja pozycja6 = new Pozycja("jogurt", 8, 4.5);
        System.out.println(pozycja6);
        Pozycja pozycja7 = new Pozycja("Chleb", 3, 3.5);
        System.out.println(pozycja7);
        Pozycja pozycja8 = new Pozycja("jogurt", 12, 4.5);
        System.out.println(pozycja8);
        Pozycja pozycja9 = new Pozycja("piwo", 11, 3.3);
        System.out.println(pozycja9);

        Zamowienie zamowienie = new Zamowienie(20);

        zamowienie.dodajPozycje(pozycja1);
        zamowienie.dodajPozycje(pozycja2);
        zamowienie.dodajPozycje(pozycja3);
        zamowienie.dodajPozycje(pozycja4);
        zamowienie.dodajPozycje(pozycja5);
        zamowienie.dodajPozycje(pozycja6);
        zamowienie.dodajPozycje(pozycja7);
        zamowienie.dodajPozycje(pozycja8);
        zamowienie.dodajPozycje(pozycja9);
        zamowienie.usunPozycje(1);
        zamowienie.edytujPozycje(1, 7, 1, "pomidory");

        System.out.println(zamowienie);

        zamowienie.zapiszZamowienie(zamowienie, destination);
        zamowienie.wczytajZamowienie(destination);
        //pozycja1.zapiszZamowienie(zamowienie,destination);
    }
}

