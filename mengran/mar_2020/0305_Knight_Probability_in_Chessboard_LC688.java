class Solution {
    private static int[][] dirs = new int[][]{{1, 2}, {1, -2}, {2, 1}, {-2, 1}, {-1, 2}, {-1, -2}, {-2, -1}, {2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        // we can use DP to solve this problem
        double[][] dp = new double[N][N];
        dp[r][c] = 1.0;
        for(int k = 1; k <=K; k++) {
            double[][] next = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int[] dir : dirs) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            next[nr][nc] += dp[i][j] / 8;
                        }
                    }
                }
            }
            dp = next;
        }
        double res = 0.0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
}


/**
Problem: https://leetcode.com/problems/knight-probability-in-chessboard/
Analysis:
we can use dp table to record the current status
dp[i][j] += lastDp[i - dir][j - dir] / 8;
TimeComplexity: O(K*N^2)
SpaceComplexity: O(N^2)
tag: #DP
**/
