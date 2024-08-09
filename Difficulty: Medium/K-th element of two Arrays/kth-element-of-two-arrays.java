//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int nums1[], int nums2[]) {
        
        int m = nums1.length;
        int n = nums2.length;  
        if (m > n) return kthElement(k,nums2, nums1); 
        long total = m+n;
      
         int low = Math.max(0, k - n), high = Math.min(k, m);
        while(low <= high)
        {
            int mid1 = (low+high)/2;
            int mid2 = (k - mid1);

            long l1 = (mid1 > 0) ? nums1[mid1 - 1] : Long.MIN_VALUE;
            long l2 = (mid2 > 0) ? nums2[mid2 - 1] : Long.MIN_VALUE;
            long r1 = (mid1 < m) ? nums1[mid1] : Long.MAX_VALUE;
            long r2 = (mid2 < n) ? nums2[mid2] : Long.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1)
            {
            return Math.max(l1,l2);
            }
            else if(l1 > r2)
            {
                high = mid1-1;
            }
            else
            low = mid1+1;
        }
        return 0;   
        
    }
}