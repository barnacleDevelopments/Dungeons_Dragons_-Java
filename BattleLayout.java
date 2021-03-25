import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BattleLayout extends JPanel {

    public BattleLayout(GameFrame game) {
        this.setLayout(new FlowLayout());

        // configure title
        JLabel title = new JLabel("Battle To The Death!", JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(Color.green);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        this.add(title);

        // configure characters
        JPanel playerPanel = new JPanel();
        JLabel playerLable = new JLabel("Player: ");
        playerPanel.add(playerLable);

        JPanel enemyPanel = new JPanel();
        JLabel enemyLable = new JLabel("Enemy: ");
        enemyPanel.add(enemyLable);

        // battle text area
        JTextArea battleArena = new JTextArea();

        // play again button
        JButton playAgainButton = new JButton("Play Again");

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setActiveScreen("character");

            }
        });

        // add
        add(title);
        add(playerPanel);
        add(enemyPanel);
        add(battleArena);
        add(playAgainButton);

        setVisible(true);
    }

}
