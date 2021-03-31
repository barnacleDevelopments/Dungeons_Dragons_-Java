import javax.swing.ImageIcon;

public class ChuckNorris extends Enemy {
    ImageIcon image;

    public ChuckNorris(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
        this.image = new RpgImageIcon("./images/enemies/chucknorris.jpg");
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }
}
