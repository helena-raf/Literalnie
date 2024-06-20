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
    private JLabel title;
    private Font font;
    private JButton infoButton;
    private JButton closeInfo;
    private JLabel infoLabel;
    private KeyAdapter keyAdapter;

    public Frame(UserInterface ui) {
        this.ui = ui;
        this.guessGrid = new GuessGrid();
        this.winMessage = new JLabel();
        this.lossMessage = new JLabel();
        this.main = new JLayeredPane();
        this.nextLayerNumber = 9;
        this.tooShort = new JLabel();
        this.doesntExist = new JLabel();
        this.title = new JLabel();
        this.font = new Font("Arial", Font.PLAIN, 15);
        this.infoLabel = new JLabel();
        this.infoButton = new JButton("info");
        this.closeInfo = new JButton("X");

        setUpTitle();
        setUpLossMessage();
        setUpWinMessage();
        setUpTooShort();
        setUpDoesntExist();
        setUpInfoLabel();

        //guessGrid.setBounds(0, 0, 400, 300);
        
        main.add(title, 7);
        main.add(guessGrid, 6);
        main.add(winMessage, 5);
        main.add(lossMessage, 4);
        main.add(tooShort, 3);
        main.add(doesntExist, 2);
        main.add(infoLabel,1);
        

        //main.setBounds(0, 0, 400, 300);
        add(main, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }};
        guessGrid.addKeyListener(keyAdapter);
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
        
        infoButton.setBounds(0,0,50,50);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoButtonClicked();
            }});
        closeInfo.setBounds(100,0,50,50);
        closeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeInfoClicked();
            }});

        main.add(infoButton, 8);
        cover();
       
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
        tooShort.setBounds(75, 30, 300, 50);
        tooShort.setText("Słowo musi zawierać 5 liter!");
        tooShort.setBackground(Color.BLACK);
        tooShort.setOpaque(true);
        tooShort.setFont(font);
        tooShort.setForeground(Color.WHITE);
        tooShort.setHorizontalAlignment(SwingConstants.CENTER);
        tooShort.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpDoesntExist() {
        doesntExist.setBounds(75, 30, 300, 50);
        doesntExist.setText("Brak podanego słowa w bazie!");
        doesntExist.setBackground(Color.BLACK);
        doesntExist.setOpaque(true);
        doesntExist.setFont(font);
        doesntExist.setForeground(Color.WHITE);
        doesntExist.setHorizontalAlignment(SwingConstants.CENTER);
        doesntExist.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpInfoLabel() {
        infoLabel.setBounds(0, 200, 450, 80);
        infoLabel.setText("info");
        infoLabel.setBackground(Color.WHITE);
        infoLabel.setOpaque(true);
        infoLabel.setFont(font);
        infoLabel.setForeground(Color.BLACK);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpTitle() {
        title.setBounds(0, 0, 450, 80);
        title.setText("tytul");
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setFont(font);
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
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
        newGuessGrid.addKeyListener(keyAdapter);
        main.add(newGuessGrid);
        
        this.guessGrid = newGuessGrid;
        cover();
    }

    public void infoButtonClicked() {
        main.setLayer(infoLabel, nextLayerNumber);
        this.nextLayerNumber++;
        main.add(closeInfo);
        main.setLayer(closeInfo, nextLayerNumber);
        this.nextLayerNumber++;
    }

    public void closeInfoClicked() {
        main.remove(closeInfo);
        cover();
    }
    
    public void tooShortInfo() {
        main.setLayer(tooShort, nextLayerNumber);
        this.nextLayerNumber++;

        Timer timer = new Timer(2000, e -> {
            cover();
        });
        timer.setRepeats(false); 
        timer.start();

    }

    public void doesNotExistInfo() {
        main.setLayer(doesntExist, nextLayerNumber);
        this.nextLayerNumber++;

        Timer timer = new Timer(2000, e -> {
            cover();
        });
        timer.setRepeats(false); 
        timer.start();
    }

    public void cover() {
        main.setLayer(guessGrid, nextLayerNumber);
        nextLayerNumber++;
        main.setLayer(title, nextLayerNumber);
        nextLayerNumber++;
        main.setLayer(infoButton, nextLayerNumber);
        nextLayerNumber++;
        guessGrid.requestFocusInWindow();
        
        
        main.revalidate();
        main.repaint();
        
    }

}
