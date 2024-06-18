public class ColoredWord extends Word {
    private Letter[] letters;

    // konstruktor tworzy szare slowo
    public ColoredWord(String word) {
        super(word);

        this.letters = new Letter[5];

        for (int i = 0; i < 5; i++) {
            Letter letter = new Letter(charLetters[i], MyColor.GRAY);
            this.letters[i] = letter;
        }
    }

    public void colorLetterAtPos (int pos, MyColor color) {
        this.letters[pos].color(color);
    }

    public Letter getLetterFromPos (int pos) {
        return letters[pos];
    }

    public MyColor getColorFromPos (int pos) {
        return letters[pos].getColor();
    }
}
