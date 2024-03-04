class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if(obstacleGrid[row-1][col-1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[row - 1][col - 1] = -1;

        int[] rDir = {0, 1};
        int[] cDir = {1, 0};

        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) {
                        continue;
                }
                
                for(int dir = 0; dir < 2; dir++) {
                    
                    if(i + rDir[dir] >= row || j + cDir[dir] >= col || obstacleGrid[i + rDir[dir]][j + cDir[dir]] == 1) {
                        continue;
                    }
                    obstacleGrid[i][j] += obstacleGrid[i + rDir[dir]][j + cDir[dir]]; 
                }
            }
        }
        return -1 * obstacleGrid[0][0];
    }
}
