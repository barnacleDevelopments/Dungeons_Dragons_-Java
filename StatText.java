import java.awt.Font;

import javax.swing.JTextArea;

public class StatText extends JTextArea {

    public StatText() {
        setFont(new Font("serif", Font.BOLD, 20));
        setEditable(false);
    }

}
