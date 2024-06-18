import java.awt.event.*;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener{
    private JPanel mainPanel;
    private GuessGrid guessGrid;
    private UserInterface ui;

    public Frame(UserInterface ui) {
        this.mainPanel = new JPanel();
        this.guessGrid = new GuessGrid();
        this.ui = ui;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 400));;
        this.addKeyListener(this);
        this.add(mainPanel);
        setUpMainPanel();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(guessGrid);
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public void nextRow() {
        this.guessGrid.nextRow();
    }
}
