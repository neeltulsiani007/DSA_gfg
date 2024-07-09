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
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int n, int k) {
       
       int[] f = new int[n];
       Arrays.fill(f , Integer.MAX_VALUE);
       
       if(n == 0)
       return 0;
       if(n == 1)
       return Math.abs(arr[1] - arr[0]);
       
       f[0] = 0;
       f[1] = Math.abs(arr[1] - arr[0]);
       
       for(int i =2;i<n;i++)
       {
           int t = 1;
           while(t <= k)
           {
               if(i-t >=0){
               f[i] = Math.min(f[i] , f[i-t] + Math.abs(arr[i] - arr[i-t]));
               
               }
               t++;
           }
       }
       
       return f[n-1];
    }
}
