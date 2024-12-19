package net.rabhi.conteneur;

public class VGAImpl implements VGA{

    @Override
    public void AfficherEtatViaVGA(String etat) {
        System.out.println("Affichage via VGA : "+ etat);
    }
}
