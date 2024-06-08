import java.util.Set;

public class WordDictionary {
    private Set<String> wordSet;

    public WordDictionary (String filePath) {
        this.wordSet = WordReader.loadWordsFromFile(filePath);
    }
 
    public boolean containsWord (String word) {
        return wordSet.contains(word);
    }
}
