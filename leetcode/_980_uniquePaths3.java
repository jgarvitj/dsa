/*
backtracking
*/

class Solution {
    int rows, col;
    int[][] grid;
    int paths;
    int[] rowOffset = {0, 1, 0, -1};
    int[] colOffset = {1, 0, -1, 0};
    int nodesRemaining;
    public int uniquePathsIII(int[][] grid) {

        nodesRemaining = 0;
        this.paths = 0;
        this.rows = grid.length;
        this.col = grid[0].length;
        int startRow = 0;
        int startCol = 0;
        this.grid = grid;

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.col; j++) {
                if(grid[i][j] >= 0) {
                    nodesRemaining++;
                }
                if(grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } 
            }
        }

        backtrack(startRow, startCol);
        return this.paths;

        
    }

    private void backtrack(int rCurr, int cCurr) {
        if(this.grid[rCurr][cCurr] == 2 && nodesRemaining == 1) {
            this.paths += 1;
            return;
        }
        
        nodesRemaining -= 1;
        int val = grid[rCurr][cCurr];
        grid[rCurr][cCurr] = -2;

        
        
        for(int i = 0; i < 4; i++) {
            int nextRow = rCurr + rowOffset[i];
            int nextCol = cCurr + colOffset[i];
            if(nextRow < 0 || nextCol < 0 || nextRow == this.rows || nextCol == this.col || grid[nextRow][nextCol] < 0) {
                continue;
            }
            
            backtrack(nextRow, nextCol);
        }
        grid[rCurr][cCurr] = val;
        nodesRemaining += 1;
    }
}
