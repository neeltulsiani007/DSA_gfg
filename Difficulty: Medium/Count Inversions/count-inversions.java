//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static void merge(long[] arr , int l ,int m, int r ,ArrayList<Long> ans )
    {
        ArrayList<Long> list = new ArrayList<>();
        long count = ans.get(0);
       int left = l;
       int right = m+1;
       
       while(left <= m && right<=r)
       {
           if(arr[left] <= arr[right])
           {
               list.add(arr[left]);
               left++;
           }
           else
           {
               list.add(arr[right]);
               count+=m-left+1;
               right++;
           }
       }
       
       while(left<=m)
       {
          list.add(arr[left]);
        left++;
       }
       
       while(right <= r)
       {
          list.add(arr[right]);
          right++;
       }
       
       for(int i = l ; i<=r;i++)
       {
           arr[i] = list.get(i-l);
       }
        ans.set(0 , count);
    }
    static void mergesort(long[] arr , int l , int r,ArrayList<Long> ans)
    {
        if(l>=r)
        return;
        
        int mid = (l+r)/2;
        mergesort(arr , l ,mid,ans);
        mergesort(arr , mid+1 , r,ans);
        merge(arr , l ,mid,r,ans);

    }
    static long inversionCount(long arr[], int n) {
        ArrayList<Long> ans = new ArrayList<>();
        ans.add((long)0);
         mergesort(arr , 0 , n-1 , ans);
         return ans.get(0);
    }
}