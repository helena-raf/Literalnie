import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class WordReader {

    public static Set<String> loadWordsFromFile (String filePath) {
        Set<String> wordSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                if (word.length() == 5) {
                    wordSet.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordSet;
    }
}
