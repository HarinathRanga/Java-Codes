import java.util.*;
class DynamicProgramming{
    public static int countWays(int n,int dp[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=countWays(n-1,dp)+countWays(n-2,dp);
    }
    public static void main(String[] args) {
        int dp[]=new int[11];
        Arrays.fill(dp,-1);
        System.out.println(countWays(5, dp));
    }
}