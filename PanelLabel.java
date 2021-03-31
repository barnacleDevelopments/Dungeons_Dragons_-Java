import java.awt.Font;

import javax.swing.JLabel;
import java.awt.*;;

public class PanelLabel extends JLabel {
    public PanelLabel(String name) {
        setText(name);
        setForeground(Color.white);
        setFont(new Font("Serif", Font.BOLD, 30));
    }
}
