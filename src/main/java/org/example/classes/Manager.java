package org.example.classes;

public class Manager {
    String nom;
    int age;

    public void menuManager(){
        System.out.println("1 – Ajouter un nouvel article\n" +
                "2 – Afficher la liste des articles par catégorie\n" +
                "3 – Afficher tous les articles présents dans le dépôt\n" +
                "4 – Supprimer un article\n" +
                "5 – Quitter le programme");
    }
}
