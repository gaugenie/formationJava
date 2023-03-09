package com.mycompany.tennis.controller;
import com.mycompany.tennis.core.dto.EpreuveFullDto;
import com.mycompany.tennis.core.dto.JoueurDto;
import com.mycompany.tennis.core.dto.MatchDto;
import com.mycompany.tennis.core.dto.ScoreFullDto;
import com.mycompany.tennis.core.service.MatchService;


import java.util.Scanner;

public class MatchController {
    private MatchService matchService;

    public MatchController() {
        this.matchService=new MatchService();
    }

    public void tapisVert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du Match dont vous voulez annuler les informations?");
        Long identifiant = scanner.nextLong();
        matchService.tapisVert(identifiant);
    }
    public void afficheDetailsMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du Match dont vous voulez afficher les informations?");
        Long identifiant = scanner.nextLong();
        MatchDto dto = matchService.getMatch(identifiant);
        System.out.println("Il s'agit d'un match de  "+ dto.getEpreuve().getAnnee() +" qui s'est deroulé a "+dto.getEpreuve().getTournoi().getNom());
        System.out.println("Le nom et le prenom du vainqueur sont "+ dto.getVainqueur().getNom() +" "+dto.getVainqueur().getPrenom());
        System.out.println("Le nom et le prenom du Finaliste sont "+ dto.getFinaliste().getNom() +" "+dto.getFinaliste().getPrenom());
        System.out.println("les sets du score sont ");
        System.out.println("Set 1 : "+dto.getScore().getSet1());
        System.out.println("Set 2 : "+dto.getScore().getSet2());
        if(dto.getScore().getSet3()!=null){System.out.println("Set 3 : "+dto.getScore().getSet3());}
        if(dto.getScore().getSet4()!=null){System.out.println("Set 4 : "+dto.getScore().getSet4());}
        if(dto.getScore().getSet5()!=null){System.out.println("Set 5 : "+dto.getScore().getSet5());}
    }
    public void ajouterMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant de l'epreuve ?");
        long epreuveId=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'indentifiant du vainqueur ?");
        long vainqueurId=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'indentifiant du finaliste ?");
        long finalisteId=scanner.nextLong();

        MatchDto dto = new MatchDto();
        dto.setEpreuve(new EpreuveFullDto());
        dto.getEpreuve().setId(epreuveId);

        dto.setFinaliste(new JoueurDto());
        dto.getFinaliste().setId(finalisteId);

        dto.setVainqueur(new JoueurDto());
        dto.getVainqueur().setId(vainqueurId);

        System.out.println("Quel est la valeur du 1er Set ?");
        byte set1=scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 2ieme Set ?");
        byte set2=scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 3ieme Set ?");
        byte set3=scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 4ieme Set ?");
        byte set4=scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 5ieme Set ?");
        byte set5=scanner.nextByte();
        scanner.nextLine();

        ScoreFullDto scoreDto = new ScoreFullDto();
        scoreDto.setSet1(set1);
        scoreDto.setSet2(set2);
        scoreDto.setSet3(set3);
        scoreDto.setSet4(set4);
        scoreDto.setSet5(set5);

        dto.setScore(scoreDto);
        scoreDto.setMatch(dto);

        matchService.createMtache(dto);
    }

    public void supprimerMatch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'indentifiant du Match dont vous voulez supprimer les informations?");
        Long identifiant = scanner.nextLong();
        matchService.deleteMatch(identifiant);
    }
}
