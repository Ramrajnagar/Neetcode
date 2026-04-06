class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq= new int[26];
        int left=0;
        int maxfreq=0;
        int result=0;

        for(int right=0; right<s.length(); right++){
            char currentchar=s.charAt(right);
            freq[currentchar-'A']++;
            maxfreq= Math.max(maxfreq,freq[currentchar - 'A']);
            while((right-left+1)-maxfreq>k){
                freq[s.charAt(left) - 'A']--;
                left++;

            }
            result= Math.max(result, right-left+1);


        }
        return result;
        
    }
}
