package net.rabhi.conteneur;

public class HDMIImpl implements HDMI{
    @Override
    public void AfficherEtat(String message) {
        System.out.println("affichage via HDMI : " + message);
    }
}
