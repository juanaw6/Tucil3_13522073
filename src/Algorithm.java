import java.util.HashSet;

public class Algorithm {
    public static AlgoResult search(String startWord, String endWord, String algorithm, HashSet<String> dictionary) {
        if ("UCS".equals(algorithm)) {
            return UCS.uniformCostSearch(startWord, endWord, dictionary);
        } else if ("GBFS".equals(algorithm)) {
            return GBFS.greedyBestFirstSearch(startWord, endWord, dictionary);
        } else {
            return ASTAR.aStarSearch(startWord, endWord, dictionary);
        }
    }
}
