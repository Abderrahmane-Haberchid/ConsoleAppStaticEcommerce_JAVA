package org.example.classes;

public class Electromenager extends Article{
    int puissance;
    double garantie;
    public Electromenager(int puissance, double garantie, String nom, String marque, double prix, int tva, Unite unite){
        super(nom, marque, prix, tva, unite);
        this.puissance = puissance;
        this.garantie = garantie;
    }
}
