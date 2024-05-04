import java.util.*;

public class ASTAR {
    public static AlgoResult aStarSearch(String startWord, String endWord, HashSet<String> dictionary) {
        long startTime = System.currentTimeMillis();

        PriorityQueue<Node> prioQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        HashMap<String, Integer> visitedCost = new HashMap<>();
        prioQueue.offer(new Node(startWord, null, 0 + SearchUtil.getHeuristicValue(startWord, endWord)));
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
                int gNew = visitedCost.get(current.word) + 1;
                int fNew = gNew + SearchUtil.getHeuristicValue(possibleWord, endWord);
                if (!visitedCost.containsKey(possibleWord) || gNew < visitedCost.get(possibleWord)) {
                    visitedCost.put(possibleWord, gNew);
                    prioQueue.offer(new Node(possibleWord, current, fNew));
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
