import java.util.*;

public class Main {
    public static void main(String[] args) {
        Utils.printWelcome();

        HashSet<String> words = Utils.initializeWordsHashSet("words_alpha.txt");
        HashSet<String> types = Utils.initializeTypesHashSet();
        Scanner scanner = new Scanner(System.in);

        String startWord = Utils.promptForStartWord(words, scanner);
        String endWord = Utils.promptForEndWord(words, startWord.length(), scanner);
        String searchType = Utils.promptForType(types, scanner);

        System.out.printf("[DEBUG]  start: %s\n", startWord);
        System.out.printf("[DEBUG]  end  : %s\n", endWord);
        System.out.printf("[DEBUG]  type : %s\n", searchType);

        AlgoResult searchResult = Algorithm.search(startWord, endWord, searchType, words);

        Utils.printResult(searchResult);

        scanner.close();
    }
}