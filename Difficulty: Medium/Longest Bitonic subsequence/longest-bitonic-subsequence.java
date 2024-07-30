//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int[] lcs( int n,int[] a ) {
         int[] dp = new int[a.length];
        dp[0] = 1;
        
        for(int i =1;i<a.length;i++)
        {
            dp[i] = 1;
            for(int j = 0;j<i;j++)
            {
                if(a[i]>a[j])
                dp[i] = Math.max(dp[i] , dp[j]+1);
            }
        }
        return dp;
        
    }
    public static int LongestBitonicSequence(int n, int[] nums) {
        
        int[] rev= new int[n];
        
        for(int i =n-1;i>=0;i--)
        {
            rev[n-i-1] = nums[i];
        }
        
        // for(int i  : rev)
        // System.out.println(i);
        
        int[] dp1 = lcs(n,nums);
        int[] dp2 = lcs(n,rev);
        
        int[] dp3 = new int[n];
        
        for(int i =n-1;i>=0;i--)
        {
            dp3[n-i-1] = dp2[i];
        }
        
      
        
       int max = 0;
        for (int i = 0; i < n; i++)
            if (dp1[i] + dp3[i] - 1 > max &&(dp1[i] > 1 && dp3[i] > 1))
                max = dp1[i] + dp3[i] - 1;
        
        return max;
       
    }
}
