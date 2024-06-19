import java.awt.event.*;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
    public GuessGrid guessGrid;
    private UserInterface ui;

    public Frame(UserInterface ui) {
        this.guessGrid = new GuessGrid();
        this.ui = ui;

        this.add(guessGrid);

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
        JPanel winPanel = new JPanel();
        winPanel.setLayout(new GridBagLayout());
        winPanel.setBackground(Color.WHITE); 

        JLabel text = new JLabel("Wygrana!");
        
        JButton playAgainButton = new JButton("Zagraj ponownie");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFrame();
                ui.playAgain();
            }});

        winPanel.add(text);
        winPanel.add(playAgainButton);


        this.remove(guessGrid);
        this.add(winPanel);

        this.revalidate();
        this.repaint();
    }

    public void resetFrame() {
        System.out.println("reset");
    }

    
}
