package net.rabhi.conteneur;

import net.rabhi.entities.Agent;

import java.util.HashMap;

public class Conteneur {
    public static final Conteneur INSTANCE;//la seule instance de conteneur
    static {
        System.out.println("L'istantiation de la seule instance de Conteneur.");
        INSTANCE = new Conteneur();
    }

    private HashMap<String, Agent> agents=new HashMap<>();

    private HDMI hdmi;

    public static Conteneur getInstance(){
        return INSTANCE;
    }
    // Ajouter un agent
    public void ajouterAgent(String nom, Agent agent) {
        if (!agents.containsKey(nom)) {
            agents.put(nom, agent);
            System.out.println("Agent ajouté : " + nom);
        } else {
            System.out.println("Agent avec le nom " + nom + " existe déjà !");
        }
    }

    // Supprimer un agent
    public void supprimerAgent(String nom) {
        if (agents.containsKey(nom)) {
            agents.remove(nom);
            System.out.println("Agent supprimé : " + nom);
        } else {
            System.out.println("Aucun agent trouvé avec le nom : " + nom);
        }
    }


    // Rechercher un agent
    public Agent rechercherAgent(String nom) {
        if (agents.containsKey(nom)) {
            System.out.println("Agent trouvé : " + nom);
            return agents.get(nom);
        } else {
            System.out.println("Aucun agent trouvé avec le nom : " + nom);
            return null;
        }
    }

    // Afficher tous les agents
    public void afficherTousLesAgents() {
        if (agents.isEmpty()) {
            System.out.println("Aucun agent dans le conteneur.");
        } else {
            System.out.println("Liste des agents : ");
            for (String nom : agents.keySet()) {
                System.out.println("Nom : " + nom + ", Détails : " + agents.get(nom));
            }
        }
    }


    public void afficherEtat(String etat){
        hdmi.AfficherEtat(etat);
    }

    public void setHdmi(HDMI hdmi) {
        this.hdmi = hdmi;
    }


}
