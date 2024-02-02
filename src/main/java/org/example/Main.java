package org.example;

import org.example.classes.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

     static int choice;
    static int choiceUser;
     final static ManagerService managerService = new ManagerService();
    // Facture facture = new Facture(client);
    public static void main(String[] args) throws IOException, ValidationExeption {

        Scanner sc = new Scanner(System.in);

        System.out.println("Vous êtes manager ou client ? m / c");
        String user = sc.nextLine();

        if (user.equals("m")) {
            managerService.creerMagasin();
              do {
                  System.out.println("1 – Ajouter un nouvel article\n" +
                          "2 – Afficher la liste des articles par catégorie\n" +
                          "3 – Afficher tous les articles présents dans le dépôt\n" +
                          "4 – Supprimer un article\n" +
                          "5 – Quitter le programme");

                  choice = sc.nextInt();

                  if (choice == 1) managerService.ajouterArticle();
                  if (choice == 2) System.out.println(managerService.showByCategorie());
                  if (choice == 3) System.out.println(managerService.showAllArticles());
                  if (choice == 4) managerService.deleteArticle();
              }
              while (choice != 5);
        }
        if (user.equals("c")){
            final UserService userService = new UserService();
            userService.creerClient();

            do {
                System.out.println("1 – Afficher les articles disponibles par catégorie\n" +
                        "2 – Ajouter un article au panier\n" +
                        "3 – Supprimer un article du panier\n" +
                        "4 – Vider le panier\n" +
                        "5 – Calculer le montant total\n" +
                        "6 –  Afficher Panier\n" +
                        "7 –  EditerFacture\n" +
                        "8 – Quitter le programme");

                choiceUser = sc.nextInt();

                if (choiceUser == 1) System.out.println(userService.showByCategorie());
                if (choiceUser == 2) userService.addArticletoPanier();
                if (choiceUser == 3) userService.deleteArticle();
                if (choiceUser == 4) userService.viderPanier();
                if (choiceUser == 5) userService.montantTotal();
                if (choiceUser == 6) userService.showPanier();
                if (choiceUser == 7) userService.editerFacture();
            }
            while (choiceUser != 8);

        }

    }
}