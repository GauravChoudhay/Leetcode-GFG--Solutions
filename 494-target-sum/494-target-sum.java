class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return findTargetSumWaysHelper(0,nums,target);
        
    }
    
    public int findTargetSumWaysHelper(int idx,int[] nums,int target){
        
        if(idx==nums.length-1){
            int count = 0;
            if(target-nums[idx]==0){
                count++;
            }
            if(target+nums[idx]==0){
                count++;
            }
            return count;
        }
        
        //as positive value
        int posCount = findTargetSumWaysHelper(idx+1,nums,target-nums[idx]);
        
        //as negative value
        int negCount = findTargetSumWaysHelper(idx+1,nums,target+nums[idx]);
        
        return posCount + negCount;
    }
}