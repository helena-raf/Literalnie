import java.awt.event.*;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener{
    private JPanel mainPanel;
    private GuessGrid guessGrid;

    public Frame() {
        this.mainPanel = new JPanel();
        this.guessGrid = new GuessGrid();

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
            this.guessGrid.insertLetter(Character.toString(keyChar));
        }
        if (keyChar == '\b'){
            this.guessGrid.deleteLetter();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
