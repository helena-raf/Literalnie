public class WordleGame {
    private GameLogic gameLogic;
    private UserInterface userInterface;
    private WordDictionary dictionary;


    public WordleGame() {
        this.dictionary = new WordDictionary("Literalnie/resources/polish_words.txt");
        this.gameLogic = new GameLogic();
        this.userInterface = new UserInterface();
    }

    public void initializeNewGame() {
        gameLogic.initializeGame();

        while (!gameLogic.isGameOver()) {
            String input = userInterface.getGuessFromUser();
            if (dictionary.containsWord(input)){
                gameLogic.evaluateGuess(input);
                userInterface.printColoredGuess(gameLogic.getCurrentGuess());
            }
            else {System.out.println("word doesnt exist!!");}
        }

        
        System.out.println("Game over!");
        // czekamy na input czy chce grac ponownie jesli tak to this.initializeNewGame
    }

        
    
}