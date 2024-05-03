import java.io.*;
import java.util.*;

public class Utils {
    public static HashSet<String> initializeWordsHashSet(String filename) {
        HashSet<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    // CLI Utils

    // public static void printWelcome() {
    //     System.out.println("[SOLVER] Welcome to Word Ladder Solver!");
    //     System.out.println("[GUIDES] How to use:");
    //     System.out.println("1. Input your start word and end word (same length).");
    //     System.out.println("2. Choose search type:");
    //     System.out.println("   - UCS   (Uniform Cost Search)");
    //     System.out.println("   - GBFS  (Greedy Best First Search)");
    //     System.out.println("   - ASTAR (A* Search)");
    //     System.out.println();
    // }

    // public static HashSet<String> initializeTypesHashSet() {
    //     HashSet<String> types = new HashSet<>();
    //     types.add("UCS");
    //     types.add("GBFS");
    //     types.add("ASTAR");
    //     return types;
    // }

    // public static String promptForStartWord(HashSet<String> words, Scanner scanner) {
    //     while (true) {
    //         System.out.print("Start word: ");
    //         String word = scanner.nextLine().trim().toLowerCase();
    //         if (words.contains(word)) {
    //             return word;
    //         }
    //         System.out.println("[ERROR] Invalid word!");
    //     }
    // }

    // public static String promptForEndWord(HashSet<String> words, int length, Scanner scanner) {
    //     while (true) {
    //         System.out.print("End word: ");
    //         String word = scanner.nextLine().trim().toLowerCase();
    //         if (words.contains(word)) {
    //             if (word.length() == length) {
    //                 return word;
    //             }
    //             System.out.printf("[ERROR] End word's length must be %d characters!\n", length);
    //             continue;
    //         }
    //         System.out.println("[ERROR] Invalid word!");
    //     }
    // }

    // public static String promptForType(HashSet<String> types, Scanner scanner) {
    //     while (true) {
    //         System.out.print("Search type: ");
    //         String type = scanner.nextLine().trim().toUpperCase();
    //         if (types.contains(type)) {
    //             return type;
    //         }
    //         System.out.println("[ERROR] Search Type can only be UCS, BDFS, ASTAR!");
    //     }
    // }

    // public static void printResult(AlgoResult result) {
    //     System.out.printf("Execution Time: %d ms\n", result.getExecutionTime());
    //     System.out.printf("Total Words Checked: %d\n", result.getNodeVisited());
    //     System.out.println("Paths:");
    //     for (String word : result.getPath()) {
    //         System.out.println(word);
    //     }
    // }
}