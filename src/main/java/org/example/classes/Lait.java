package org.example.classes;

import java.time.LocalDate;

public class Lait extends Alimentaire{

    boolean matiereGrasse;
    public Lait(boolean matiereGrasse, LocalDate dateExpiration, String nom,
                String marque, double prix, int tva, Unite unite) {

        super(dateExpiration, nom, marque, prix, tva, unite);
        this.matiereGrasse = matiereGrasse;
    }

    public String toString() {
        return "Lait {" +
                "\n matiere grasse = " + matiereGrasse +
                "\n Date expriration = " + dateExpiration +
                "\n nom = " + nom +
                "\n marque = " + marque +
                "\n tva = " + tva +
                "\n prix = " + prix +
                "\n unite = " + unite +
                "\n =======================================" +
                '}';
    }
}
