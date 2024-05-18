public class Word {
    private Letter[] letters;

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
}
