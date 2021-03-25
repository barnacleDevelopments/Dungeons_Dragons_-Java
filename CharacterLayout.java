import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CharacterLayout extends JPanel {
    PlayerSelections selections = new PlayerSelections();

    public CharacterLayout(GameFrame game) {
        this.setLayout(new BorderLayout());

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
        modificationPanelGroup.setLayout(new GridLayout(2, 2));

        modificationPanelGroup.add(getCharacterTypePanel());
        modificationPanelGroup.add(getCharacterStatPanel());
        modificationPanelGroup.add(getWeaponTypePanel());
        modificationPanelGroup.add(getWeaponStatPanel());

        // to battle button
        JButton toBattleButton = new JButton("To Battle!");

        toBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.createPlayer(selections);
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
        JLabel panelLabel = new JLabel("Character Type", JLabel.CENTER);
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // // Character Image pannel
        // JPanel imJPanel = new JPanel();
        // imJPanel.setBackground(Color.BLACK);

        // JLabel characterImage = new JLabel("", JLabel.CENTER);
        // characterImage.setIcon(new ImageIcon("images/warrior.jpg"));

        // imJPanel.add(characterImage);

        // Create character Type Picker Pannel
        JPanel typePickerPanel = new JPanel();
        typePickerPanel.setOpaque(true);
        typePickerPanel.setBackground(Color.black);
        typePickerPanel.setForeground(Color.black);

        typePickerPanel.setLayout(new BoxLayout(typePickerPanel, BoxLayout.Y_AXIS));
        // create radio buttons for each type
        JRadioButton option1 = new JRadioButton("Warrior");
        JRadioButton option2 = new JRadioButton("Cleric");
        JRadioButton option3 = new JRadioButton("Mage");
        ButtonGroup buttonGroup = new ButtonGroup();

        // add listeners to each type otion radio button
        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerType(option1.getText());
            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerType(option2.getText());
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        stat1.setText("75");

        JLabel statLabel2 = new JLabel("Defence");
        statLabel2.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel2.setForeground(Color.white);
        JTextField stat2 = new JTextField();
        stat2.setText("43");

        JLabel statLabel3 = new JLabel("Hit Points");
        statLabel3.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel3.setForeground(Color.white);
        JTextField stat3 = new JTextField();
        stat3.setText("87");

        JLabel statLabel4 = new JLabel("Base Attack");
        statLabel4.setFont(new Font("Serif", Font.BOLD, 20));
        statLabel4.setForeground(Color.white);
        JTextField stat4 = new JTextField();
        stat4.setText("23");

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
                // role random stats

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

    private JPanel getWeaponTypePanel() {
        JPanel weaponContainerPanel = new JPanel();
        weaponContainerPanel.setLayout(new BoxLayout(weaponContainerPanel, BoxLayout.Y_AXIS));
        weaponContainerPanel.setBackground(Color.black);

        // state panel label
        JLabel panelLabel = new JLabel("Character Weapon", JLabel.LEFT);
        panelLabel.setForeground(Color.white);
        panelLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Character Weapon Panel
        JPanel weaponPickerPanel = new JPanel();
        weaponPickerPanel.setLayout(new BoxLayout(weaponPickerPanel, BoxLayout.Y_AXIS));

        JRadioButton wepOption1 = new JRadioButton("Sword");
        JRadioButton wepOption2 = new JRadioButton("Dagger");
        JRadioButton wepOption3 = new JRadioButton("Wand");

        weaponPickerPanel.add(wepOption1);
        weaponPickerPanel.add(wepOption2);
        weaponPickerPanel.add(wepOption3);
        wepOption1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeaponType(wepOption1.getText());

            }
        });
        wepOption2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeaponType(wepOption2.getText());

            }
        });
        wepOption3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selections.setPlayerWeaponType(wepOption3.getText());

            }
        });

        // Character weapon image pannel
        // JPanel imJPanel = new JPanel();
        // imJPanel.setBackground(Color.BLACK);
        // JLabel characterImage = new JLabel("", JLabel.CENTER);
        // Image weaponImage = new Image();
        // weaponImage.s;
        // characterImage.setIcon(weaponImage);
        // imJPanel.add(characterImage);

        // Character Description Panel
        JTextArea description = new JTextArea();

        weaponContainerPanel.add(panelLabel);

        weaponContainerPanel.add(weaponPickerPanel);
        // weaponContainerPanel.add(imJPanel);

        weaponContainerPanel.add(description);
        return weaponContainerPanel;
    }

    private JPanel getWeaponStatPanel() {
        JPanel weaponStatContainerPanel = new JPanel();
        weaponStatContainerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        weaponStatContainerPanel.setBackground(Color.black);

        // state panel label
        JLabel panelLabel = new JLabel("Character Weapon Stats", JLabel.LEFT);
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
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        weaponStatContainerPanel.add(panelLabel, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        weaponStatContainerPanel.add(weaponStatPanel, gbc);

        return weaponStatContainerPanel;
    }

}
