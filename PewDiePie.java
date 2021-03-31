import javax.swing.ImageIcon;

public class PewDiePie extends Enemy {
    ImageIcon image;

    public PewDiePie(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/pewdiepie.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
