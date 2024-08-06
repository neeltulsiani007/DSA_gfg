//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int bs(int[] arr , int target)
    {
        
        int start = 0;
        int end = arr.length-1;
        int ind=arr.length;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(arr[mid] >= target)
            {
                ind = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return ind;
    }
    
    public int rowWithMax1s(int matrix[][]) {
        
        int cnt_max = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < matrix.length; i++) {
            // get the number of 1's:
            int cnt_ones = matrix[0].length - bs(matrix[i], 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}