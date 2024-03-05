class Solution {
    int[] rOffset = {0, 1, 0, -1};
    int[] cOffset = {1, 0, -1, 0};
    int n,m;
    class Cod {
        //cordinates class
        int x;
        int y;

        public Cod(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int getFood(char[][] grid) {
        Queue<Cod> q = new LinkedList<>();

        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '*') {
                    q.add(new Cod(i, j));
                    grid[i][j] = 'X';
                    break;
                }
            }
        }

        int step = 0;
        int ln = n;
        int lm = m;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Cod pos = q.poll();

                for(int dir = 0; dir < 4; dir++) {

                    int rNext = pos.x + rOffset[dir];
                    int cNext = pos.y + cOffset[dir];

                    if(isInbound(rNext, cNext) && grid[rNext][cNext] != 'X') {
                        if(grid[rNext][cNext] == '#') {
                            return step+1;
                        }
                        grid[rNext][cNext] = 'X';
                        q.offer(new Cod(rNext, cNext));
                    }
                }
            }
            step++;
        }

        return -1;

    }

    private boolean isInbound(int i, int j) {
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }
}
