import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class IntroLayout extends JPanel {

    public IntroLayout(GameFrame game) {
        this.setLayout(new BorderLayout());

        // configure title
        JLabel title = new JLabel("Welcome to Dungeons and Dragons", JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setForeground(Color.black);
        title.setFont(new Font("Serif", Font.BOLD, 50));

        // configure image
        JPanel imJPanel = new JPanel();
        imJPanel.setBackground(Color.BLACK);
        imJPanel.setSize(100, 100);
        JLabel jLabel1 = new JLabel("", JLabel.CENTER);
        jLabel1.setIcon(new ImageIcon("images/m53Vyq.jpg"));
        jLabel1.setSize(100, 100);
        imJPanel.add(jLabel1);

        // configure button
        JButton startButton = new JButton("START");
        startButton.setSize(200, 100);
        this.setVisible(true);

        // add components to maim panel
        this.add(title, BorderLayout.NORTH);
        this.add(imJPanel, BorderLayout.CENTER);
        this.add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setActiveScreen("character");
            }
        });
    }

}
