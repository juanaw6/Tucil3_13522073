import java.util.*;

public class GBFS {
    public static AlgoResult greedyBestFirstSearch(String startWord, String endWord, HashSet<String> dictionary) {
        long startTime = System.currentTimeMillis();

        PriorityQueue<Node> prioQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        HashSet<String> visited = new HashSet<>();
        prioQueue.offer(new Node(startWord, null, SearchUtil.getHeuristicValue(startWord, endWord)));

        Node finalNode = null;
        int nodesVisited = 0;

        while (!prioQueue.isEmpty()) {
            Node current = prioQueue.poll();
            nodesVisited++;

            if (current.word.equals(endWord)) {
                finalNode = current;
                break;
            }

            if (!visited.contains(current.word)) {
                visited.add(current.word);
                for (String possibleWord : SearchUtil.getPossibleWords(current.word, dictionary)) {
                    if (!visited.contains(possibleWord)) {
                        prioQueue.offer(new Node(possibleWord, current, SearchUtil.getHeuristicValue(possibleWord, endWord)));
                    }
                }
            }
        }

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
