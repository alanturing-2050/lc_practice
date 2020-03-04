class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                   for(char c = '1'; c <= '9'; c++) {
                       if(isValid(board, i, j, c)) {
                           board[i][j] = c;
                           if(backtracking(board)) return true;
                           else board[i][j] = '.';
                       }
                   }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char c) {
        for(int k = 0; k < 9; k++) {
            if((board[i][k] != '.' && board[i][k] == c) || (board[k][j] != '.' && board[k][j] == c) || (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] != '.' && board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c))return false;
        }
        return true;
    }
}

/**
Problem: https://leetcode.com/problems/sudoku-solver/
Analysis: very typical backtracking problem
once board[i][j] == '.' fill it with 1 ~ 9 and check if current status is valid, then replace it with current, if 1 - 9 filled then return to last status
valid method for suduku => board[3*(i / 3) + k / 3][3*(j / 3) + k % 3]
TimeComplexity: O(9!)^9
SpaceComplexity:O(81)
tag: #backtracking
**/
