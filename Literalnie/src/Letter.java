public class Letter {
    private char letter;
    private MyColor color;

    public Letter(char letter, MyColor color) {
        this.letter = letter;
        this.color = color;
    }

    public char getChar() {
        return this.letter;
    }

    public MyColor getColor() {
        return this.color;
    }

    public void color(MyColor color) {
        this.color = color;
    }
}
