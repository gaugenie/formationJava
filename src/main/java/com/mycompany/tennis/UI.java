package com.mycompany.tennis;

import com.mycompany.tennis.controller.*;

public class UI{
    public static void main(String... args){
        //JoueurController controller = new JoueurController();
       // controller.afficheDetailsJoueur();

        //TournoiController controller = new TournoiController();
        //controller.afficheDetailsTournoi();

        //JoueurController controller = new JoueurController();
        //controller.creerJoueur();

        //TournoiController controller = new TournoiController();
       // controller.creerTournoi();

        //JoueurController controller = new JoueurController();
        //controller.renommeJoueur();

        //JoueurController controller = new JoueurController();
        //controller.renommeSexeJoueur();

        JoueurController controller = new JoueurController();
        controller.afficheListeJoueur();

        //TournoiController controller = new TournoiController();
        //controller.supprimeTournoi();

       // EpreuveController controller = new EpreuveController();
        //controller.afficheDetailsEpreuve();

       // MatchController controller = new MatchController();
        //controller.ajouterMatch();

        //ScoreController controller = new ScoreController();
        //controller.afficheDetailsScore();
    }
}
