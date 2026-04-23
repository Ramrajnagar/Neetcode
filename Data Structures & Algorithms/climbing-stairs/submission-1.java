class Solution {
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        return f_recursion(n,0,dp);

        
    }
    public int f_recursion(int n, int i, int[] dp){
        if(i>n) {return 0;}
        if(i==n){ return 1;}
        if(dp[i]>0){ return dp[i];}
        dp[i]=f_recursion(n,i+1,dp)+ f_recursion(n,i+2,dp);
        return dp[i];
    }
}
