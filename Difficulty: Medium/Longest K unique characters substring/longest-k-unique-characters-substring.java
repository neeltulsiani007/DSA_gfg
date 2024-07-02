//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends




class Solution {
    public int longestkSubstr(String c, int k) {
        
      
      char[] arr = c.toCharArray();
      
      int l = 0;
      int i =0;
      int max=-1;
        HashMap<Character , Integer> m = new HashMap<>();
      
      while(i<arr.length)
      {
          m.put(arr[i] , m.getOrDefault(arr[i] ,0)+1);
          
          while(m.size() > k)
          {
              m.put(arr[l] , m.get(arr[l])-1);
              if(m.get(arr[l]) == 0)
              m.remove(arr[l]);
              l++;
          }
          
          if(m.size() == k)
          {
              max = Math.max(i-l+1,max);
       
          }
             i++;
          
      }
      
     return max;
      
    }
}