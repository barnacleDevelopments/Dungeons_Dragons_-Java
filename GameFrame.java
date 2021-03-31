import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameFrame extends JFrame {
    Player player;

    public GameFrame() {
        this.setBounds(0, 0, 1500, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 
     * @param screenName
     * @description sets the current active screen.
     */
    public void setActiveScreen(String screenName) {
        CardLayout layout = (CardLayout) this.getContentPane().getLayout();
        layout.show(this.getContentPane(), screenName);
    }

    /**
     * 
     * @param selections
     * @description creates a new player class based on selection class paramers.
     */
    public void createPlayer(PlayerSelections selections) {
        String playerName = selections.getPlayerName();
        String playerType = selections.getPlayerType();
        Weapon playerWeapon = selections.getPlayerWeapon();
        int playerAgility = selections.getPlayerAgility();
        int playerAttack = selections.getPlayerAttack();
        int playerHitPoints = selections.getPlayerHitPoints();
        int playerDefence = selections.getPlayerDefense();

        switch (playerType) {
        case "Warrior":
            setPlayer(new Warrior(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence));
            break;
        case "Cleric":
            setPlayer(new Cleric(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence));
            break;
        case "Mage":
            setPlayer(new Mage(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence));
            break;
        default:
            setPlayer(new Warrior(playerName, playerAgility, playerAttack, playerHitPoints, playerDefence));
            break;
        }
        player.setWeapon(playerWeapon);

        player.printCharacterStats();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
