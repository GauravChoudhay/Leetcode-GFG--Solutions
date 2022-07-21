class Solution {
    public int subarraySum(int[] nums, int k) {
        
        //optimize approach
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        freq.put(0,1);
        
        int ssf = 0;
        int count = 0;
        
        for(int i =0;i<nums.length;i++){
            
            ssf+=nums[i];
            
            count += freq.getOrDefault((ssf-k),0);
            
            freq.put(ssf,freq.getOrDefault((ssf),0)+1);
        }
        
        return count;
    }
}