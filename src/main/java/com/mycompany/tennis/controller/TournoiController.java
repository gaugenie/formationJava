package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.TournoiDto;
import com.mycompany.tennis.core.entity.Joueur;
import com.mycompany.tennis.core.entity.Tournoi;
import com.mycompany.tennis.core.service.TournoiService;

import java.util.Scanner;

public class TournoiController {

    private TournoiService tournoiService;

    public TournoiController() {
        this.tournoiService=new TournoiService();
    }
    public void afficheDetailsTournoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du tournoi dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        TournoiDto tournoi = tournoiService.getTournoi(identifiant);
        System.out.println("Le tournoi selectionné s'appelle "+tournoi.getNom() +" "+tournoi.getCode());
    }
    public void creerTournoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nom du tournoi dont vous voulez creer?");
        String nom = scanner.nextLine();
        System.out.println("Quel est le code dont vous voulez creer?");
        String code = scanner.nextLine();

        TournoiDto tournoi = new TournoiDto();
        tournoi.setNom(nom);
        tournoi.setCode(code);
        tournoiService.createTournoi(tournoi);
        System.out.println("Le Tournoir a été creer avec succes et son identifiant est "+tournoi.getId());

    }

    public void supprimeTournoi(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du tournoi a supprimer");
        Long identifiant = scanner.nextLong();
        tournoiService.deleteTournoi(identifiant);
    }
}
