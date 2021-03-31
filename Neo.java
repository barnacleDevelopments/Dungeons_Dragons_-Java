import javax.swing.ImageIcon;

public class Neo extends Enemy {
    ImageIcon image;

    public Neo(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/neo.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
