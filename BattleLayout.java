import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleLayout extends JPanel {
    Player player;
    Enemy enemy;

    /**
     * 
     * @param game the iframes panel
     */
    public BattleLayout(GameFrame game) {
        setRandomEnemy();
        player = game.getPlayer();
        // player information / stats
        String playerName = player.getName();
        // enemy information / stats
        String enemyName = enemy.getName();

        // set layout engine
        this.setLayout(new BorderLayout(15, 15));

        // configure title
        JLabel title = new JLabel("Battle To The Death!", JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(Color.black);
        title.setFont(new Font("Serif", Font.BOLD, 50));

        // configure characters panel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        JLabel playerLable = new JLabel("Player: " + playerName);
        playerLable.setFont(new Font("serif", Font.BOLD, 30));
        JLabel playerImageLabel = new JLabel();
        playerImageLabel.setIcon(player.getImageIcon());
        playerPanel.add(playerLable);
        playerPanel.add(playerImageLabel);

        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.Y_AXIS));
        JLabel enemyLable = new JLabel("Enemy: " + enemyName);
        enemyLable.setFont(new Font("serif", Font.BOLD, 30));
        JLabel enemyImageLabel = new JLabel();
        enemyImageLabel.setIcon(enemy.getImageIcon());
        enemyPanel.add(enemyLable);
        enemyPanel.add(enemyImageLabel);

        // configure battle text area
        JTextArea battleResultsTextArea = new JTextArea();
        battleResultsTextArea.setLineWrap(true);
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

    /**
     * @description sets a random enemy.
     */
    public void setRandomEnemy() {
        StatGenerator sg = new StatGenerator();
        int randomIndex = (int) (Math.random() * 6);

        int attack = sg.getRandomStat();
        int defence = sg.getRandomStat();
        int hitPoints = sg.getRandomStat();
        int agility = sg.getRandomStat();
        System.out.println(randomIndex);
        switch (randomIndex) {
        case 0:
            enemy = new Neo("Neo", agility, defence, attack, hitPoints);
            break;
        case 1:
            enemy = new TomCruise("Tom Cruise", agility, defence, attack, hitPoints);
            break;
        case 2:
            enemy = new ChuckNorris("Chuck Norris", agility, defence, attack, hitPoints);
            break;
        case 3:
            enemy = new PewDiePie("PewDiePie", agility, defence, attack, hitPoints);
            break;
        case 4:
            enemy = new SamHarris("Sam Harris", agility, defence, attack, hitPoints);
            break;
        case 5:
            enemy = new AdamSandler("Adam Sandler", agility, defence, attack, hitPoints);
            break;
        }
    }

    /**
     * 
     * @param battleResultsTextArea
     * @desription print the character and enenmy state to JTextArea.
     */
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
        battleResultsTextArea.append("Class: " + String.valueOf(player.getClass()).replace("class", "") + "\n");
        battleResultsTextArea.append("HP: " + playerHitPoints + "        Defense: " + playerDefense
                + "        Agility: " + playerAgility + "        Base Attack: " + playerAttack + "\n");
        battleResultsTextArea.append(
                "Weapon: " + String.valueOf(playerWeapon.getClass()).replace("class", "") + "                 Weight: "
                        + playerWeapon.getWeight() + "        Attack Mod: " + playerWeapon.getAttackMod() + "\n");

        // add enemy info to text area
        battleResultsTextArea.append("\nMonster: " + enemyName + "\n");
        battleResultsTextArea.append("-------------------------------\n");
        battleResultsTextArea.append("HP: " + enemyHitPoints + "        Defense: " + enemyDefense + "        Agility: "
                + enemyAgility + "        Base Attack: " + enemyAttack + "\n");
    }
}
