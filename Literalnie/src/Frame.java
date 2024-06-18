import java.awt.event.*;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private JPanel mainPanel;
    public GuessGrid guessGrid;
    private UserInterface ui;

    public Frame(UserInterface ui) {
        this.mainPanel = new JPanel();
        this.guessGrid = new GuessGrid();
        this.ui = ui;

        setUpMainPanel();
        this.add(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 400));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
        });
    }

    private void setUpMainPanel() {
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 3.0; 
        gbc.fill = GridBagConstraints.BOTH;

        mainPanel.add(guessGrid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 4.0; 
        gbc.fill = GridBagConstraints.BOTH;

        JLabel alfabet = new JLabel();
        alfabet.setOpaque(true);
        alfabet.setBackground(Color.GREEN);
        mainPanel.add(alfabet, gbc);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    public void handleKeyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (Character.isLetter(keyChar)) {
            guessGrid.insertLetter(keyChar);
        }
        if (keyChar == '\b') {
            guessGrid.deleteLetter();
        }
        if (keyChar == '\n') { 
            String word = guessGrid.getWord();
            this.ui.userPressedEnter(word);
        }
    }

    
}
