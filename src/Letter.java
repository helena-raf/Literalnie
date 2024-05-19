public class Letter {
    private char letter;
    private Color color;

    public Letter(char letter, Color color) {
        this.letter = letter;
        this.color = color;
    }

    public char getChar() {
        return this.letter;
    }

    public void color(Color color) {
        this.color = color;
    }
}
