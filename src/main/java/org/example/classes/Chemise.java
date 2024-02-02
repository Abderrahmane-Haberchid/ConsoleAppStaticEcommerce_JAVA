package org.example.classes;

import java.awt.*;

public class Chemise extends Vestimentaire{

    boolean manche;
    public Chemise(boolean manche, int taille, Color couleur, String cible, String nom,
                   String marque, double prix, int tva, Unite unite) {

        super(taille, couleur, Categorie.valueOf(cible), nom, marque, prix, tva, unite);
        this.manche = manche;
    }

    public String toString() {
        return "Chemise{" +
                "\n Référence = " + this.hashCode() +
                "\n manche = " + manche +
                "\n taille = " + taille +
                "\n couleur = " + couleur +
                "\n cible = " + cible +
                "\n nom = " + nom +
                "\n marque = " + marque +
                "\n tva = " + tva +
                "\n prix = " + prix +
                "\n unite = " + unite +
                "\n =======================================" +
                '}';
    }
}
