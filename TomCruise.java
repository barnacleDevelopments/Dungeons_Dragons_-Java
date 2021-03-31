import javax.swing.ImageIcon;

public class TomCruise extends Enemy {
    ImageIcon image;

    public TomCruise(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/tom_cruise.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
