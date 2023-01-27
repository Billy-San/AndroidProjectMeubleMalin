package com.example.androidprojectmeublemalin;

public class Meuble {

    public String titel, beschrijving, prijs;

    public Meuble() {
    }

    public Meuble(String titel, String beschrijving, String prijs) {
        this.titel = titel;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }
}
