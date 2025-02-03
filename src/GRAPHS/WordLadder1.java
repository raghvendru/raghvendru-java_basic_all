package GRAPHS;
import java.util.*;
public class WordLadder1 {
    public int wordLadderLength(String startWord,
                                String targetWord,
                                List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(startWord);
        while (!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if (word.equals(targetWord))
                return steps;

            // Iterate on every character
            for (int i = 0; i < word.length(); i++) {
                char original = word.charAt(i);

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
                word = word.substring(0, i) + original +
                        word.substring(i + 1);
            }
        }
        return 0;
    }
    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        List<String> wordList =
                Arrays.asList("des", "der", "dfr", "dgt", "dfs");
        WordLadder1 sol = new WordLadder1();
        int ans =
                sol.wordLadderLength(startWord, targetWord, wordList);
        System.out.println("Word ladder length is: " + ans);
    }
}

