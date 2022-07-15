class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length - 1, n = grid[0].length - 1;
        int maxIslandArea = 0;
        for(int i=0 ;i<=m ;i++) {
            for(int j=0 ;j<=n ;j++) {
                if(grid[i][j] == 1) {
                    maxIslandArea = Math.max(maxIslandArea, countIslandArea(m, n, i, j, grid));
                }
            }
        }
        return maxIslandArea;
    }
    private int countIslandArea(int m, int n, int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row > m || col > n)
            return 0;
        if(grid[row][col] != 1)
            return 0;
         grid[row][col] = -1;
         return 1 + countIslandArea(m, n, row - 1, col, grid) + countIslandArea(m, n, row, col - 1, grid) + countIslandArea(m, n, row + 1, col, grid) + countIslandArea(m, n, row, col + 1, grid);
    }
}