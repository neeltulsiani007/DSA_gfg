//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        
        int l = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> m = new HashMap<>();
        int r = 0;
        
        while(r<arr.length)
        {
             if(!m.containsKey(arr[r]))
           {
               m.put(arr[r] , 1);
           }
           else if(m.containsKey(arr[r]))
           {
               m.put(arr[r] , m.get(arr[r])+1);
           }
            
            if(m.size() > 2)
            {
                while(m.size() > 2)
                {
                  m.put(arr[l] , m.get(arr[l])-1);
                  if(m.get(arr[l]) == 0)
                  m.remove(arr[l]);
                  l++;
                }
            }
            max = Math.max(max , r-l+1);
            r++;
            
            
            
        }
       return max;
        
    }
}