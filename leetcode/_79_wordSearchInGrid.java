/*
 * back tracking
 */

class Solution {

    private char[][] grid;
    private int rSize;
    private int cSize;

    public boolean exist(char[][] board, String word) {

        this.rSize = board.length;
        this.cSize = board[0].length;
        this.grid = board;
        for(int i = 0; i <  rSize; i++) {
            for(int j = 0; j < cSize; j++) {
                if(backtrack(0, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int index, String word, int rows, int col) {
        if(index == word.length()) {
            return true;
        }

        if(rows < 0 || rows == rSize || col < 0 || col == cSize) {
            return false;
        }

        char c = this.grid[rows][col];

        if(word.charAt(index) != c) {
            return false;
        }

        char sub = '#';

        int[] rOffset = {0, 1, 0, -1};
        int[] cOffset = {1, 0, -1, 0};
        int directions = rOffset.length;

        this.grid[rows][col]  = sub;

        for(int dir = 0; dir < directions; dir++) {
            if(backtrack(index + 1, word, rows + rOffset[dir], col + cOffset[dir])) {
                return true;
            }
        }
        this.grid[rows][col] = c;
        return false;
    }
}
