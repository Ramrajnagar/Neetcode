class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        Backtrack(0, nums,subset, result);
            return result;
        
    }    
    private void Backtrack(int i , int[] nums,List<Integer> subset, List<List<Integer>>result){
            if(i==nums.length){
                result.add(new ArrayList(subset));
                return;
            }

            subset.add(nums[i]);
            Backtrack(i+1, nums, subset, result);


            subset.remove(subset.size()-1);
            Backtrack(i+1,nums,subset,result);

        }    
        
        
        

    



        
        
    
}
