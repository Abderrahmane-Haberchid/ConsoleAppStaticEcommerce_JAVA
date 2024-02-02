package org.example.classes;

import java.time.LocalDate;
import java.util.Date;

public class Alimentaire extends Article{

    LocalDate dateExpiration;
    public Alimentaire(LocalDate dateExpiration, String nom, String marque, double prix, int tva, Unite unite){
        super(nom, marque, prix, tva, unite);
        this.dateExpiration = dateExpiration;
    }
}
