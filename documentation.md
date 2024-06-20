## Main
The `Main` class serves as the entry point for the Wordle game application. It initializes a new instance of the `WordleGame` class and starts a new game by calling the `initializeNewGame` method.

### Main functionalities
The main functionality of the `Main` class is to act as the starting point of the application. It creates an instance of the `WordleGame` class and initiates the game.
___
### Methods
- `main(String[] args)`: The main method that serves as the entry point of the application. It initializes the `WordleGame` and starts a new game.
___
### Fields
The `Main` class does not have any fields.
___


## Wordle Game Class
The `WordleGame` class orchestrates the overall game flow of a Wordle-like game. It initializes the game components, manages the game loop, and handles user interactions and game state transitions.

### Main functionalities
- Initializes game components such as the dictionary, game logic, and user interface.
- Manages the game loop, processing user guesses and updating the game state.
- Handles end-of-game scenarios, including win and loss conditions.
___
### Methods
- `WordleGame()`: Constructor that initializes the dictionary, game logic, and user interface.
- `initializeNewGame()`: Sets up a new game by selecting a random solution word, running the game loop, and handling the end-of-game scenarios.
___
### Fields
- `GameLogic gameLogic`: Manages the core game logic, including guess evaluation and game state.
- `UserInterface userInterface`: Handles user interactions and updates the game display.
- `WordDictionary dictionary`: Manages the set of valid words and solution candidates.
___


## Game Logic Class
The `GameLogic` class manages the core logic of a word-guessing game. It handles game initialization, processing guesses, evaluating correctness, and tracking the game state, including attempts and whether the player has won or lost.

### Main functionalities
- Initialize the game with a correct word.
- Process and evaluate player guesses.
- Track the number of attempts and determine if the game is over.
- Check if the player has won.
___
### Methods
- `initializeGame(String correctWord)`: Sets up the game with the correct word and initializes game state variables.
- `setCurrentGuess(String guess)`: Sets the current guess as a `ColoredWord`.
- `getCurrentGuess()`: Returns the current guess.
- `isGuessCorrect()`: Checks if the current guess matches the correct word.
- `evaluateGuess(String guess)`: Processes the guess, updates attempt count, colors the guess, and checks game status.
- `colorGuess()`: Colors the letters in the guess based on their correctness.
- `isAttemptsLimitReached()`: Checks if the maximum number of attempts has been reached.
- `isGameOver()`: Returns whether the game is over.
- `hasPlayerWon()`: Returns whether the player has won.
- `getCorrectWord()`: Returns the correct word.
___
### Fields
- `attemptCount`: Tracks the number of attempts made by the player.
- `isGameOver`: Indicates whether the game is over.
- `correctWord`: Stores the correct word to be guessed.
- `currentGuess`: Stores the current guess as a `ColoredWord`.
- `hasPlayerWon`: Indicates whether the player has won the game.
___


## Word Dictionary
The `WordDictionary` class manages a set of words and a set of solution candidates loaded from files. It provides functionalities to check if a word exists in the dictionary and to retrieve a random solution candidate.

### Main functionalities
- Load words from specified files into sets.
- Check if a word exists in the dictionary.
- Retrieve a random word from the solution candidates.
___
### Methods
- `WordDictionary(String allWordsFilePath, String solutionsFilePath)`: Constructor that initializes the word sets by loading words from the given file paths.
- `boolean containsWord(String word)`: Checks if the specified word exists in the `wordSet`.
- `String getRandomSolution()`: Returns a random word from the `solutionCandidatesSet`.
___
### Fields
- `Set<String> wordSet`: A set containing all the words loaded from the specified file.
- `Set<String> solutionCandidatesSet`: A set containing solution candidate words loaded from the specified file.
___


## Word
The `Word` class represents a word consisting of exactly 5 characters. It provides functionalities to access individual characters, check for the presence of a character, and verify the position of a character within the word.

