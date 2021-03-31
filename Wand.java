import javax.swing.ImageIcon;

public class Wand extends Weapon {
    ImageIcon image;

    public Wand() {
        this.attackMod = 1;
        this.weight = 1;
        this.image = new RpgImageIcon("./images/weapons/wand.jpg");
    }

    public ImageIcon getWeaponImage() {
        return this.image;
    }

}
