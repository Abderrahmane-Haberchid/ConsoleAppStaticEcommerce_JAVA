package org.example.classes;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService {

    int taxeAudioVisuel = 3;
    int taxeCarbone = 7;
    int taxeSolidarite = 5;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    LocalDate date = date = LocalDate.parse("01/01/26", dateTimeFormatter);
     Magasin magasin;
    Refrigerateur refrigerateur;
    Television tv;
    Lait lait;
    Pain pain;
    Pantalon pantalon;
    Chemise chemise;
    Client client;
    public UserService(){

         chemise = new Chemise(true, 34, Color.blue, Categorie.GARCON.name(),
                "chemise", "ZARA", 300, 10, Unite.PIECE);

         pantalon = new Pantalon(95, 36, Color.blue, Categorie.GARCON.name(),
                "pantalon", "ADIDAS", 650.70, 10, Unite.PIECE);

         pain = new Pain(true, date, "pain", "pain de mie", 13.5,
                20, Unite.KILOGRAMME);

         lait = new Lait(true, date, "lait", "JAOUDA", 4,
                20, Unite.LITRE);

         tv = new Television(3, 400, 5, "tv", "LG",
                4500, 15, Unite.PIECE);

         refrigerateur = new Refrigerateur(250, 1000, 3, "refrigerateur",
                "SAMSUNG",15000, 15, Unite.PIECE);

         magasin = new Magasin("Abdo Shop", "FES");

        magasin.depotArticles.add(chemise);
        magasin.depotArticles.add(pantalon);
        magasin.depotArticles.add(pain);
        magasin.depotArticles.add(lait);
        magasin.depotArticles.add(tv);
        magasin.depotArticles.add(refrigerateur);
    }

    public void creerClient(){
         //System.out.println(magasin.depotArticles);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Votre nom: ");
        String name = scanner.nextLine();

        System.out.println("Votre age: ");
        int age = scanner.nextInt();

        client = new Client(name, age);

        System.out.println("\n Bienvenu Mr/Mme " + name.toUpperCase() + " au Magasin " +
                magasin.getNom() + "\n \n Merci de choisir le numéro d'action à faire");
    }

    // Afficher les articles par catégorie
    public java.util.List<Article> showByCategorie(){

        Scanner in = new Scanner(System.in);

        System.out.println("Veuillez choisir le numéro d'une catégorie: \n" +
                "1 - Alimentaire\n" +
                "2 - Vestimentaire\n" +
                "3 - Eletromenager");
        int categorie = in.nextInt();

        if (categorie == 1){
            java.util.List<Article> filteredList = new ArrayList<>();

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("lait")).toList());

            filteredList.addAll(magasin.depotArticles
                    .stream().filter(article -> article.toString().toLowerCase().contains("pain")).toList());

            return filteredList;
        }
        if (categorie == 2){
            java.util.List<Article> filteredList = new ArrayList<>();

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

    public void addArticletoPanier(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Merci de saisir le nom de l'article à acheter:(pain, lait, tv, refrigerateur, chemise, pantalon)");
        String artName = scanner.nextLine();

        // Je cherche l'article puis je le mets d'ans un objet article
        Article article = magasin.depotArticles
                .stream()
                .filter(a -> a.getNom().toLowerCase().contains(artName)).findFirst().get();
        if (article == null)
            System.out.println("Article non trouvé, veuillez bien préciser le nom...");
        else {
            client.panier.add(article);
            System.out.println("L'article ci-dessous est ajouté avec succes au panier !\n \n" + article);
        }

    }

    public void deleteArticle(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom de l'article (pain, lait, tv, refrigerateur, chemise, pantalon)");
        String name = scanner.nextLine();

        // Je cherche l'article puis je le mets d'ans un objet article
        Article article = magasin.depotArticles
                .stream()
                .filter(a -> a.getNom().toLowerCase().contains(name)).findFirst().get();

        if(client.panier.remove(article))
            System.out.println("Cet article a été supprimé de votre panier : " + article);
        else
            System.out.println("Cet article n'existe pas, veuillez entrer le nom exact");
    }

    public void viderPanier(){
        if (!client.panier.isEmpty()) {
            client.panier.clear();
            System.out.println("Panier vidé !");
        }
    }

    public void showPanier(){
        System.out.println("Votre Panier contient : " + client.panier.stream().count() + " Article(s)");
        System.out.println(client.panier.toString());
    }

    public void montantTotal(){

        double total = 0;
        double prixVesttc = 0;
        double prixTvttc = 0;
        double prixRefttc = 0;
        double prixAlittc = 0;
        for (Article article: client.panier){

            if (article instanceof Alimentaire) {
                System.out.println("Je suis Alimentaire");
                prixAlittc = article.getPrix();
            }

            if (article instanceof Vestimentaire) {
                System.out.println("Je suis vestimentaire");
                if (article.getPrix() > 500) {
                    prixVesttc += article.getPrix() + (article.getPrix() * 15 / 100);
                } else prixVesttc += article.getPrix() + (article.getPrix() * 10 / 100);
            }
            if (article instanceof Television) {
                System.out.println("Je suis TV");
                if (article.getPrix() > 5000) {
                    prixTvttc += article.getPrix() + (article.getPrix() * 25 / 100);
                } else prixTvttc += article.getPrix() + (article.getPrix() * 18 / 100);
            }
            if (article instanceof Refrigerateur) {
                System.out.println("Je suis FRIGO");
                if (article.getPrix() > 5000) {
                    prixRefttc += article.getPrix() + ((article.getPrix() * 22) / 100);
                } else prixRefttc += article.getPrix() + ((article.getPrix() * 15) / 100);
            }
            total += article.getPrix();
        }
        double TTC = prixVesttc+prixRefttc+prixTvttc+prixAlittc;
        System.out.println("Total à payer HT est: " + total + " DH");
        System.out.println("Total à payer TTC est: " + TTC + " DH");
    }

    public void editerFacture() throws IOException {
        Facture facture = new Facture(client.hashCode(), client);
        facture.creerFacture();
    }

}

