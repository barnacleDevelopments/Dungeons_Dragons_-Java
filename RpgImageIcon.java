import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RpgImageIcon extends ImageIcon {

    public RpgImageIcon(String FileName) {
        BufferedImage imageBuff = null;
        try {
            imageBuff = ImageIO.read(new File(FileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setImage(imageBuff.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    }
}
