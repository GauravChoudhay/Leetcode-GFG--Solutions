class Solution 
{
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) 
    {
        int ind = 1;
        Map<String, Integer> hmp = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                String key = i+"_"+j;
                hmp.put(key, ind++);
            }
        }
        DSU dsu = new DSU(2502);
        boolean valid = false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    valid = true;
                    for(int r=0;r<4;r++)
                    {
                        int x = i + dx[r];
                        int y = j + dy[r];
                        if(isSafe(x, y, m, n) && grid[x][y] == 1)
                        {
                            String key1 = i+"_"+j;
                            String key2 = x+"_"+y;
                            dsu.union(hmp.get(key1), hmp.get(key2));
                        }
                    }
                }
            }
        }
        
        if(!valid)
            return 0;
        int res = 0;
        for(Integer x: dsu.groupSize)
            res = Math.max(res, x);
        return res;
    }
    
    public boolean isSafe(int x, int y, int m, int n)
    {
        return (x>=0 && x<m && y>=0 && y<n);
    }
    
    class DSU
    {
        int n;
        int[] parent, ranks, groupSize;
        DSU(int n)
        {
            this.n = n;
            parent = new int[n];
            ranks = new int[n];
            groupSize = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                ranks[i] = 1;
                groupSize[i] = 1;
            }
        }
        
        public int find(int n)
        {
            if(parent[n] == n)
                return n;
            
            return parent[n] = find(parent[n]);
        }
        
        public void union(int x, int y)
        {
            int x_rep = find(x);
            int y_rep = find(y);
            
            if(x_rep == y_rep)
                return ;
            
            if(ranks[x_rep] < ranks[y_rep])
            {
                parent[x_rep] = y_rep;
                groupSize[y_rep] += groupSize[x_rep];
            }
            else if(ranks[x_rep] > ranks[y_rep])
            {
                parent[y_rep] = x_rep;
                groupSize[x_rep] += groupSize[y_rep];
            }
            else
            {
                parent[y_rep] = x_rep;
                groupSize[x_rep] += groupSize[y_rep];
                ranks[x_rep]++;
            }
        }
    }
}