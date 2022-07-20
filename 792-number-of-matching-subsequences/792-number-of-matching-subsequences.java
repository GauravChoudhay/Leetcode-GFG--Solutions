class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.computeIfAbsent(s.charAt(i),v->new ArrayList<Integer>()).add(i);
        }
        int count=0;
        for(String word:words){
            if(isSubsequence(word,(map))){
                count++;
            }
        }
        
        return count;
        
    }
    
    public boolean isSubsequence(String s, HashMap<Character,ArrayList<Integer>> map){
        int last = -1;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                int temp = last;
               for(int n:map.get(curr)){
                    if(last<n){
                        last = n;
                        break;
                    }
               }
                if(temp==last)return false;
            }else{
                return false;
            }
        }
        return true;
    }
}