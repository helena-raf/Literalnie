import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WordDictionary {
    private Set<String> wordSet;
    private Set<String> solutionCandidatesSet;

    public WordDictionary (String allWordsFilePath, String solutionsFilePath) {
        this.wordSet = WordReader.loadWordsFromFile(allWordsFilePath);
        this.solutionCandidatesSet = WordReader.loadWordsFromFile(solutionsFilePath);
    }
 
    public boolean containsWord (String word) {
        return wordSet.contains(word);
    }

    public String getRandomSolution() {
        List<String> wordList = new ArrayList<>(solutionCandidatesSet);
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
}
