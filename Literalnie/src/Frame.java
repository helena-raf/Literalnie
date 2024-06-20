import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    private JPanel infoPanel;
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
        this.font = new Font("Arial", Font.PLAIN, 17);
        this.infoPanel = new JPanel();
        this.infoButton = new JButton("?");
        infoButton.setFont(new Font("Arial", Font.BOLD, 30));
        this.closeInfo = new JButton("X");
        closeInfo.setFont(new Font("Arial", Font.BOLD, 30));

        setUpTitle();
        setUpLossMessage();
        setUpWinMessage();
        setUpTooShort();
        setUpDoesntExist();
        setUpInfoPanel();

        //guessGrid.setBounds(0, 0, 400, 300);
        
        main.add(title, 7);
        main.add(guessGrid, 6);
        main.add(winMessage, 5);
        main.add(lossMessage, 4);
        main.add(tooShort, 3);
        main.add(doesntExist, 2);
        main.add(infoPanel,1);
        

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
        playAgainButton.setBounds(125, 340, 200, 50);
        playAgainButton.setFont(font);
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
        closeInfo.setBounds(350,70,50,50);
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
        winMessage.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));;
        winMessage.setBounds(95, 140, 260, 260);
        winMessage.setOpaque(true);
        winMessage.setBackground(Color.WHITE);
        
    }

    public void setUpLossMessage() {
        lossMessage.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));;
        lossMessage.setBounds(95, 140, 260, 260);
        lossMessage.setOpaque(true);
        lossMessage.setBackground(Color.WHITE);
        lossMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lossMessage.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpTooShort() {
        tooShort.setBounds(75, 25, 300, 50);
        tooShort.setText("Słowo musi zawierać 5 liter!");
        tooShort.setBackground(Color.BLACK);
        tooShort.setOpaque(true);
        tooShort.setFont(font);
        tooShort.setForeground(Color.WHITE);
        tooShort.setHorizontalAlignment(SwingConstants.CENTER);
        tooShort.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpDoesntExist() {
        doesntExist.setBounds(75, 25, 300, 50);
        doesntExist.setText("Brak podanego słowa w bazie!");
        doesntExist.setBackground(Color.BLACK);
        doesntExist.setOpaque(true);
        doesntExist.setFont(font);
        doesntExist.setForeground(Color.WHITE);
        doesntExist.setHorizontalAlignment(SwingConstants.CENTER);
        doesntExist.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setUpInfoPanel() {
        JPanel panel = new JPanel();
        infoPanel.setBounds(50, 70, 350, 450);
        infoPanel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(7, 1, 5, 5));
        
        
        JLabel text1 = new JLabel("<html>Wpisz dowolne 5-literowe słowo i naciśnij enter, by spróbować odgadnąć hasło.</html>");
        JLabel text2 = new JLabel("<html>Po każdej próbie, litery zostaną odpowiednio zaznaczone:</html>");
        JLabel text3 = new JLabel("<html>Jeśli litera podświetlona jest na zielono, występuje ona w haśle w tym samym miejscu.</html>");
        JLabel text4 = new JLabel("<html>Jeśli litera podświetlona jest na żółto, występuje ona w haśle, lecz w innym miejscu.</html>");
        JLabel text5 = new JLabel("<html>Jeśli litera nie jest podświetlona, nie występuje w haśle</html>");
        JLabel text6 = new JLabel("<html>Masz 6 prób, aby odgadnąć hasło. Powodzenia!</html>");


        JPanel ex = new JPanel();
        ex.setLayout(new GridLayout(1, 5, 3, 3));
        ex.setBackground(Color.WHITE);
        GridCell l1 = new GridCell();
        GridCell l2 = new GridCell();
        GridCell l3 = new GridCell();
        GridCell l4 = new GridCell();
        GridCell l5 = new GridCell();

        l1.setLetter('r');
        l2.setLetter('z');
        l3.setLetter('e');
        l4.setLetter('k');
        l5.setLetter('a');

        l1.setColor(MyColor.GREEN);
        l2.setColor(MyColor.GRAY);
        l3.setColor(MyColor.YELLOW);
        l4.setColor(MyColor.GRAY);
        l5.setColor(MyColor.GRAY);

        ex.add(l1);
        ex.add(l2);
        ex.add(l3);
        ex.add(l4);
        ex.add(l5);
        
        panel.add(text1);
        panel.add(text2);
        panel.add(ex);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        infoPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));;
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);
        infoPanel.add(panel, BorderLayout.CENTER);
    }


    public void setUpTitle() {
        title.setBounds(0, 0, 450, 80);
        title.setText("LITERALNIE");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
    }


    public void showWinMessage(String correctWord) {
        correctWord = correctWord.toUpperCase();
        String boldCorrectWord = "<html><b>" + correctWord + "</b></html>";
        winMessage.setText("<html><div style='text-align: center;'>Gratulacje! Udało Ci się odgadnąć słowo:<br>"+boldCorrectWord+"</div></html>");
       
        winMessage.setFont(new Font("Arial", Font.PLAIN, 20));
        main.setLayer(winMessage, nextLayerNumber);
        this.nextLayerNumber++;
        main.add(playAgainButton);
        main.setLayer(playAgainButton, nextLayerNumber);
        this.nextLayerNumber++;
    }

    public void showLossMessage(String correctWord) {
        correctWord = correctWord.toUpperCase();
        String boldCorrectWord = "<html><b>" + correctWord + "</b></html>";
        lossMessage.setText("<html><div style='text-align: center;'>Niestety, nie udało Ci się odgadnąć słowa...<br>Poprawne słowo to "+boldCorrectWord+"</div></html>");
        lossMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        main.setLayer(lossMessage, nextLayerNumber);
        this.nextLayerNumber++;
        main.add(playAgainButton);
        main.setLayer(playAgainButton, nextLayerNumber);
        this.nextLayerNumber++;
    }

    
    public void playAgainClicked() {
        main.remove(playAgainButton);
        GuessGrid newGuessGrid = new GuessGrid();
        main.add(newGuessGrid);
        this.guessGrid = newGuessGrid;
        unblockKeyboard();
        cover();
    }

    public void infoButtonClicked() {
        main.setLayer(infoPanel, nextLayerNumber);
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
        infoButton.setEnabled(true);
        
        main.revalidate();
        main.repaint();
        
    }

    public void blockKeyboard() {
        guessGrid.removeKeyListener(keyAdapter);
    }

    public void unblockKeyboard() {
        guessGrid.addKeyListener(keyAdapter);
    }

    public void blockInfoButton() {
        infoButton.setEnabled(false);
    }

    

}
