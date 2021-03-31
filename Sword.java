import javax.swing.ImageIcon;

public class Sword extends Weapon {
    ImageIcon image;

    public Sword() {
        this.attackMod = 10;
        this.weight = 5;
        this.image = new RpgImageIcon("./images/weapons/sword.png");
    }

    public ImageIcon getWeaponImage() {
        return this.image;
    }
}
