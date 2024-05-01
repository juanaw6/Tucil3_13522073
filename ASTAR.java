import java.util.ArrayList;
import java.util.HashSet;

public class ASTAR {
    public static AlgoResult aStarSearch(String startWord, String endWord, HashSet<String> dictionary) {
        long startTime = System.currentTimeMillis();



        long endTime = System.currentTimeMillis();
        AlgoResult result = new AlgoResult();
        result.setExecutionTime((int) (startTime - endTime));
        return result;
    }
}
