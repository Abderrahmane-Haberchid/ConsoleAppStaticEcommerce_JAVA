package org.example.classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Facture {

    public int numSerie;
    Client client;

    public Facture(int numSerie, Client client) {
        this.numSerie = numSerie;
        this.client = client;
    }

    public void creerFacture() throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom du dossier où votre fature sera sauvegardé:");
        String directory = in.nextLine();

        Files.createDirectories(Paths.get("C:/"+directory));

        final String path = "C:/"+directory+"/facture_" + numSerie + "_" + client.getNom() + ".txt";
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write("--------- Facture pour le client " + client.getNom().toUpperCase()+" -----------------");

            // =================== Logic facture =========================================

            double total = 0;
            double prixVesttc = 0;
            double prixTvttc = 0;
            double prixRefttc = 0;
            double prixAlittc = 0;
            String taxeTv;
            String taxeRef = "";
            String taxeVes = "";
            double sommeTTC = 0;

            // On vérifie chaque article dans le panier appartient ququel article
            // Puis on calcule le prix TTC dependement de l'article
            for (Article article: client.panier){

                if (article instanceof Alimentaire) {
                    bw.write("\nProduit : Alimentaire");
                    bw.write("\n Type : "+article.getNom());
                    bw.write("\n Prix HT : "+article.getPrix());

                    bw.write("\n Prix TTC : " + article.getPrix());
                    bw.write("\n Taxe : Aucune taxe n'est appliquée (Pas de taxe demandé suite à l'examen) ");
                    bw.write("\n ====================================================");
                    prixAlittc = article.getPrix();
                    sommeTTC += prixAlittc;
                }

                if (article instanceof Vestimentaire) {
                    bw.write("\nProduit : Vestimentaire");
                    bw.write("\n Type : "+article.getNom());
                    bw.write("\n Prix HT : "+article.getPrix());
                    if (article.getPrix() > 500) {
                        taxeVes = "+ Taxe Solidarité 5%";
                        prixVesttc = article.getPrix() + (article.getPrix() * 15 / 100);
                    } else {
                        prixVesttc = article.getPrix() + (article.getPrix() * 10 / 100);
                        taxeVes = "";
                    }

                    bw.write("\n Prix TTC : " + prixVesttc);
                    bw.write("\n Taxe : TVA 10% " + taxeVes);
                    bw.write("\n ====================================================");
                    sommeTTC += prixVesttc;
                }
                if (article instanceof Television) {
                    bw.write("\nProduit : TV");
                    bw.write("\n Type : "+article.getNom());
                    bw.write("\n Prix HT : "+article.getPrix());

                    if (article.getPrix() > 5000) {
                        taxeTv = " Taxe AudioVisuelle 3% + Taxe Carbone 7%";
                        prixTvttc = article.getPrix() + (article.getPrix() * 25 / 100);
                    } else{
                        prixTvttc = article.getPrix() + (article.getPrix() * 18 / 100);
                        taxeTv = " Taxe AudioVisuelle 3%";
                    }
                    bw.write("\n Prix TTC : " + prixTvttc);
                    bw.write("\n Taxe : TVA 15% +" + taxeTv);
                    bw.write("\n ====================================================");
                    sommeTTC += prixTvttc;
                }
                if (article instanceof Refrigerateur) {
                    bw.write("\nProduit : Refrigerateur");
                    bw.write("\n Type : "+article.getNom());
                    bw.write("\n Prix HT : "+article.getPrix());
                    if (article.getPrix() > 5000) {
                        taxeRef = "+ Taxe Carbone 7%";
                        prixRefttc = article.getPrix() + ((article.getPrix() * 22) / 100);
                    } else prixRefttc = article.getPrix() + ((article.getPrix() * 15) / 100);

                    bw.write("\n Prix TTC : " + prixRefttc);
                    bw.write("\n Taxe : TVA 15% " + taxeRef);
                    bw.write("\n ====================================================");
                    sommeTTC += prixRefttc;
                }
                total += article.getPrix();
            }
            double TTC = prixVesttc+prixRefttc+prixTvttc+prixAlittc;
            bw.write("\n ======= Montant de votre facture =========== \n");
            bw.write("\nTotal à payer HT est: " + total + " DH");
            bw.write("\nTotal à payer TTC est: " + sommeTTC + " DH");

            // =================== End Logic Facture ===================================================

            System.out.println("Facture Créée avec Succes dans le chemin C:/"+directory+"/...");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            assert bw != null;
            bw.close();
            fw.close();
        }



    }
}
