package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.service.JoueurService;

import java.util.Scanner;

public class JoueurController {

    private JoueurService joueurService;

    public JoueurController() {
        this.joueurService=new JoueurService();
    }

    public void afficheDetailsJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du joueur dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifiant);
        System.out.println("Le joueur selectionné s'appelle "+joueur.getPrenom() +" "+joueur.getNom());
    }

    public void creerJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nom du joueur dont vous voulez creer?");
        String nom = scanner.nextLine();
        System.out.println("Quel est le prenom du joueur dont vous voulez creer?");
        String prenom = scanner.nextLine();
        System.out.println("Quel est le sexe du joueur dont vous voulez creer?");
        char sexe = scanner.nextLine().charAt(0);
        Joueur joueur = new Joueur();
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSexe(sexe);
        joueurService.createJoueur(joueur);
        System.out.println("Le joueur a été creer avec succes et son identifiant est "+joueur.getId());

    }

    public void renommeJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du joueur dont vous voulez renommer ?");
        Long identifiant = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est le nouveau nom du joueur ?");
        String nom = scanner.nextLine();
        joueurService.renomme(identifiant, nom);
    }

    public void renommeSexeJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du joueur dont vous voulez renommer le sexe?");
        Long identifiant = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Veillez inscrit 'H' pour Homme ou 'F' pour Femme ");
        char sexe = scanner.nextLine().charAt(0);
        joueurService.renommeSexe(identifiant, sexe);
    }

    public void supprimeJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du joueur a supprimer");
        Long identifiant = scanner.nextLong();
        joueurService.deleteJoueur(identifiant);
    }

    public  void afficheListeJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est la liste des joueurs dont vous voulez afficher les informations (H) ou (F)?");
        char sexe = scanner.nextLine().charAt(0);
        for(JoueurDto dto: joueurService.getListeJoueurs(sexe)){
            System.out.println(dto.getPrenom()+" "+dto.getNom()+" "+dto.getSexe());
        }
    }

}
