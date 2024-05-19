public class ColoredWord extends Word {
    private Letter[] letters;

    // konstruktor tworzy szare slowo
    public ColoredWord(String word) {
        super(word);

        this.letters = new Letter[5];

        for (int i = 0; i < 5; i++) {
            Letter letter = new Letter(charLetters[i], Color.GREY);
            this.letters[i] = letter;
        }
    }

    public void colorLetterAtPos (int pos, Color color) {
        this.letters[pos].color(color);
    }

}
