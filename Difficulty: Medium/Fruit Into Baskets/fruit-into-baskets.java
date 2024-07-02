//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int n, int[] arr) {
        
        int max = 0;
        int l =0;
       
        int i=0 ;
        
        
        Map<Integer,Integer> m = new HashMap<>();
        
       while(i<n)
       {
           if(!m.containsKey(arr[i]))
           {
               m.put(arr[i] , 1);
           }
           else if(m.containsKey(arr[i]))
           {
               m.put(arr[i] , m.get(arr[i])+1);
           }
           
           if(m.size() > 2)
           {
               while(m.size() >2)
               {
                  m.put(arr[l] , m.get(arr[l])-1);
                  if(m.get(arr[l]) == 0)
                  m.remove(arr[l]);
                  l++;
               }
           }
           max = Math.max(max , i-l+1);
           i++;
       }
        
        return max;
        
    }
}