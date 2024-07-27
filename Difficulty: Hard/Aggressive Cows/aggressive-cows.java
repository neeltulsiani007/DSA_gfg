//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static boolean checkcow(int n , int k , int[] arr,int mid)
    {
        int c = arr[0];
        k--;
        for(int i =1;i<arr.length;i++)
        {
            if(arr[i] - c >= mid)
            {
                c = arr[i];
                k--;
            if(k == 0)
            return true;
            }
        }
        return false;
    }
    
    public static int solve(int n, int k, int[] stalls) {
     
     Arrays.sort(stalls);
     
     int max = stalls[0];
     int min = stalls[0];
     
     for(int i : stalls)
     {
         max = Math.max(i, max);
         min = Math.min(i, min);
     }
     
     int start = 1;
     int end = max - min;
     int ans = 0;
     
     while(start <= end)
     {
         int mid = (start+end)/2;
         
         if(checkcow(n , k , stalls , mid))
         {
            ans = mid;
            start = mid+1;
         }
         else
         end = mid-1;
     }
     return ans;
    }
}