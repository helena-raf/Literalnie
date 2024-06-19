import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    public GuessGrid guessGrid;
    private UserInterface ui;
    private JPanel winPanel;
    private JPanel lossPanel;
    private CardLayout cardLayout;

    public Frame(UserInterface ui) {
        this.ui = ui;
        this.guessGrid = new GuessGrid();
        this.winPanel = new JPanel();
        this.lossPanel = new JPanel();
        setUpWinPanel();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(guessGrid, "mainScreen");
        this.add(winPanel, "winScreen");
        this.add(lossPanel, "lossScreen");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(300, 400));
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
        });
        this.setFocusable(true);
        this.requestFocusInWindow();
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

    public void setUpWinPanel() {
        winPanel.setLayout(new GridBagLayout());
        winPanel.setBackground(Color.WHITE); 

        JLabel text = new JLabel("Wygrana!");
        
        JButton playAgainButton = new JButton("Zagraj ponownie");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgainClicked();
            }});

        winPanel.add(text);
        winPanel.add(playAgainButton);
    }

    public void setUpLossPanel(String correctWord) {
        lossPanel.setLayout(new GridBagLayout());
        lossPanel.setBackground(Color.WHITE); 

        JLabel text = new JLabel("Przegrana... "+correctWord);
        
        JButton playAgainButton = new JButton("Zagraj ponownie");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgainClicked();
            }});

        lossPanel.add(text);
        lossPanel.add(playAgainButton);
    }

    public void showWinMessage() {
        cardLayout.show(getContentPane(), "winScreen");
    }

    public void showLossMessage(String correctWord) {
        setUpLossPanel(correctWord);

        cardLayout.show(getContentPane(), "lossScreen");
    }

    
    public void playAgainClicked() {
        this.remove(guessGrid);
        this.guessGrid = new GuessGrid();
        this.add(guessGrid, "mainScreen");
        cardLayout.show(getContentPane(), "mainScreen");
    }


    
}
