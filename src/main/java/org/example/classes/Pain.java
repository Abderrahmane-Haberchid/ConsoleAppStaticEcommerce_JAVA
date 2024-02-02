package org.example.classes;

import java.time.LocalDate;
import java.util.Date;

public class Pain extends Alimentaire{

    boolean withSel;
    public Pain(boolean withSel, LocalDate dateExpiration, String nom, String marque,
                double prix, int tva, Unite unite) {

        super(dateExpiration, nom, marque, prix, tva, unite);
        this.withSel = withSel;
    }

    public String toString() {
        return "Pain {" +
                "\n Avec Sel = " + withSel +
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
