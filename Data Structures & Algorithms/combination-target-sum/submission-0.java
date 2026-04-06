class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result= new ArrayList<>();
        List<Integer>subset= new ArrayList<>();

        backCombination(0,nums,target,result,subset);
        return result;
        
    } 
    private void backCombination(int i, int[] nums,int target,List<List<Integer>>result,List<Integer>subset){
        if(target==0){
            result.add(new ArrayList(subset));
            return;
        }
        if(target<0|| i==nums.length){
            return;
        }
        subset.add(nums[i]);
        backCombination(i,nums,target-nums[i],result,subset);
        subset.remove(subset.size()-1);
        backCombination(i+1,nums,target,result,subset);

                
    }
}
