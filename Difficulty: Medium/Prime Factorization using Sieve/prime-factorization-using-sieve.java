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
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int n) {
        int[] p = new int[n+1];
        List<Integer> l = new ArrayList<Integer>();

        for(int i = 2;i<=n;i++)
        {
            p[i]= i;
        }


        for(int i = 2; i*i<=n;i++)
        {
            if(p[i] == i)
            {
                for(int j = i*i;j<=n;j+=i)
                {
                    if(p[j] == j)
                    p[j] = i;
                }
            }
        }
        
        while(n !=1)
        {
            l.add(p[n]);
            n = n/p[n];
        }
        
        return l;
        
        
    }
}
