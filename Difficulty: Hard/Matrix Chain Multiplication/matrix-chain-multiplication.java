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
    
    static int ans(int[] arr , int i, int j, int[][] dp)
    {
        int mini = Integer.MAX_VALUE;
        if(i == j)
        return 0;
        
        if(dp[i][j] != -1)
        return dp[i][j];
        
        for(int k = i; k<j;k++)
        {
        int ans = arr[i-1]*arr[j]*arr[k] + ans(arr , i , k ,dp)+ans(arr , k+1 , j,dp); 
        mini = Math.min(mini , ans);
        }
        
        return dp[i][j] = mini ;
    }
    static int matrixMultiplication(int n, int arr[])
    {
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++)
        {
            Arrays.fill(dp[i] , -1);
        }
        return ans(arr , 1 , arr.length-1 , dp);
    }
}