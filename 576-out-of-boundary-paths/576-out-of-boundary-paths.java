class Solution {
    
    private long MOD = 1_000_000_007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return maxMoves(startRow, startColumn, maxMove, m, n, new HashMap<>());
    }
    
    private int maxMoves(int i, int j, int moves, int m, int n, Map<String, Integer> map) {
        if(i < 0 
            || i >= m
            || j < 0
            || j >= n) return 1;
        
        if(moves == 0) return 0;
        
        String key = String.format("%d-%d-%d", i, j, moves);
        
        if(map.containsKey(key)) return map.get(key);
        
        long sum = maxMoves(i + 1, j, moves - 1, m, n, map) % MOD;
            sum += maxMoves(i - 1, j, moves - 1, m, n, map) % MOD;
            sum += maxMoves(i, j + 1, moves - 1, m, n, map) % MOD;
            sum += maxMoves(i, j - 1, moves - 1, m, n, map) % MOD;
        
        map.put(key, (int) (sum % MOD));
        
        return map.get(key);
    }
}