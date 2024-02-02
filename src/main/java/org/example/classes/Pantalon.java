package org.example.classes;

import java.awt.*;

public class Pantalon extends Vestimentaire{

    double longueur;
    public Pantalon(double longueur, int taille, Color couleur, String cible, String nom, String marque, double prix, int tva, Unite unite) {
        super(taille, couleur, Categorie.valueOf(cible), nom, marque, prix, tva, unite);
        this.longueur = longueur;
    }

    public String toString() {
        return "Pantalon{" +
                "\n Longueur = " + longueur +
                "\n Taille = " + taille +
                "\n Couleur = " + couleur +
                "\n Cible = " + cible +
                "\n nom = " + nom +
                "\n marque = " + marque +
                "\n tva = " + tva +
                "\n prix = " + prix +
                "\n unite = " + unite +
                "\n =======================================" +
                '}';
    }
}
