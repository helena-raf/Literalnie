public class WordleGame {
    private GameLogic gameLogic;
    private UserInterface userInterface;
    private WordDictionary dictionary;


    public WordleGame() {
        this.dictionary = new WordDictionary("Literalnie/resources/polish_words.txt");
        this.gameLogic = new GameLogic();
        this.userInterface = new UserInterface(this);
    }

    public void initializeNewGame() {
        System.out.println("nowa grar");
        gameLogic.initializeGame();

        while (!gameLogic.isGameOver()) {
            String input = userInterface.getGuessFromUser();
            if (dictionary.containsWord(input)){
                gameLogic.evaluateGuess(input);
                userInterface.printColoredGuess(gameLogic.getCurrentGuess());
                userInterface.nextRow();
            }
            else {
                System.out.println("word doesnt exist!!");
            }
        }

        if (gameLogic.hasPlayerWon()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            userInterface.handleWin();
        }
        else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            userInterface.handleLoss(gameLogic.getCorrectWord().getString());
        }
    
    }

        
    
}