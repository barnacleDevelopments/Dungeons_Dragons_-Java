import java.util.ArrayList;

public abstract class Character {
    String name;
    int hitPoints;
    int defense;
    int agility;
    int attack;

    public Character(String name, int agility, int defense, int attack, int hitPoints) {
        this.name = name;
        this.agility = agility;
        this.defense = defense;
        this.attack = attack;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    abstract void printCharacterStats();

}