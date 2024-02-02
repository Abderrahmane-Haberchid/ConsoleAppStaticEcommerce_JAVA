package org.example.classes;


import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ManagerService {

    public String nom;
    public String marque;
    public int tva;
    public double prix;
    public Unite unite;

    Chemise chemise;
    Pantalon pantalon;
    Lait lait;
    Pain pain;
    Refrigerateur refrigerateur;
    Television television;
    Magasin magasin;

    public void creerMagasin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenu à votre application. \nMerci de creer un nouveau Magasin");

        System.out.println("Entrez le nom du Magasin");
        String nomM = scanner.nextLine();

        System.out.println("Entez l'adresse du magasin");
        String adresse = scanner.nextLine();

        magasin = new Magasin(nom, adresse);

        System.out.println("Votre magasin "+nomM+" situé à "+adresse+" est créé ! \n");

        //scanner.close();
    }
    public void ajouterArticle() throws ValidationExeption {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le numéro de l'article à ajouter: \n" +
                "1 - Chemise\n" +
                "2 - Pantalon\n" +
                "3 - Television\n" +
                "4 - Refrigerateur\n" +
                "5 - Pain\n" +
                "6 - Lait");
        int numero = scanner.nextInt();

        if (numero == 1) saisirChemise();
        if (numero == 2) saisirPantalon();
        if (numero == 3) saisirTelevision();
        if (numero == 4) saisirRef();
        if (numero == 5) saisirPain();
        if (numero == 6) saisirLait();

        //scanner.close();
    }
    // Saisir les données basic d'un article que chaque produit en dispose
    public void saisirArticle() throws ValidationExeption {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nom:");
        nom = scanner.nextLine();

        System.out.println("Entrez la marque:");
        marque = scanner.nextLine();
        System.out.println(nom + marque);
        System.out.println("Entrez la TVA:");
        tva = scanner.nextInt();

        System.out.println("Entrez le prix:");
        prix = scanner.nextDouble();

        System.out.println("Entrez l'unité (1:Litre 2:Kilogramme 3:Piece 4: Metre): ");
        int uni = scanner.nextInt();
        switch (uni) {
            case 1 -> unite = Unite.LITRE;
            case 2 -> unite = Unite.KILOGRAMME;
            case 3 -> unite = Unite.PIECE;
            case 4 -> unite = Unite.METRE;
        }
       // scanner.close();
    }

    // Saisir l'article CHEMISE

    public void saisirChemise() throws ValidationExeption{

        Scanner in = new Scanner(System.in);
        saisirArticle();
        Categorie cible = null;

         System.out.println("Avec manche ? oui/non");
         String manche = in.nextLine();

         boolean avecManche = manche.equals("oui");

         System.out.println("Veuillez entrer la taille: ");
         int taille = in.nextInt();
         System.out.println(taille);

         System.out.println("Veuillez entrer la couleur: ");
         String couleur = in.nextLine();


         System.out.println("Veuillez entrer la cible(1:Garcon 2:Homme 3:File 4:Femme): ");
         int choice = in.nextInt();

         if (choice == 1) cible = Categorie.GARCON;
         else if (choice == 2) cible = Categorie.HOMME;
         else if (choice == 3) cible = Categorie.FILLE;
         else if (choice == 4) cible = Categorie.FEMME;
         assert cible != null;
         chemise = new Chemise(avecManche, taille, Color.getColor(couleur), cible.toString(), nom, marque, prix, tva, unite);

         magasin.depotArticles.add(chemise);
         System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + chemise);


       // in.close();
    }

    // Saisir l'article PANTTALON

    public void saisirPantalon() throws ValidationExeption{

        Scanner in = new Scanner(System.in);
        saisirArticle();
        Categorie cible = null;

        System.out.println("Veuillez entrer la longueur: ");
        double longueur = in.nextDouble();

        System.out.println("Veuillez entrer la taille: ");
        int taille = in.nextInt();

        System.out.println("Veuillez entrer la couleur: ");
        String couleur = in.nextLine();


        System.out.println("Veuillez entrer la cible(1:Garcon 2:Homme 3:File 4:Femme): ");
        int choice = in.nextInt();

        if (choice == 1) cible = Categorie.GARCON;
        else if (choice == 2) cible = Categorie.HOMME;
        else if (choice == 3) cible = Categorie.FILLE;
        else if (choice == 4) cible = Categorie.FEMME;
        assert cible != null;

        pantalon = new Pantalon(longueur, taille, Color.getColor(couleur), cible.toString(), nom, marque, prix, tva, unite);

        magasin.depotArticles.add(pantalon);
        System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + pantalon);
        // in.close();
    }

    // Saisir l'article LAIT

    public void saisirLait() throws ValidationExeption{
        Scanner in = new Scanner(System.in);
        saisirArticle();

        LocalDate date;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        System.out.println("Est ce qu'il contient de la matière grasse ? oui/non ");
        String matiereGrasse = in.nextLine();

        System.out.println("Veuillez entrer la date d'expiration: (dd/mm/aa)");
        String dateExp = in.next();
        date = LocalDate.parse(dateExp, dateTimeFormatter);

        boolean mg = matiereGrasse.equals("oui");

        lait = new Lait(mg, date, nom, marque, prix, tva, unite);
        magasin.depotArticles.add(lait);
        System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + lait);
    }

    // Saisir l'article PAIN
    public void saisirPain() throws ValidationExeption{
        Scanner in = new Scanner(System.in);
        saisirArticle();

        LocalDate date;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");

        System.out.println("Est ce qu'il contient du sel ? oui/non ");
        String sel = in.nextLine();

        System.out.println("Veuillez entrer la date d'expiration: (dd/mm/aa)");
        String dateExp = in.next();
        date = LocalDate.parse(dateExp, dateTimeFormatter);

        boolean withSel = sel.equals("oui");

        pain = new Pain(withSel, date, nom, marque, prix, tva, unite);
        magasin.depotArticles.add(pain);
        System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + pain);
    }

    // Saisir l'article TELEVISION
    public void saisirTelevision() throws ValidationExeption{
        Scanner in = new Scanner(System.in);
        saisirArticle();

        System.out.println("Veuillez entrer la taille en entier");
        int taille = in.nextInt();

        System.out.println("Veuillez entrer la puissance en entier");
        int puissance = in.nextInt();

        System.out.println("Veuillez entrer la garantie");
        double garantie = in.nextDouble();

        television = new Television(taille, puissance, garantie, nom, marque, prix, tva, unite);
        magasin.depotArticles.add(television);
        System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + television);
    }

    // Saisir l'article REGRIGERATEUR
    public void saisirRef() throws ValidationExeption{
        Scanner in = new Scanner(System.in);
        saisirArticle();

        System.out.println("Veuillez entrer le volume en entier");
        int vol = in.nextInt();

        System.out.println("Veuillez entrer la puissance en entier");
        int puissance = in.nextInt();

        System.out.println("Veuillez entrer la garantie");
        Double garantie = in.nextDouble();

        refrigerateur = new Refrigerateur(vol, puissance, garantie, nom, marque, prix, tva, unite);
        magasin.depotArticles.add(refrigerateur);
        System.out.println("\n L'article ci-dessous est ajouté avec succes: \n" + refrigerateur);
    }

    // Afficher tout les articles
    public String showAllArticles(){
        return magasin.toString();
    }

    // Afficher les articles par catégorie
    public List<Article> showByCategorie(){

        Scanner in = new Scanner(System.in);

        System.out.println("Veuillez choisir le numéro d'une catégorie: \n" +
                "1 - Alimentaire\n" +
                "2 - Vestimentaire\n" +
                "3 - Eletromenager");
        int categorie = in.nextInt();

        if (categorie == 1){
            List<Article> filteredList = new ArrayList<>();

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("lait")).toList());

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("pain")).toList());

            return filteredList;
        }
        if (categorie == 2){
            List<Article> filteredList = new ArrayList<>();

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("chemise")).toList());

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("pantalon")).toList());

            return filteredList;
        }
        if (categorie == 3){
            List<Article> filteredList = new ArrayList<>();

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("television")).toList());

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("refrigerateur")).toList());

            return filteredList;
        }
        else return magasin.depotArticles.stream().toList();
    }

    public void deleteArticle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom de l'article");
        String name = scanner.nextLine();

        // Je cherche l'article puis je le mets d'ans un objet article
         Article article = magasin.depotArticles
                .stream()
                .filter(a -> a.getNom().toLowerCase().contains(name)).findFirst().get();

        if(magasin.depotArticles.remove(article))
            System.out.println("Cet article a été supprimé : " + article);
        else
            System.out.println("Cet article n'existe pas, veuillez entrer le nom exact");
    }

}