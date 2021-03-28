import javax.swing.ImageIcon;

public abstract class Player extends Character {
    Weapon weapon;

    public Player(String playerName, int playerAgility, int playerAttack, int playerHitPoints, int playerDefense) {
        super(playerName, playerAgility, playerDefense, playerAttack, playerHitPoints);
    }

    abstract ImageIcon getImageIcon();

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return this.agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void printCharacterStats() {
        System.out.println("Current Player: \n");
        System.out.println("name: " + getName());
        System.out.println("weapon: " + getWeapon().getClass());
        System.out.println("agility: " + getAgility());
        System.out.println("attack: " + getAttack());
        System.out.println("hit points: " + getHitPoints());
        System.out.println("defence: " + getDefense());

    }
}
