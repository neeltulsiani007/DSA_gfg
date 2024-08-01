//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int n) {
        
        int [][] dp = new int[n][4];
        dp[0][0] = Math.max(arr[0][1] , arr[0][2]);
        dp[0][1] = Math.max(arr[0][0] , arr[0][2]);
        dp[0][2] = Math.max(arr[0][1] , arr[0][0]);
        dp[0][3] = Math.max(arr[0][1] , Math.max(arr[0][0] , arr[0][2]));
        
        for(int i = 1;i<n;i++)
        {
            for(int j = 0 ;j<4;j++)
            {
                dp[i][j] = 0;
                for(int k =0;k<=2;k++)
                {
                   
                    if(k != j)
                    {
                        int t = arr[i][k] + dp[i-1][k];
                        dp[i][j] = Math.max(t , dp[i][j]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}