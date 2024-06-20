import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    public GuessGrid guessGrid;
    private UserInterface ui;
    private JLabel winMessage;
    private JLabel lossMessage;
    private JLayeredPane main;
    private int nextLayerNumber;
    private JLabel tooShort;
    private JLabel doesntExist;
    private JButton playAgainButton;

    public Frame(UserInterface ui) {
        this.ui = ui;
        this.guessGrid = new GuessGrid();
        this.winMessage = new JLabel();
        this.lossMessage = new JLabel();
        this.main = new JLayeredPane();
        this.nextLayerNumber = 6;
        this.tooShort = new JLabel();
        this.doesntExist = new JLabel();

        setUpLossMessage();
        setUpWinMessage();
        setUpTooShort();
        setUpDoesntExist();

        guessGrid.setBounds(0, 0, 300, 400);
        main.add(guessGrid, 5);
        main.add(winMessage, 4);
        main.add(lossMessage, 3);
        main.add(tooShort, 2);
        main.add(doesntExist, 1);

        main.setBounds(0, 0, 400, 300);
        add(main, BorderLayout.CENTER);

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
        this.setResizable(false);
        this.playAgainButton = new JButton("Zagraj ponownie");
        playAgainButton.setBounds(100, 100, 50, 50);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgainClicked();
            }});
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

    public void setUpWinMessage() {
        winMessage.setBounds(0, 0, 400, 300);
        winMessage.setText("Wygrana!");
    }

    public void setUpLossMessage() {
        lossMessage.setBounds(0, 0, 400, 300);
        lossMessage.setText("przegrana");
    }

    public void setUpTooShort() {
        tooShort.setBounds(100, 100, 50, 50);
        tooShort.setText("za krotkie");
    }

    public void setUpDoesntExist() {
        doesntExist.setBounds(100, 100, 50, 50);
        doesntExist.setText("nie istnieje");
    }

    public void showWinMessage() {
        main.setLayer(winMessage, nextLayerNumber);
        this.nextLayerNumber++;
        main.add(playAgainButton);
        main.setLayer(playAgainButton, nextLayerNumber);
        this.nextLayerNumber++;
    }

    public void showLossMessage(String correctWord) {
        main.setLayer(lossMessage, nextLayerNumber);
        this.nextLayerNumber++;
        main.add(playAgainButton);
        main.setLayer(playAgainButton, nextLayerNumber);
        this.nextLayerNumber++;
    }

    
    public void playAgainClicked() {
        main.remove(playAgainButton);
        GuessGrid newGuessGrid = new GuessGrid();
    
        newGuessGrid.setBounds(0, 0, 300, 400);
        main.add(newGuessGrid);
        main.setLayer(newGuessGrid, nextLayerNumber);
        this.nextLayerNumber++;

        this.guessGrid = newGuessGrid;
        main.revalidate();
        main.repaint();
        newGuessGrid.requestFocusInWindow();
        newGuessGrid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e); 
            }
        });
    }
    
    public void tooShortInfo() {
        main.setLayer(tooShort, nextLayerNumber);
        this.nextLayerNumber++;

        Timer timer = new Timer(2000, e -> {
            main.setLayer(guessGrid, nextLayerNumber);
            nextLayerNumber++;
        });
        timer.setRepeats(false); 
        timer.start();

    }

    public void doesNotExistInfo() {
        main.setLayer(doesntExist, nextLayerNumber);
        this.nextLayerNumber++;

        Timer timer = new Timer(2000, e -> {
            main.setLayer(guessGrid, nextLayerNumber);
            nextLayerNumber++;
        });
        timer.setRepeats(false); 
        timer.start();
    }

}
