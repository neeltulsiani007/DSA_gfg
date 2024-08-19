//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    public int lb(int[] arr , int target)
    {
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while(start <= end)
        {
            int mid = (start+end)/2;

            if(arr[mid] >= target)
            {
                ans = mid;
                end = mid-1;
            }
            else
            start = mid+1;
        }
        return ans;
    }

    public int ub(int[] arr , int target)
    {
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;

        while(start <= end)
        {
            int mid = (start+end)/2;

            if(arr[mid] > target)
            {
                ans = mid;
                end = mid-1;
            }
            else
            start = mid+1;
        }
        return ans;
    }
    int count(int[] arr, int n, int x) {
        
        int t = lb(arr,x);
        if( t== n || arr[t] != x )
        return 0;
        return ub(arr , x) - t;
    }
}