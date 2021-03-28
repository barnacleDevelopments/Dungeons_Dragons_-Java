import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BattleLayout extends JPanel {
    Player player;
    Enemy enemy;

    public BattleLayout(GameFrame game) {
        setRandomEnemy();
        player = game.getPlayer();
        // player information / stats
        String playerName = player.getName();
        // enemy information / stats
        String enemyName = enemy.getName();

        // set layout engine
        this.setLayout(new BorderLayout());

        // configure title
        JLabel title = new JLabel("Battle To The Death!", JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(Color.green);
        title.setFont(new Font("Serif", Font.BOLD, 50));

        // configure characters panel
        JPanel playerPanel = new JPanel();
        JLabel playerLable = new JLabel("Player: " + playerName);
        JLabel playerImageLabel = new JLabel();
        playerImageLabel.setIcon(player.getImageIcon());
        playerPanel.add(playerLable);
        playerPanel.add(playerImageLabel);

        JPanel enemyPanel = new JPanel();
        JLabel enemyLable = new JLabel("Enemy: " + enemyName);
        enemyPanel.add(enemyLable);

        // configure battle text area
        JTextArea battleResultsTextArea = new JTextArea();
        battleResultsTextArea.setFont(new Font("Serif", Font.BOLD, 30));
        printGameResults(battleResultsTextArea);

        // configure play again button
        JButton playAgainButton = new JButton("Play Again");

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setActiveScreen("character");
            }
        });

        // add all elements to main layout
        add(title, BorderLayout.NORTH);
        add(playerPanel, BorderLayout.WEST);
        add(enemyPanel, BorderLayout.EAST);
        add(battleResultsTextArea, BorderLayout.CENTER);
        add(playAgainButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setRandomEnemy() {
        StatGenerator sg = new StatGenerator();
        int randomIndex = (int) (Math.random() * 5);
        int attack = sg.getRandomStat();
        int defence = sg.getRandomStat();
        int hitPoints = sg.getRandomStat();
        int agility = sg.getRandomStat();

        switch (randomIndex) {
        case 1:
            enemy = new Enemy("Gazer", agility, defence, attack, hitPoints);
            break;
        case 2:
            enemy = new Enemy("Tom Cruise", agility, defence, attack, hitPoints);
            break;
        case 3:
            enemy = new Enemy("Chuck Norris", agility, defence, attack, hitPoints);
            break;
        case 4:
            enemy = new Enemy("PewDiePie", agility, defence, attack, hitPoints);
            break;
        case 5:
            enemy = new Enemy("Sam Harris", agility, defence, attack, hitPoints);
            break;
        default:
            enemy = new Enemy("That Guy", agility, defence, attack, hitPoints);
            break;
        }
    }

    public void printGameResults(JTextArea battleResultsTextArea) {
        // player information / stats
        String playerName = player.getName();
        Weapon playerWeapon = player.getWeapon();
        int playerAgility = player.getAgility();
        int playerDefense = player.getDefense();
        int playerAttack = player.getAttack();
        int playerHitPoints = player.getHitPoints();

        // enemy information / stats
        String enemyName = enemy.getName();
        int enemyAgility = enemy.getAgility();
        int enemyDefense = enemy.getDefense();
        int enemyAttack = enemy.getAttack();
        int enemyHitPoints = enemy.getHitPoints();

        // add player info to text area
        battleResultsTextArea.append("Player: " + playerName + "\n");
        battleResultsTextArea.append("-------------------------------\n");
        battleResultsTextArea.append("Class: " + player.getClass() + "\n");
        battleResultsTextArea.append("HP: " + playerHitPoints + "        Defense: " + playerDefense
                + "        Agility: " + playerAgility + "        Base Attack: " + playerAttack + "\n");
        battleResultsTextArea.append("Weapon: " + playerWeapon.getClass() + "                 Weight: "
                + playerWeapon.getWeight() + "        Attack Mod: " + playerWeapon.getAttackMod() + "\n");

        // add enemy info to text area
        battleResultsTextArea.append("\nMonster: " + enemyName + "\n");
        battleResultsTextArea.append("-------------------------------\n");
        battleResultsTextArea.append("HP: " + enemyHitPoints + "        Defense: " + enemyDefense + "        Agility: "
                + enemyAgility + "        Base Attack: " + enemyAttack + "\n");
    }
}
