//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int mod= (int)1e9+7;
    
    static long fun(int n , long[] memo)
    {
         
             if(memo[n] == -1)
            {
                long res;
                if(n == 0 || n == 1)
                res = n;
                else
                res = (fun(n-1,memo) + fun(n-2,memo))%mod;
                
                memo[n] = res;
            }
            return memo[n];
    }
   
    static long topDown(int n) {
            
          long memo[] = new long[n+1];
          Arrays.fill(memo , -1);
            return fun(n,memo);
    }

    static long bottomUp(int n) {
        
        long f[] = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        
        for(int i =2;i<=n;i++)
        {
            f[i] = (f[i-1] + f[i-2])%mod;
        }
        
        return f[n];
}
}
