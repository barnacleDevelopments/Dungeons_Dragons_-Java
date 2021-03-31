import javax.swing.ImageIcon;

public class Warrior extends Player {
    ImageIcon imageIcon;

    public Warrior(String playerName, int playerAgility, int playerAttack, int playerHitPoints, int playerDefence) {
        super(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence);
        this.imageIcon = new RpgImageIcon("./images/player_types/warrior.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

}
