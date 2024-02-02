package org.example.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Magasin {
    String nom;
    String adresse;
    List<Article> depotArticles;

    public Magasin(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.depotArticles = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Article> getDepotArticles() {
        return depotArticles;
    }

    public String toString() {

        return "Déport Article du magasin " + nom + "\n" +
                depotArticles.stream().count() + " Articles Disponible Dans le dépot \n \n" + depotArticles;
    }
}
