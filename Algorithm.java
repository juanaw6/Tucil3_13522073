import java.util.ArrayList;
import java.util.HashSet;

public class Algorithm {
    public static AlgoResult search(String startWord, String endWord, String algorithm, HashSet<String> dictionary) {
        if ("UCS".equals(algorithm)) {
            return UCS(startWord, endWord, dictionary);
        } else if ("GBFS".equals(algorithm)) {
            return GBFS(startWord, endWord, dictionary);
        } else {
            return ASTAR(startWord, endWord, dictionary);
        }
    }

    public static AlgoResult UCS(String startWord, String endWord, HashSet<String> dictionary) {
        AlgoResult result = new AlgoResult();
        ArrayList<String> path = new ArrayList<>();
        path.add(startWord);
        int visit = 1;
        long startTime = System.currentTimeMillis();



        long endTime = System.currentTimeMillis();
        result.setExecutionTime((int) (startTime - endTime));
        result.setPath(path);
        result.setNodeVisited(visit);
        return result;
    }

    public static AlgoResult GBFS(String startWord, String endWord, HashSet<String> dictionary) {
        AlgoResult result = new AlgoResult();
        ArrayList<String> path = new ArrayList<>();
        path.add(startWord);
        int visit = 1;
        long startTime = System.currentTimeMillis();



        long endTime = System.currentTimeMillis();
        result.setExecutionTime((int) (startTime - endTime));
        result.setPath(path);
        result.setNodeVisited(visit);
        return result;
    }

    public static AlgoResult ASTAR(String startWord, String endWord, HashSet<String> dictionary) {
        AlgoResult result = new AlgoResult();
        ArrayList<String> path = new ArrayList<>();
        path.add(startWord);
        int visit = 1;
        long startTime = System.currentTimeMillis();



        long endTime = System.currentTimeMillis();
        result.setExecutionTime((int) (startTime - endTime));
        result.setPath(path);
        result.setNodeVisited(visit);
        return result;
    }
}
