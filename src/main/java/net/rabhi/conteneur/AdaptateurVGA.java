package net.rabhi.conteneur;

public class AdaptateurVGA implements HDMI{
    private VGA vga;
    @Override
    public void AfficherEtat(String message) {
        System.out.println("utilisation de adaptateur.");
        vga.AfficherEtatViaVGA(message);
    }

    public void setVga(VGA vga) {
        this.vga = vga;
    }

}
