import java.util.*;

public class GBFS {
    public static AlgoResult greedyBestFirstSearch(String startWord, String endWord, HashSet<String> dictionary) {

        // NOTE: For calculating memory usage
        Runtime runtime = Runtime.getRuntime();
        long beforeMemory, afterMemory, usedMemory;
        runtime.gc();
        beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        //

        long startTime = System.currentTimeMillis();

        PriorityQueue<Node> prioQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        HashSet<String> queued = new HashSet<>();
        prioQueue.offer(new Node(startWord, null, SearchUtil.getHeuristicValue(startWord, endWord)));
        queued.add(startWord);

        Node finalNode = null;
        int nodesVisited = 0;

        while (!prioQueue.isEmpty()) {
            Node current = prioQueue.poll();
            nodesVisited++;

            if (current.word.equals(endWord)) {
                finalNode = current;
                break;
            }

            for (String possibleWord : SearchUtil.getPossibleWords(current.word, dictionary)) {
                if (!queued.contains(possibleWord)) {
                    queued.add(possibleWord);
                    prioQueue.offer(new Node(possibleWord, current, SearchUtil.getHeuristicValue(possibleWord, endWord)));
                }
            }
        }


        // NOTE: For calculating memory usage
        runtime.gc();
        afterMemory = runtime.totalMemory() - runtime.freeMemory();
        usedMemory = afterMemory - beforeMemory;
        System.out.println("[GBFS] Start: " + startWord.toUpperCase());
        System.out.println("[GBFS] End  : " + endWord.toUpperCase());
        System.out.println("[GBFS] used memory (bytes): " + usedMemory);
        //

        long endTime = System.currentTimeMillis();
        AlgoResult result = new AlgoResult();
        if (finalNode != null) {
            ArrayList<String> path = new ArrayList<>();
            for (Node n = finalNode; n != null; n = n.parent) {
                path.add(n.word);
            }
            Collections.reverse(path);
            result.setPath(path);
        } else {
            ArrayList<String> path = new ArrayList<>();
            if (startWord == endWord) {
                path.add(startWord);
            } else {
                path.add("No path found");
            }
            result.setPath(path);
        }
        result.setNodeVisited(nodesVisited);
        result.setExecutionTime((int) (endTime - startTime));

        return result;
    }
}
