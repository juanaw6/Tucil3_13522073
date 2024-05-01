import java.util.ArrayList;
import java.util.HashSet;

class Node {
    String word;
    Node parent;
    int value;

    Node(String word, Node parent, int value) {
        this.word = word;
        this.parent = parent;
        this.value = value;
    }
}

public class SearchUtil {
    public static ArrayList<String> getPossibleWords(String word, HashSet<String> dictionary) {
        ArrayList<String> possibleWordList = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    chars[i] = c;
                    String temp = new String(chars);
                    if (dictionary.contains(temp)) {
                     possibleWordList.add(temp);
                    }
                }
            }
            chars[i] = originalChar;
        }
        return possibleWordList;
    }

    public static int getHeuristicValue(String word, String goal) {
        int mismatch = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != goal.charAt(i)) {
                mismatch++;
            }
        }
        return mismatch;
    }
}
