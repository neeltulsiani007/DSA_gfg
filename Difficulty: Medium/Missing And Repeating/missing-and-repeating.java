//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        int sum = 0;
        
        for(int i =0;i<n;i++)
        {
            sum^=arr[i];
            sum^=(i+1);
        }

       int bit = 0;
       while((sum & (1<<bit)) == 0)
       bit++;
        
         int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & (1<<bit)) != 0) {
                one = one ^ arr[i];
            }
            else {
                zero = zero ^ arr[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & (1<<bit)) != 0) {
                one = one ^ i;
            }
            else {
                zero = zero ^ i;
            }
        }
        int c = 0;
        for(int i : arr)
        {
            if(i == zero)
            c++;
        }
        
        return c==2?new int[]{zero , one}:new int[]{one , zero};
    }
}