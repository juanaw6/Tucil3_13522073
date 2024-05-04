import java.util.*;

public class UCS {
    public static AlgoResult uniformCostSearch(String startWord, String endWord, HashSet<String> dictionary) {
        
        // NOTE: For calculating memory usage
        Runtime runtime = Runtime.getRuntime();
        long beforeMemory, afterMemory, usedMemory;
        runtime.gc();
        beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        //
        
        long startTime = System.currentTimeMillis();

        PriorityQueue<Node> prioQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        HashMap<String, Integer> visitedCost = new HashMap<>();
        prioQueue.offer(new Node(startWord, null, 0));
        visitedCost.put(startWord, 0);

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
                int newCost = current.value + 1;
                if (!visitedCost.containsKey(possibleWord) || newCost < visitedCost.get(possibleWord)) {
                    visitedCost.put(possibleWord, newCost);
                    prioQueue.offer(new Node(possibleWord, current, newCost));
                }
            }
        }

        // NOTE: For calculating memory usage
        runtime.gc();
        afterMemory = runtime.totalMemory() - runtime.freeMemory();
        usedMemory = afterMemory - beforeMemory;
        System.out.println("[UCS] Start: " + startWord.toUpperCase());
        System.out.println("[UCS] End  : " + endWord.toUpperCase());
        System.out.println("[UCS] used memory (bytes): " + usedMemory);
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
