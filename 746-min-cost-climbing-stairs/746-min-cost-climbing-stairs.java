class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n+1];
        
        //dp[i] i to des jane ki min cost
        
        dp[n] =0;
        
        for(int i=n-1; i>=0; i--){
            
            if(i == n-1){
                dp[i] = cost[i];
            }
            
            else{
                int min = Math.min(dp[i+1],dp[i+2]);
                dp[i] = min + cost[i];
            }
        }
        
        return Math.min(dp[0],dp[1]);
        
        
    }
}