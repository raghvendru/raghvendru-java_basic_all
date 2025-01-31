package AdvancedRecursion;
import java.util.ArrayList;
import java.util.List;
public class NQueen {
        // Check if it's safe to place a queen at board[row][col]
        public boolean safe(List<String> board, int row, int col) {
            int r = row, c = col;
            while (r >= 0 && c >= 0) {
                if (board.get(r).charAt(c) == 'Q') return false;
                r--;
                c--;
            }
            r = row;
            c = col;
            // Check left side
            while (c >= 0) {
                if (board.get(r).charAt(c) == 'Q') return false;
                c--;
            }
            // Reset to the original position
            r = row;
            c = col;
            // Check lower left diagonal
            while (r < board.size() && c >= 0) {
                if (board.get(r).charAt(c) == 'Q') return false;
                r++;
                c--;
            }
            return true;
        }
        public void func(int col, List<List<String>> ans, List<String> board) {
            if (col == board.size()) {
                ans.add(new ArrayList<>(board));
                return;
            }
            for (int row = 0; row < board.size(); row++) {
                if (safe(board, row, col)) {
                    char[] charArray = board.get(row).toCharArray();
                    charArray[col] = 'Q';
                    board.set(row, new String(charArray));
                    func(col + 1, ans, board);
                    charArray[col] = '.';
                    board.set(row, new String(charArray));
                }
            }
        }
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            List<String> board = new ArrayList<>();
            String s = ".".repeat(n);
            for (int i = 0; i < n; i++) {
                board.add(s);
            }
            func(0, ans, board);
            return ans;
        }
        public static void main(String[] args) {
            NQueen solution = new NQueen();
            int n = 4; // Example with 4 queens
            List<List<String>> solutions = solution.solveNQueens(n);
            for (List<String> sol : solutions) {
                for (String row : sol) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
    }


