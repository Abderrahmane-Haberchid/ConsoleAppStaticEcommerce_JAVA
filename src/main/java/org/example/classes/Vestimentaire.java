package org.example.classes;

import java.awt.*;

public class Vestimentaire extends Article{
    int taille;
    Color couleur;
    Categorie cible;

    public Vestimentaire(int taille, Color couleur, Categorie cible, String nom, String marque, double prix, int tva, Unite unite) {
        super(nom, marque, prix, tva, unite);
        this.cible = cible;
        this.couleur = couleur;
        this.taille = taille;
    }
}
