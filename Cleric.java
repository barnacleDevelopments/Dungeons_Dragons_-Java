import javax.swing.ImageIcon;

public class Cleric extends Player {
    ImageIcon imageIcon;

    public Cleric(String playerName, int playerAgility, int playerAttack, int playerHitPoints, int playerDefence) {
        super(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence);
        this.imageIcon = new RpgImageIcon("./images/cleric.jfif");
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

}
