package net.rabhi;

import net.rabhi.conteneur.AdaptateurVGA;
import net.rabhi.conteneur.Conteneur;
import net.rabhi.conteneur.HDMIImpl;
import net.rabhi.conteneur.VGAImpl;
import net.rabhi.entities.Agent;
import net.rabhi.entities.Transaction;
import net.rabhi.entities.TypeTransaction;
import net.rabhi.strategy.HystoryStrategy;
import net.rabhi.strategy.ScoringStrategy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Création d'une Transaction avec builder");
        Transaction transaction = new Transaction().builder()
                .id(1)
                .date(new Date())
                .montant(2000)
                .type(TypeTransaction.VENTE)
                .build();
        System.out.println(transaction);

        Transaction transaction2 = new Transaction().builder()
                .id(2)
                .date(new Date())
                .montant(2000)
                .type(TypeTransaction.VENTE)
                .build();
        System.out.println(transaction2);

        Transaction transaction3 = new Transaction().builder()
                .id(3)
                .date(new Date())
                .montant(40000)
                .type(TypeTransaction.VENTE)
                .build();
        System.out.println(transaction3);

        Agent agent1 = new Agent();
        agent1.setNom("Agent1");
        Agent agent2 = new Agent();
        agent2.setNom("Agent2");
        System.out.println("Ajout d'une agent comme observateur dans agent1");
        agent1.souscription(agent2);
        System.out.println(agent1.toString());


        //ajouter transaction et voir comment l'observer va notifier
        agent1.setStrategyNotifier(new ScoringStrategy());
        agent1.addTransaction(transaction);

        agent1.setStrategyNotifier(new HystoryStrategy());
        agent1.addTransaction(transaction2);
        agent1.addTransaction(transaction3);

        System.out.println(agent1.getTransactions());
        System.out.println("le montant le plus grand : " + agent1.maxMontant());

        Conteneur conteneur = Conteneur.getInstance();
        conteneur.ajouterAgent("agent 1 ",agent1);

        conteneur.ajouterAgent("agent 2 ",agent2);
        conteneur.setHdmi(new HDMIImpl());
        conteneur.afficherEtat("1ere etat");

        AdaptateurVGA adaptateurVGA = new AdaptateurVGA();
        adaptateurVGA.setVga(new VGAImpl());
        conteneur.setHdmi(adaptateurVGA);
        conteneur.afficherEtat("2ere etat");
    }
}