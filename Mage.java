import javax.swing.ImageIcon;

public class Mage extends Player {
    ImageIcon imageIcon;

    public Mage(String playerName, int playerAgility, int playerAttack, int playerHitPoints, int playerDefence) {
        super(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence);
        this.imageIcon = new RpgImageIcon("./images/player_types/mage.jfif");
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

}
