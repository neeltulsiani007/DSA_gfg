//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod =1000000007;
    public static int countsubsets(int n , int target , int[]arr)
    {
        int[][] dp = new int[n+1][target+1];
        
        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = 1;
        }
        
        for(int i =1;i<=n;i++)
        {
            for(int j = 0;j<=target;j++)
            {
                if(j-arr[i-1] >= 0)
                {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]])%mod;
                }
                else
                dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][target];
    }
    public static int countPartitions(int n, int d, int[] arr) {
        
        int sum = 0;
        for(int i : arr)
        sum+=i;
        if((sum+d)%2!=0  || sum<Math.abs(d)) 
            return 0;
        
        return countsubsets(n,(sum+d)/2,arr);
        
    }
    
}
        