### Main functionalities
The main functionalities of the `Word` class include:
- Storing a word of exactly 5 characters.
- Accessing characters by their position.
- Checking if a character is present in the word.
- Verifying if a character is at a specific position.
___
### Methods
- `Word(String word)`: Constructor that initializes the word and checks if it is exactly 5 characters long.
- `char getCharFromPos(int pos)`: Returns the character at the specified position.
- `boolean containsLetter(char letter)`: Checks if the word contains the specified character.
- `boolean isLetterAtPosition(char letter, int pos)`: Checks if the specified character is at the given position.
- `String getString()`: Returns the word as a string.
___
### Fields
- `protected char[] charLetters`: An array of characters representing the word.
- `protected String string`: The word as a string.
___


## Colored Word 
The ColoredWord class extends the Word class and represents a word where each letter can have an associated color. It initializes a word with all letters colored gray and provides methods to change the color of individual letters and retrieve letters and their colors.

### Main functionalities
- Initialize a word with all letters colored gray.
- Change the color of a specific letter in the word.
- Retrieve a letter from a specific position.
- Retrieve the color of a letter from a specific position.
___
### Methods
- `ColoredWord(String word)`: Constructor that initializes the word with all letters colored gray.
- `void colorLetterAtPos(int pos, MyColor color)`: Changes the color of the letter at the specified position.
- `Letter getLetterFromPos(int pos)`: Returns the letter at the specified position.
- `MyColor getColorFromPos(int pos)`: Returns the color of the letter at the specified position.
___
### Fields
- `Letter[] letters`: An array of `Letter` objects representing the letters of the word, each with an associated color.
___


## Letter
The `Letter` class represents a character with an associated color. It provides methods to retrieve and modify the character and its color.

### Main functionalities
The main functionalities of the `Letter` class include storing a character and its color, and providing methods to access and modify these properties.
___
### Methods
- `getChar()`: Returns the character stored in the `Letter` object.
- `getColor()`: Returns the color associated with the character.
- `color(MyColor color)`: Sets a new color for the character.
___
### Fields
- `letter`: A private field that stores the character.
- `color`: A private field that stores the color associated with the character.
___


## User Interface
The `UserInterface` class serves as the intermediary between the user and the game logic. It handles user input, updates the game state, and communicates with the `Frame` class to update the graphical user interface accordingly.

### Main functionalities
- Initializes the game frame and sets up the user interface.
- Handles user input and validates the length of the guessed word.
- Communicates with the `Frame` class to display messages and update the GUI.
- Manages the game state by interacting with the `WordleGame` class.
___
### Methods
- `userPressedEnter(String typedWord)`: Validates the length of the guessed word and notifies the game logic.
- `notifyWordTooShort()`: Displays a message indicating the guessed word is too short.
- `notifyWordDoesNotExist()`: Displays a message indicating the guessed word does not exist.
- `getGuessFromUser()`: Waits for the user to input a guess and returns it.
- `nextRow()`: Moves to the next row in the guess grid.
- `printColoredGuess(ColoredWord coloredGuess)`: Updates the guess grid with colored feedback based on the guess.
- `handleWin(String correctWord)`: Handles the win scenario by blocking further input, displaying a win message, and initializing a new game.
- `handleLoss(String correctWord)`: Handles the loss scenario by blocking further input, displaying a loss message, and initializing a new game.
___
### Fields
- `frame`: An instance of the `Frame` class that represents the GUI.
- `lastGuess`: Stores the last guessed word by the user.
- `game`: An instance of the `WordleGame` class that contains the game logic.
___


## Frame
The `Frame` class extends `JFrame` and serves as the main window for a word-guessing game. It integrates various UI components such as the `GuessGrid`, messages for win/loss scenarios, and informational panels. The class handles user interactions through keyboard events and buttons, updating the UI accordingly.

