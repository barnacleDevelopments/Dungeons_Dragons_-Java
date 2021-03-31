import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterLayout extends JPanel {
    PlayerSelections selections = new PlayerSelections();
    JRadioButton webBtnOption1 = new JRadioButton("Sword");
    JRadioButton webBtnOption2 = new JRadioButton("Dagger");
    JRadioButton webBtnOption3 = new JRadioButton("Wand");

    /**
     * 
     * @param game      the iframe
     * @param mainFrame the iframes panel
     * @description create new character layout
     */
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

    /**
     * 
     * @return the character type picker JPanel.
     */

    private JPanel getCharacterTypePanel() {

        JPanel typeContainerPanel = new JPanel();
        typeContainerPanel.setLayout(new BorderLayout());
        typeContainerPanel.setBackground(Color.black);
        typeContainerPanel.setOpaque(true);

        // create caracter type picker lable
        PanelLabel panelLabel = new PanelLabel("Character Type");

        // Create character Type radio Pannel
        RadioPanel typeRadioPanel = new RadioPanel();

        // create radio buttons for each type
        JRadioButton option1 = new JRadioButton("Warrior");
        JRadioButton option2 = new JRadioButton("Cleric");
        JRadioButton option3 = new JRadioButton("Mage");
        ButtonGroup buttonGroup = new ButtonGroup();
        // add radio buttons to button group
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        typeRadioPanel.add(option1);
        typeRadioPanel.add(option2);
        typeRadioPanel.add(option3);

        // create image JLabel
        JLabel characterIconLabel = new JLabel();

        // Character Description Panel
        Description description = new Description();

        // create type picker panel
        PickerPanel typePickerPanel = new PickerPanel(typeRadioPanel, characterIconLabel);

        // add listeners to each type otion radio button
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/player_types/warrior.jpg"));
                description.setText("A dope warrior...");
                selections.setPlayerType(option1.getText());
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/player_types/cleric.jfif"));
                description.setText("An amazing cleric...");
                selections.setPlayerType(option2.getText());
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterIconLabel.setIcon(new RpgImageIcon("./images/player_types/mage.jfif"));
                description.setText("A lovely mage...");
                selections.setPlayerType(option3.getText());
            }
        });

        // add child pannels to main panel
        typeContainerPanel.add(panelLabel, BorderLayout.NORTH);
        typeContainerPanel.add(typePickerPanel, BorderLayout.CENTER);
        typeContainerPanel.add(description, BorderLayout.SOUTH);

        return typeContainerPanel;
    }

    /**
     * 
     * @return the characters stat JPanel
     */

    private JPanel getCharacterStatPanel() {
        JPanel statContainerPanel = new JPanel();
        statContainerPanel.setLayout(new BorderLayout());
        statContainerPanel.setBackground(Color.black);

        // state panel label
        PanelLabel panelLabel = new PanelLabel("Character Stats");

        // Stats Panel
        JPanel statPanel = new JPanel();
        statPanel.setBackground(Color.black);
        statPanel.setForeground(Color.white);
        statPanel.setOpaque(true);
        statPanel.setLayout(new GridLayout(4, 4, 15, 15));

        // Stat panel options lables
        StatLabel stat1Label = new StatLabel("Agility");
        StatText stat1TextField = new StatText();

        StatLabel stat2Label = new StatLabel("Defence");
        StatText stat2TextField = new StatText();

        StatLabel stat3Label = new StatLabel("Hit Points");
        StatText stat3TextField = new StatText();

        StatLabel stat4Label = new StatLabel("Base Attack");
        StatText stat4TextField = new StatText();

        // add state labels and text inputs to character stats panel
        statPanel.add(stat1Label);
        statPanel.add(stat1TextField);
        statPanel.add(stat2Label);
        statPanel.add(stat2TextField);
        statPanel.add(stat3Label);
        statPanel.add(stat3TextField);
        statPanel.add(stat4Label);
        statPanel.add(stat4TextField);

        // State Panel Button listners
        JButton roleButton = new JButton("Reroll");
        roleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // role and set new random stats
                randomizeStats(stat1TextField, stat2TextField, stat3TextField, stat4TextField);

                // set stats to selection class
                selections.setPlayerAgility(Integer.parseInt(stat1TextField.getText()));
                selections.setPlayerDefense(Integer.parseInt(stat2TextField.getText()));
                selections.setPlayerHitPoints(Integer.parseInt(stat3TextField.getText()));
                selections.setPlayerAttack(Integer.parseInt(stat4TextField.getText()));
            }
        });

        // add child pannels to main panel
        statContainerPanel.add(panelLabel, BorderLayout.NORTH);
        statContainerPanel.add(statPanel, BorderLayout.CENTER);
        statContainerPanel.add(roleButton, BorderLayout.SOUTH);
        return statContainerPanel;
    }

    /**
     * 
     * @param stat1
     * @param stat2
     * @param stat3
     * @param stat4 sets a random state to each StatText provided.
     */

    private void randomizeStats(StatText stat1, StatText stat2, StatText stat3, StatText stat4) {
        StatGenerator sg = new StatGenerator();
        stat1.setText(String.valueOf(sg.getRandomStat()));
        stat2.setText(String.valueOf(sg.getRandomStat()));
        stat3.setText(String.valueOf(sg.getRandomStat()));
        stat4.setText(String.valueOf(sg.getRandomStat()));

    }

    /**
     * 
     * @return the weapon type picker JPanel.
     */

    private JPanel getWeaponTypePanel() {
        JPanel weaponContainerPanel = new JPanel();
        weaponContainerPanel.setLayout(new BorderLayout());
        weaponContainerPanel.setBackground(Color.black);

        // state panel label
        PanelLabel panelLabel = new PanelLabel("Character Weapon");

        // Character Weapon Panel
        RadioPanel weaponRadioPanel = new RadioPanel();

        // Character weapon image label
        JLabel weaponImage = new JLabel();

        PickerPanel weaponPickerPanel = new PickerPanel(weaponRadioPanel, weaponImage);

        // Character Description Panel
        Description description = new Description();

        webBtnOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(selections.getPlayerWeapon().getWeaponImage());
                description.setText(String.valueOf(selections.getPlayerWeapon().getClass()).replace("class", ""));

            }
        });
        webBtnOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(selections.getPlayerWeapon().getWeaponImage());
                description.setText(String.valueOf(selections.getPlayerWeapon().getClass()).replace("class", ""));

            }
        });
        webBtnOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponImage.setIcon(selections.getPlayerWeapon().getWeaponImage());
                description.setText(String.valueOf(selections.getPlayerWeapon().getClass()).replace("class", ""));
            }
        });

        weaponRadioPanel.add(webBtnOption1);
        weaponRadioPanel.add(webBtnOption2);
        weaponRadioPanel.add(webBtnOption3);
        ButtonGroup weaponButtonGroup = new ButtonGroup();
        weaponButtonGroup.add(webBtnOption1);
        weaponButtonGroup.add(webBtnOption2);
        weaponButtonGroup.add(webBtnOption3);

        weaponContainerPanel.add(panelLabel, BorderLayout.NORTH);
        weaponContainerPanel.add(weaponPickerPanel, BorderLayout.CENTER);
        weaponContainerPanel.add(description, BorderLayout.SOUTH);

        return weaponContainerPanel;
    }

    /**
     * 
     * @return the weapn state JPanel.
     */
    private JPanel getWeaponStatPanel() {
        JPanel weaponStatContainerPanel = new JPanel();
        weaponStatContainerPanel.setLayout(new GridLayout(0, 1));
        weaponStatContainerPanel.setBackground(Color.black);

        // state panel label
        PanelLabel panelLabel = new PanelLabel("Character Weapon Stats");

        // Character Stats PAnel
        JPanel weaponStatPanel = new JPanel();
        weaponStatPanel.setBackground(Color.black);
        weaponStatPanel.setForeground(Color.white);
        weaponStatPanel.setOpaque(true);
        weaponStatPanel.setLayout(new GridLayout(4, 4, 15, 15));

        // stat lables
        StatLabel statLabel1 = new StatLabel("Attack Modifier");
        StatText stat1 = new StatText();

        StatLabel statLabel2 = new StatLabel("Weight");
        StatText stat2 = new StatText();

        webBtnOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeapon(new Sword());
                stat1.setText(String.valueOf(selections.getPlayerWeapon().getAttackMod()));
                stat2.setText(String.valueOf(selections.getPlayerWeapon().getWeight()));
            }
        });
        webBtnOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeapon(new Dagger());
                stat1.setText(String.valueOf(selections.getPlayerWeapon().getAttackMod()));
                stat2.setText(String.valueOf(selections.getPlayerWeapon().getWeight()));
            }
        });
        webBtnOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeapon(new Wand());
                stat1.setText(String.valueOf(selections.getPlayerWeapon().getAttackMod()));
                stat2.setText(String.valueOf(selections.getPlayerWeapon().getWeight()));
            }
        });

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
