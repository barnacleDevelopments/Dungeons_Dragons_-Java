
import javax.swing.JPanel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameFrame game = new GameFrame();

        // Display the start screen
        JPanel mainPane = (JPanel) game.getContentPane();
        mainPane.setLayout(new CardLayout());
        game.setBackground(Color.black);

        mainPane.add(new IntroLayout(game), "intro");
        mainPane.add(new CharacterLayout(game, mainPane), "character");

        game.setVisible(true);

        // set to start screen
        game.setActiveScreen("intro");

    }
}
