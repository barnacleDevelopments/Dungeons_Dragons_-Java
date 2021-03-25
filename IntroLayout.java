import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class IntroLayout extends JPanel {

    public IntroLayout(GameFrame game) {
        this.setLayout(new FlowLayout());

        // configure title
        JLabel title = new JLabel("Welcome to Dungeons and Dragons", JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(Color.green);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        this.add(title);

        // configure image
        JPanel imJPanel = new JPanel();
        imJPanel.setBackground(Color.BLACK);
        imJPanel.setSize(100, 100);
        JLabel jLabel1 = new JLabel("", JLabel.CENTER);
        jLabel1.setIcon(new ImageIcon("images/m53Vyq.jpg"));
        jLabel1.setSize(100, 100);
        imJPanel.add(jLabel1);

        this.add(imJPanel);

        // configure button
        JButton startButton = new JButton("START");
        this.add(startButton);
        startButton.setSize(200, 100);
        this.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setActiveScreen("character");
            }
        });
    }

}
