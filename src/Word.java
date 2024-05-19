public class Word {
    private Letter[] letters;

    // konstruktor tworzy szare slowo
    public Word(String word) {
        if (word.length() != 5){
            throw new IllegalArgumentException("word must be exactly 5 characters long");
        }

        char[] charLettersArr = word.toCharArray();
        letters = new Letter[5];

        for (int i = 0; i < 5; i++) {
            Letter letter = new Letter(charLettersArr[i], Color.GREY);
            this.letters[i] = letter;
        }
    }

    public boolean containsLetter (Letter letter) {
        for ( Letter l : this.letters ) {
            if (letter.getChar() == l.getChar()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLetterAtPosition (Letter letter, int pos) {
        Letter letterAtPos = this.letters[pos];
        return (letterAtPos.getChar() == letter.getChar());
    }

    public void colorLetterAtPos (int pos, Color color) {
        this.letters[pos].color(color);
    }

    public char getCharFromPos (int pos) {
        return letters[pos].getChar();
    }
}
