import javax.swing.ImageIcon;

public class AdamSandler extends Enemy {
    ImageIcon image;

    public AdamSandler(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/adam_sandler.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
