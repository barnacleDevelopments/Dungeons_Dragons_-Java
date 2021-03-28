import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharacterLayout extends JPanel {
    PlayerSelections selections = new PlayerSelections();

    public CharacterLayout(GameFrame game, JPanel mainFrame) {
        this.setLayout(new BorderLayout(15, 15));

        // Page header
        JLabel heading = new JLabel("Character Creation", JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(Color.black);
        heading.setOpaque(true);

        // Name panel input
        JPanel playerNameInputPanel = new JPanel();
        playerNameInputPanel.setLayout(new BoxLayout(playerNameInputPanel, BoxLayout.Y_AXIS));
        JLabel playerNameInputLabel = new JLabel("Name: ");
        JTextField playerNameInput = new JTextField();
        playerNameInputPanel.add(heading);
        playerNameInputPanel.add(playerNameInputLabel);
        playerNameInputPanel.add(playerNameInput);

        // Character modfication panels
        JPanel modificationPanelGroup = new JPanel();
        modificationPanelGroup.setLayout(new GridLayout(2, 2, 15, 15));
        modificationPanelGroup.setBackground(Color.black);
        modificationPanelGroup.add(getCharacterTypePanel());
        modificationPanelGroup.add(getCharacterStatPanel());
        modificationPanelGroup.add(getWeaponTypePanel());
        modificationPanelGroup.add(getWeaponStatPanel());

        // to battle button
        JButton toBattleButton = new JButton("To Battle!");

        toBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerName(playerNameInput.getText());
                game.createPlayer(selections);
                mainFrame.add(new BattleLayout(game), "battle");
                game.setActiveScreen("battle");
            }
        });

        // Create character customization row two
        add(playerNameInputPanel, BorderLayout.NORTH);
        add(modificationPanelGroup, BorderLayout.CENTER);
        add(toBattleButton, BorderLayout.SOUTH);
    }

    private JPanel getCharacterTypePanel() {
        JPanel typeContainerPanel = new JPanel();
        typeContainerPanel.setLayout(new BoxLayout(typeContainerPanel, BoxLayout.Y_AXIS));
        typeContainerPanel.setBackground(Color.black);
        typeContainerPanel.setOpaque(true);

        // create caracter type picker lable
        JLabel panelLabel = new JLabel("Character Type");
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // // Character Image pannel

        // Create character Type radio Pannel
        JPanel typeRadioPanel = new JPanel();
        typeRadioPanel.setOpaque(true);
        typeRadioPanel.setBackground(Color.black);
        typeRadioPanel.setForeground(Color.black);
        typeRadioPanel.setLayout(new BoxLayout(typeRadioPanel, BoxLayout.Y_AXIS));

        // create image JLabel
        JLabel characterIconLabel = new JLabel();

        // create type picker panel
        JPanel typePickerPanel = new JPanel();
        typePickerPanel.setLayout(new BoxLayout(typePickerPanel, BoxLayout.X_AXIS));
        typePickerPanel.add(typeRadioPanel);
        typePickerPanel.add(characterIconLabel);

        // create radio buttons for each type
        JRadioButton option1 = new JRadioButton("Warrior");
        JRadioButton option2 = new JRadioButton("Cleric");
        JRadioButton option3 = new JRadioButton("Mage");
        ButtonGroup buttonGroup = new ButtonGroup();

        // add listeners to each type otion radio button
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/warrior.jpg"));
                selections.setPlayerType(option1.getText());
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/cleric.jfif"));
                selections.setPlayerType(option2.getText());
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/mage.jfif"));
                selections.setPlayerType(option3.getText());
            }
        });

        // add radio buttons to button group
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);

        // add raido buttons to type picker panel
        typePickerPanel.add(option1);
        typePickerPanel.add(option2);
        typePickerPanel.add(option3);

        // Character Description Panel
        JTextArea description = new JTextArea();

        // add child pannels to main panel
        typeContainerPanel.add(panelLabel);
        typeContainerPanel.add(typePickerPanel);
        typeContainerPanel.add(description);

        return typeContainerPanel;
    }

    private JPanel getCharacterStatPanel() {
        JPanel statContainerPanel = new JPanel();
        statContainerPanel.setLayout(new BoxLayout(statContainerPanel, BoxLayout.Y_AXIS));
        statContainerPanel.setBackground(Color.black);

        // state panel label
        JLabel panelLabel = new JLabel("Character Stats");
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Stats Panel
        JPanel statPanel = new JPanel();
        statPanel.setBackground(Color.black);
        statPanel.setForeground(Color.white);
        statPanel.setOpaque(true);
        statPanel.setLayout(new GridLayout(4, 4, 15, 15));

        // Stat panel options lables
        JLabel statLabel1 = new JLabel("Agility");
        statLabel1.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel1.setForeground(Color.white);
        JTextField stat1 = new JTextField();

        JLabel statLabel2 = new JLabel("Defence");
        statLabel2.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel2.setForeground(Color.white);
        JTextField stat2 = new JTextField();

        JLabel statLabel3 = new JLabel("Hit Points");
        statLabel3.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel3.setForeground(Color.white);
        JTextField stat3 = new JTextField();

        JLabel statLabel4 = new JLabel("Base Attack");
        statLabel4.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel4.setForeground(Color.white);
        JTextField stat4 = new JTextField();

        // add state labels and text inputs to character stats panel
        statPanel.add(statLabel1);
        statPanel.add(stat1);
        statPanel.add(statLabel2);
        statPanel.add(stat2);
        statPanel.add(statLabel3);
        statPanel.add(stat3);
        statPanel.add(statLabel4);
        statPanel.add(stat4);

        // State Panel Button listners
        JButton roleButton = new JButton("Reroll");
        roleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // role and set new random stats
                randomizeStats(stat1, stat2, stat3, stat4);

                // set stats to selection class
                selections.setPlayerAgility(Integer.parseInt(stat1.getText()));
                selections.setPlayerDefense(Integer.parseInt(stat2.getText()));
                selections.setPlayerHitPoints(Integer.parseInt(stat3.getText()));
                selections.setPlayerAttack(Integer.parseInt(stat4.getText()));
            }
        });

        // add child pannels to main panel
        statContainerPanel.add(panelLabel);
        statContainerPanel.add(statPanel);
        statContainerPanel.add(roleButton);
        return statContainerPanel;
    }

    private void randomizeStats(JTextField stat1, JTextField stat2, JTextField stat3, JTextField stat4) {
        StatGenerator sg = new StatGenerator();
        stat1.setText(String.valueOf(sg.getRandomStat()));
        stat2.setText(String.valueOf(sg.getRandomStat()));
        stat3.setText(String.valueOf(sg.getRandomStat()));
        stat4.setText(String.valueOf(sg.getRandomStat()));

    }

    private JPanel getWeaponTypePanel() {
        JPanel weaponContainerPanel = new JPanel();
        weaponContainerPanel.setLayout(new BoxLayout(weaponContainerPanel, BoxLayout.Y_AXIS));
        weaponContainerPanel.setBackground(Color.black);

        // state panel label
        JLabel panelLabel = new JLabel("Character Weapon");
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Character Weapon Panel
        JPanel weaponRadioPanel = new JPanel();
        // Character weapon image label
        JLabel weaponImage = new JLabel();
        weaponRadioPanel.setLayout(new BoxLayout(weaponRadioPanel, BoxLayout.Y_AXIS));
        JRadioButton wepOption1 = new JRadioButton("Sword");
        JRadioButton wepOption2 = new JRadioButton("Dagger");
        JRadioButton wepOption3 = new JRadioButton("Wand");

        JPanel weaponPickerPanel = new JPanel();
        weaponPickerPanel.add(weaponRadioPanel);
        weaponPickerPanel.add(weaponImage);

        wepOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(new RpgImageIcon("./images/weapons/sword.png"));
                selections.setPlayerWeaponType(wepOption1.getText());
            }
        });
        wepOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(new RpgImageIcon("./images/weapons/dagger.jpg"));
                selections.setPlayerWeaponType(wepOption2.getText());

            }
        });
        wepOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(new RpgImageIcon("./images/weapons/wand.jpg"));
                selections.setPlayerWeaponType(wepOption3.getText());

            }
        });

        weaponRadioPanel.add(wepOption1);
        weaponRadioPanel.add(wepOption2);
        weaponRadioPanel.add(wepOption3);
        ButtonGroup weaponButtonGroup = new ButtonGroup();
        weaponButtonGroup.add(wepOption1);
        weaponButtonGroup.add(wepOption2);
        weaponButtonGroup.add(wepOption3);

        // Character Description Panel
        JTextArea description = new JTextArea();

        weaponContainerPanel.add(panelLabel);
        weaponContainerPanel.add(weaponPickerPanel);
        weaponContainerPanel.add(description);

        return weaponContainerPanel;
    }

    private JPanel getWeaponStatPanel() {
        JPanel weaponStatContainerPanel = new JPanel();
        weaponStatContainerPanel.setLayout(new BoxLayout(weaponStatContainerPanel, BoxLayout.Y_AXIS));
        weaponStatContainerPanel.setBackground(Color.black);

        // state panel label
        JLabel panelLabel = new JLabel("Character Weapon Stats");
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Character Stats PAnel
        JPanel weaponStatPanel = new JPanel();
        weaponStatPanel.setBackground(Color.black);
        weaponStatPanel.setForeground(Color.white);
        weaponStatPanel.setOpaque(true);
        weaponStatPanel.setLayout(new GridLayout(3, 3, 15, 15));

        // stat lables
        JLabel statLabel1 = new JLabel("Attack Modfifier 1");
        statLabel1.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel1.setForeground(Color.white);
        JTextField stat1 = new JTextField();

        JLabel statLabel2 = new JLabel("Weight");
        statLabel2.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel2.setForeground(Color.white);
        JTextField stat2 = new JTextField();

        weaponStatPanel.add(statLabel1);
        weaponStatPanel.add(stat1);
        weaponStatPanel.add(statLabel2);
        weaponStatPanel.add(stat2);

        // add child pannels to main panel

        weaponStatContainerPanel.add(panelLabel);
        weaponStatContainerPanel.add(weaponStatPanel);

        return weaponStatContainerPanel;
    }

}
