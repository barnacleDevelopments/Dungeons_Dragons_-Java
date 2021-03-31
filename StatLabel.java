import java.awt.Font;

import javax.swing.JLabel;
import java.awt.*;

public class StatLabel extends JLabel {
    public StatLabel(String name) {
        setText(name);
        setFont(new Font("Serif", Font.BOLD, 20));
        setForeground(Color.white);
    }
}
