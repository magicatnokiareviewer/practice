package com.sdabyd2.programowanie;

public interface Serializable {

    public  void zapiszZamowienie(Zamowienie z, String nazwaPliku);

    public Zamowienie wczytajZamowienie(String nazwaPliku);
}


