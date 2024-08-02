//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int a[])
    {
        int[][] dp = new int[n][n];
        
        for(int i = 0;i<n-1;i++)
        {
            dp[i][i+1] = 0;
        }
        
        for(int gap=2 ; gap < n;gap++)
            {
        for(int i = 0 ; i+gap<n;i++)
        {
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1;k<j;k++)
                {
                    dp[i][j]= Math.min(dp[i][j] , dp[i][k]+dp[k][j]+a[i]*a[k]*a[j]);
                }
            }

        }
        
        return dp[0][n-1];
    }
}