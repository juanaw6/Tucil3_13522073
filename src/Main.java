import java.util.*;

public class Main {
    public static void main(String[] args) {

        // GUI Main
        HashSet<String> dictionary = Utils.initializeWordsHashSet("_dictionary_javase.txt");
        SolverGUI.run(dictionary);

        // // CLI Main

        // Utils.printWelcome();

        // HashSet<String> words = Utils.initializeWordsHashSet("_dictionary_javase.txt");
        // HashSet<String> types = Utils.initializeTypesHashSet();
        // Scanner scanner = new Scanner(System.in);

        // String startWord = Utils.promptForStartWord(words, scanner);
        // String endWord = Utils.promptForEndWord(words, startWord.length(), scanner);
        // String searchType = Utils.promptForType(types, scanner);

        // System.out.printf("[DEBUG]  start: %s\n", startWord);
        // System.out.printf("[DEBUG]  end  : %s\n", endWord);
        // System.out.printf("[DEBUG]  type : %s\n", searchType);

        // AlgoResult searchResult = Algorithm.search(startWord, endWord, searchType, words);

        // Utils.printResult(searchResult);
        // System.out.println("Path Length: " + searchResult.getPath().size());

        // scanner.close();
    }
}