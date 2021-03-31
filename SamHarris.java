import javax.swing.ImageIcon;

public class SamHarris extends Enemy {
    ImageIcon image;

    public SamHarris(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/sam_harris.PNG");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
