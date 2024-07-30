//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    static int bsearch(int[] a , int n , int target,int start , int end)
    {
   
        while(start < end)
        {
            int mid = (start+end)/2;
            
            if(a[mid] < target)
            start = mid+1;
            else
            end = mid;
        }
        
        return end;
    }
    static int longestSubsequence(int n, int a[]) {
        
        int[] dp = new int[n];
        int len=1;
        dp[0] = a[0];
        
        for(int i = 1;i<n;i++)
        {
            if(a[i] > dp[len-1])
            {
            dp[len] = a[i];
            len++;
            }
            else
            {
                int c = bsearch(dp,n,a[i] , 0 ,len-1);
                dp[c] = a[i];
            }
        }
        
       
        
        return len;
        
    }
}