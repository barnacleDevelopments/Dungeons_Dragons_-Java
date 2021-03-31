import javax.swing.ImageIcon;

public abstract class Enemy extends Character {

    public Enemy(String enemyName, int enemyAgility, int enemyDefense, int enemyAttack, int enemyHitPoints) {
        super(enemyName, enemyAgility, enemyDefense, enemyAttack, enemyHitPoints);
    }

    abstract ImageIcon getImageIcon();

    public void printCharacterStats() {
        System.out.println("Current Enemy: \n");
        System.out.println("name: " + getName());
        System.out.println("agility: " + getAgility());
        System.out.println("attack: " + getAttack());
        System.out.println("hit points: " + getHitPoints());
        System.out.println("defence: " + getDefense());

    }

}
