package GRAPHS;
import java.util.*;
public class WordLadder2 {
    private void dfs(String word, String beginWord, List<String> seq,
                     Map<String, Integer> mpp, List<List<String>> ans) {
        if (word.equals(beginWord)) {
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }
        int val = mpp.get(word);
        for (int i = 0; i < word.length(); i++) {
            char original = word.charAt(i);
            StringBuilder sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i, ch);
                String newWord = sb.toString();
                if (mpp.containsKey(newWord) &&
                        mpp.get(newWord) + 1 == val) {
                    seq.add(newWord);
                    dfs(newWord, beginWord, seq, mpp, ans);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Set<String> st = new HashSet<>(wordList);
        Map<String, Integer> mpp = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        st.remove(beginWord);
        int steps = 1;
        mpp.put(beginWord, steps);
        while (!q.isEmpty()) {
            String word = q.poll();
            steps = mpp.get(word);
            for (int i = 0; i < len; i++) {
                char original = word.charAt(i);
                StringBuilder sb = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if (st.contains(newWord)) {
                        mpp.put(newWord, steps + 1);
                        q.add(newWord);
                        st.remove(newWord);
                    }
                }
            }
        }
        if (!mpp.containsKey(endWord))
            return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        List<String> seq = new ArrayList<>();
        seq.add(endWord);
        dfs(endWord, beginWord, seq, mpp, ans);
        return ans;
    }
    public static void main(String[] args) {
        String beginWord = "der", endWord = "dfs";
        List<String> wordList = Arrays.asList(
                "des", "der", "dfr", "dgt", "dfs"
        );
        WordLadder2 sol = new WordLadder2();
        List<List<String>> ans =
                sol.findSequences(beginWord, endWord, wordList);
        System.out.println("The different sequences are:");
        for (List<String> seq : ans) {
            for (String word : seq) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
