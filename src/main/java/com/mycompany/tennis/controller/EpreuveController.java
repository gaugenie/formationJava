package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.EpreuveLightDto;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.service.EpreuveService;

import java.util.Scanner;

public class EpreuveController {

    private EpreuveService epreuveService;

    public EpreuveController() {
        this.epreuveService=new EpreuveService();
    }

    public void afficheDetailsEpreuve(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant de l'epreuve dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        EpreuveFullDto epreuve = epreuveService.getEpreuveDetaille(identifiant);
        System.out.println("le nom du tournoi est "+epreuve.getTournoi().getNom());

        for(JoueurDto joueurDto : epreuve.getParticipants()){
            System.out.println(joueurDto.getNom()+ " " + joueurDto.getPrenom());
        }
    }

    public void afficheRolandGaros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant de l'epreuve dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        EpreuveLightDto epreuve = epreuveService.getEpreuveSansTournoi(identifiant);
        System.out.println("l'epreuve avec l'année "+epreuve.getAnnee()+ " est de type "+epreuve.getTypeEpreuve());
    }
}
