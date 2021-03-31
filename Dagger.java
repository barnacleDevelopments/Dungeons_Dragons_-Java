import javax.swing.ImageIcon;

public class Dagger extends Weapon {
    ImageIcon image;

    public Dagger() {
        this.attackMod = 5;
        this.weight = 2;
        this.image = new RpgImageIcon("./images/weapons/dagger.jpg");
    }

    public ImageIcon getWeaponImage() {
        return this.image;
    }

}