### Main functionalities
- Display the main game grid (`GuessGrid`) for word guessing.
- Show messages for win and loss scenarios.
- Provide informational panels and handle user interactions.
- Manage keyboard inputs for letter insertion, deletion, and word submission.
___
### Methods
- `Frame(UserInterface ui)`: Constructor that initializes the frame and its components.
- `handleKeyPressed(KeyEvent e)`: Handles key press events for letter insertion, deletion, and word submission.
- `setUpWinMessage()`, `setUpLossMessage()`, `setUpTooShort()`, `setUpDoesntExist()`, `setUpInfoPanel()`, `setUpTitle()`: Set up various UI components.
- `showWinMessage(String correctWord)`, `showLossMessage(String correctWord)`: Display win/loss messages.
- `playAgainClicked()`: Reset the game for a new round.
- `infoButtonClicked()`, `closeInfoClicked()`: Handle informational panel visibility.
- `tooShortInfo()`, `doesNotExistInfo()`: Show temporary messages for invalid inputs.
- `cover()`: Adjust the layering of components.
- `blockKeyboard()`, `unblockKeyboard()`: Manage keyboard event listeners.
- `blockInfoButton()`: Disable the info button.
___
### Fields
- `GuessGrid guessGrid`: The main game grid for word guessing.
- `UserInterface ui`: Reference to the user interface logic.
- `JLabel winMessage`, `lossMessage`, `tooShort`, `doesntExist`, `title`: Various labels for messages and title.
- `JLayeredPane main`: Main layered pane to manage component layering.
- `int nextLayerNumber`: Counter for managing layer numbers.
- `JButton playAgainButton`, `infoButton`, `closeInfo`: Buttons for user interactions.
- `JPanel infoPanel`: Panel for displaying game information.
- `Font font`: Font used for various UI components.
- `KeyAdapter keyAdapter`: Adapter for handling keyboard events.
___


## Guess Grid
The `GuessGrid` class represents a grid of `GridCell` objects. It manages the insertion and deletion of letters, navigation between cells, and coloring of cells based on game logic.

### Main functionalities
- Initialize a grid of `GridCell` objects.
- Insert and delete letters in the grid.
- Retrieve the current word formed in the grid.
- Navigate between cells.
- Color cells based on game logic.
___
### Methods
- `GuessGrid()`: Constructor that initializes the grid and sets up the layout.
- `deleteLetter()`: Deletes the letter in the current cell and moves to the previous cell.
- `insertLetter(char letter)`: Inserts a letter into the current cell and moves to the next cell.
- `getWord()`: Retrieves the current word formed in the current row.
- `nextCell()`: Moves to the next cell in the current row.
- `prevCell()`: Moves to the previous cell in the current row.
- `nextRow()`: Moves to the next row and resets the column to the first cell.
- `colorCellInCurrentRow(int column, MyColor color)`: Colors a specific cell in the current row based on the provided color.
___
### Fields
- `GridCell[][] grid`: A 2D array representing the grid of cells.
- `int currentRow`: Tracks the current row in the grid.
- `int currentCol`: Tracks the current column in the grid.
___


## Grid Cell
The `GridCell` class extends `JLabel` to represent a cell in a guessGrid. It manages the display and state of a single character, including its color and whether it is empty.

### Main functionalities
The main functionalities of the `GridCell` class include setting and deleting a letter, checking if the cell is empty, and changing the cell's color based on predefined conditions.
___
### Methods
- `GridCell()`: Constructor that initializes the cell as empty with a white background and a gray border.
- `setLetter(char letter)`: Sets the letter in the cell, updates its display, and marks it as non-empty.
- `deleteLetter()`: Clears the letter from the cell and marks it as empty.
- `getLetter()`: Returns the current letter in the cell.
- `isEmpty()`: Checks if the cell is empty.
- `setColor(MyColor color)`: Changes the cell's background color based on the provided `MyColor` value.
___
### Fields
- `private char letter`: Stores the character displayed in the cell.
- `private boolean empty`: Indicates whether the cell is empty.
___


## Word Reader
The `WordReader` class provides a method to read words from a file and store them in a set, filtering only those words that are exactly five characters long.

### Main functionalities
The main functionality of the `WordReader` class is to read a file line by line, trim each line to remove leading and trailing spaces, and add the line to a set if it is exactly five characters long.
___
### Methods
- `loadWordsFromFile(String filePath)`: Reads a file from the given file path, processes each line to check if it is a 5-letter word, and returns a set of these words.
___
### Fields
The class does not have any fields. It only contains a static method.
___


