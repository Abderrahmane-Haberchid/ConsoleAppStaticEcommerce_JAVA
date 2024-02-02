package org.example.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    String nom;
    int age;
    List<Article> panier;

    public Client(String nom, int age){
        this.nom = nom;
        this.age = age;
        panier = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Article> getPanier() {
        return panier;
    }

    public void setPanier(List<Article> panier) {
        this.panier = panier;
    }
}
