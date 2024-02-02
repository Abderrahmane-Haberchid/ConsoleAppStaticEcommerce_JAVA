package org.example.classes;

public class Article {
    public String nom;
    public String marque;
    public int tva;
    public double prix;
    public Unite unite;

    public Article(){ }

    public Article(String nom, String marque, double prix, int tva, Unite unite){
        this.nom =  nom;
        this.marque = marque;
        this.tva = tva;
        this.unite = unite;
        this.prix = prix;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String toString() {
        return "Article{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", tva=" + tva +
                ", unite=" + unite +
                '}';
    }
}
