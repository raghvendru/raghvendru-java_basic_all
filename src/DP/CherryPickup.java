package DP;
public class CherryPickup {
    int func(int n, int m, int[][] matrix) {
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = matrix[n - 1][j1];
                else
                    front[j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += -1e9;
                            else
                                ans += front[j1 + di][j2 + dj];
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    front[j1][j2] = cur[j1][j2];}
            }
        }
        return front[0][m - 1];
    }
    int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        return func(n, m, matrix);
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        CherryPickup sol = new CherryPickup();
        System.out.println(sol.cherryPickup(matrix));
    }
}

