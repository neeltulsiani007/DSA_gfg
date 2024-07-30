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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
      public int[] lcs(int[] a , int[] hash) {
        
        int[] dp = new int[a.length];
        dp[0] = 1;
        
        for(int i =1;i<a.length;i++)
        {
            hash[i] = i;
            dp[i] = 1;
            for(int j = 0;j<i;j++)
            {
                if(a[i]>a[j] && (1+dp[j] > dp[i]))
                {
                dp[i] = dp[j]+1;
                  hash[i] = j;
                }
            }
        }
        
        return dp;
        
    }

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        int[] hash = new int[n];
        int[] dp = lcs(arr , hash);
        
        int max = 0;
        int lastindex = 0;
        
        for(int i =0;i<n;i++)
        {
            if(dp[i] > max)
            {
                max = dp[i];
                lastindex = i;
            }
        }
        l.add(arr[lastindex]);
        
        // for(int i =0;i<n;i++)
        // {
        //     System.out.print(hash[i]+" ");
        // }
        // System.out.println();
        
        while(hash[lastindex] != lastindex)
        {
            lastindex = hash[lastindex];
            l.add(arr[lastindex]);
        }
        Collections.reverse(l);
        return l;
        
    }
}
