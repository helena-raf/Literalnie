public class Word {
    protected char[] charLetters;
    protected String string;

    public Word(String word) {
        if (word.length() != 5){
            throw new IllegalArgumentException("word must be exactly 5 characters long");
        }

        char[] charArr = word.toCharArray();
        this.charLetters = charArr;
        this.string = word;
    }

    public char getCharFromPos(int pos) {
        return charLetters[pos];
    }

    public boolean containsLetter(char letter) {
        for ( char l : this.charLetters ) {
            if (letter == l) {
                return true;
            }
        }
        return false;
    }

    public boolean isLetterAtPosition (char letter, int pos) {
        char letterAtPos = this.charLetters[pos];
        return (letterAtPos == letter);
    }

    public String getString() {
        return string;
    }


}
