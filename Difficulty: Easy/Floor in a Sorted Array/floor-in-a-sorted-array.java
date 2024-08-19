//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Searching {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]);
            }

            out.println(new Solution().findFloor(arr, n, x));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {

    
    
    static int findFloor(long arr[], int n, long x) {
        
        int start = 0;
        int end = n-1;
        int ans = -1;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            
            if(arr[mid] > x)
            {
                end = mid-1;
            }
            else if(arr[mid] == x)
            return mid;
            else
            {
                ans = mid;
                start = mid+1;
            }
        }
        
        return ans;
    }
}
