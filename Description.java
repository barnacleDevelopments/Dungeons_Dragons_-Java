import java.awt.Font;

import javax.swing.JTextArea;

public class Description extends JTextArea {
    public Description() {
        setFont(new Font("serif", Font.BOLD, 20));
        setEditable(false);
    }
}
