package org.example.classes;

public class Refrigerateur extends Electromenager{

    int volume;
    public Refrigerateur(int volume, int puissance, double garantie, String nom, String marque, double prix, int tva, Unite unite) {
        super(puissance, garantie, nom, marque, prix, tva, unite);
        this.volume = volume;
    }

    public String toString() {
        return "Refrigerateur{" +
                "\n Volume = " + volume +
                "\n Puissance = " + puissance +
                "\n Garantie = " + garantie +
                "\n nom = " + nom +
                "\n marque = " + marque +
                "\n tva = " + tva +
                "\n prix = " + prix +
                "\n unite = " + unite +
                "\n =======================================" +
                '}';
    }
}
