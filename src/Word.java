public class Word {
    private char[] letters;

    public Word(String word) {
        if (word.length() != 5){
            throw new IllegalArgumentException("word must be exactly 5 characters long");
        }

        char[] charArr = word.toCharArray();
        letters = charArr;
    }

    public char getCharFromPos(int pos) {
        return letters[pos];
    }

    public boolean containsLetter(char letter) {
        for ( char l : this.letters ) {
            if (letter == l) {
                return true;
            }
        }
        return false;
    }
}
