package net.rabhi.entities;

import net.rabhi.ObserverDesign.ObservableAgent;
import net.rabhi.ObserverDesign.ObserverAgent;
import net.rabhi.strategy.DefaultStrategyNotif;
import net.rabhi.strategy.StrategyNotifier;

import java.util.ArrayList;
import java.util.List;

public class Agent implements ObservableAgent, ObserverAgent {
    private String nom;
    private List<Transaction> transactions=new ArrayList<>();
    private List<ObserverAgent> observers = new ArrayList<>();
    private StrategyNotifier strategyNotifier = new DefaultStrategyNotif();

    public Agent(String nom, List<Transaction> transactions, List<ObserverAgent> observers) {
        this.nom = nom;
        this.transactions = transactions;
        this.observers = observers;
    }

    public Agent() {
    }

    @Override
    public void souscription(ObserverAgent observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverAgent observer) {
        observers.remove(observer);
    }

    @Override
    public void notifier(Agent agent, Transaction transaction) {
        System.out.println("Notification : l'agent : " +agent.getNom()+" Ajoute la transaction : " + transaction);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        for (ObserverAgent observer : observers) {

            // Afficher le nom de l'agent observateur
            if (observer instanceof Agent) { // Vérification pour s'assurer que l'observateur est un Agent
                Agent observingAgent = (Agent) observer; // Cast en Agent pour accéder au nom
                System.out.println("Je suis l'observateur. Mon nom est : " + observingAgent.getNom());
            }

            observer.notifier(this, transaction);
            //je doit faire une update après une notification
            //ici je vais utiliser la strategy

            strategyNotifier.notifyStrategy(transaction);
        }
    }

    public double maxMontant(){
        double max=0;
        for (Transaction transaction : transactions) {
            if(transaction.getMontant()>max) max=transaction.getMontant();
        }
        return max;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setObservers(List<ObserverAgent> observers) {
        this.observers = observers;
    }

    public String getNom() {
        return nom;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<ObserverAgent> getObservers() {
        return observers;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "nom='" + nom + '\'' +
                ", transactions=" + transactions +
                ", observers=" + observers +
                '}';
    }


    public void setStrategyNotifier(StrategyNotifier strategyNotifier) {
        this.strategyNotifier = strategyNotifier;
    }
}
