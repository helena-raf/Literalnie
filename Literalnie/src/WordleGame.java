public class WordleGame {
    private GameLogic gameLogic;
    private UserInterface userInterface;
    private WordDictionary dictionary;


    public WordleGame() {
        this.dictionary = new WordDictionary("Literalnie/resources/polish_words.txt", "Literalnie/resources/solutions.txt");
        this.gameLogic = new GameLogic();
        this.userInterface = new UserInterface(this);
    }

    public void initializeNewGame() {
        String solution = dictionary.getRandomSolution();
        gameLogic.initializeGame(solution);

        while (!gameLogic.isGameOver()) {
            String input = userInterface.getGuessFromUser();
            if (dictionary.containsWord(input)){
                gameLogic.evaluateGuess(input);
                userInterface.printColoredGuess(gameLogic.getCurrentGuess());
                userInterface.nextRow();
            }
            else {
                userInterface.notifyWordDoesNotExist();
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