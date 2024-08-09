//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int upper(int[] arr , int target , int n)
    {
        int low = 0;
        int ans = n;
        int high = n-1;
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            if(arr[mid] <= target)
            {
                low =mid+1;
            }
            else{
                ans=mid;
            high = mid-1;
            }
        }
        
        return ans;
    }
    
    int blackbox(int[][] arr , int mid , int m , int n)
    {
        int count = 0;
        for(int i = 0;i<m;i++)
        {
            count+=upper(arr[i] , mid,n);
        }
        return count;
    }
    int median(int arr[][], int m, int n) {
    
         int low = Integer.MAX_VALUE;
         int high = Integer.MIN_VALUE;
         int c = (m*n)/2;
         
         for(int i =0;i<m;i++)
         {
            low = Math.min(low , arr[i][0]);
            high = Math.max(high , arr[i][n-1]);
         }
         
         while(low <= high)
         {
             int mid = (low+high)/2;
             int t = blackbox(arr , mid , m , n);
             
             if(t <= c)
             low = mid+1;
             else
             high = mid-1;
         }
         
         return low;
    }
}