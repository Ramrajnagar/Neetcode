class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){return 0;
        }
        //removing duplicate i used the Set
        Set<Integer> NumberSet= new HashSet<>();
        for (int num:nums){
            NumberSet.add(num);
        }
        int longestlen=0;
        for(int num :NumberSet){
            if (!NumberSet.contains(num-1)){
                int currentnum=num;
                int currentlen=1;
                while(NumberSet.contains(currentnum+1)){
                    currentnum++;
                    currentlen++;
                }
                longestlen=Math.max(longestlen,currentlen);

            }
            

        }
        return longestlen;

        
        
    }
}
