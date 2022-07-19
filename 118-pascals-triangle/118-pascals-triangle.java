class Solution {
    public List<List<Integer>> generate(int numRows) {
        int i,j;
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        for(i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<Integer>();
            for(j=0;j<=i;j++){
                if(j==0 || j==i){
                    // If first or last element of the row then add '1'.
                    row.add(1);
                }
                else{
                    // Add previous row's 2 elements at j-1 and j index.
                    row.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}