package com.mycompany.tennis.controller;

import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.EpreuveLightDto;
import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.service.EpreuveService;
import com.mycompany.tennis.core.service.ScoreService;

import java.util.Scanner;

public class ScoreController {

    private ScoreService scoreService;

    public ScoreController() {
        this.scoreService=new ScoreService();
    }

    public void afficheDetailsScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant de du score dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        ScoreFullDto score = scoreService.getScore(identifiant);
        System.out.println("les sets du score sont ");
        System.out.println("Set 1 : "+score.getSet1());
        System.out.println("Set 2 : "+score.getSet2());
        if(score.getSet3()!=null){System.out.println("Set 3 : "+score.getSet3());}
        if(score.getSet4()!=null){System.out.println("Set 4 : "+score.getSet4());}
        if(score.getSet5()!=null){System.out.println("Set 5 : "+score.getSet5());}

        System.out.println("Il s'agit du tournoi "+score.getMatch().getEpreuve().getTournoi().getNom());
        System.out.println("L'epreuve s'est derouler en "+score.getMatch().getEpreuve().getAnnee()+" et il s'agisait d'une epreuve "+(score.getMatch().getEpreuve().getTypeEpreuve().charValue()=='H'?"Homme" : "Femme"));
    }
    public void supprimerScore(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du score dont vous voulez supprimer les informations?");
        Long identifiant = scanner.nextLong();
        scoreService.deleteScore(identifiant);
    }
}
