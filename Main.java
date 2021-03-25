import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        GameFrame game = new GameFrame();

        // Display the start screen
        JPanel mainPane = (JPanel) game.getContentPane();
        mainPane.setLayout(new CardLayout());

        mainPane.add(new IntroLayout(game), "intro");
        mainPane.add(new CharacterLayout(game), "character");
        mainPane.add(new BattleLayout(game), "battle");

        game.setVisible(true);

        // set to start screen
        game.setActiveScreen("intro");

    }

}
