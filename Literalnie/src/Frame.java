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
        mainPanel.setBackground(new Color(255, 100, 50));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH;

        mainPanel.add(guessGrid, gbc);

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

    public void showWinMessage() {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new GridBagLayout());
        messagePanel.setBackground(Color.YELLOW); // Kolor tła dla komunikatu

        // Tworzymy etykietę z komunikatem
        JLabel label = new JLabel("Wygrana!");
        label.setFont(new Font("Arial", Font.BOLD, 24)); // Ustawiamy czcionkę i rozmiar
        label.setForeground(Color.RED); // Ustawiamy kolor tekstu

        // Dodajemy etykietę do panelu
        messagePanel.add(label);

        // Ustawiamy GridBagConstraints dla panelu z komunikatem
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.CENTER;

        // Usuwamy wszystkie komponenty z mainPanel (jeśli są) i dodajemy messagePanel
        mainPanel.removeAll();
        mainPanel.add(messagePanel, gbc);

        // Odświeżamy panel główny
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    
}
