package org.example.classes;

public class Television extends Electromenager{

    int taille;
    public Television(int taille, int puissance, double garantie, String nom, String marque, double prix, int tva, Unite unite) {
        super(puissance, garantie, nom, marque, prix, tva, unite);
        this.taille = taille;
    }

    public String toString() {
        return "Television{" +
                "\n Taille = " + taille +
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
