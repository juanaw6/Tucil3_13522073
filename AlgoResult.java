import java.util.ArrayList;

public class AlgoResult {
    private ArrayList<String> path;
    private int executionTime;
    private int nodeVisited;

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getNodeVisited() {
        return nodeVisited;
    }

    public void setNodeVisited(int nodeVisited) {
        this.nodeVisited = nodeVisited;
    }
}
