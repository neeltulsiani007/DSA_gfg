//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post) {
        
        Stack<String> st = new Stack<>();
        
        for(char c : post.toCharArray())
        {
            if(Character.isLetter(c))
            st.push(String.valueOf(c));
            else
            {
                String v = st.pop();
                String t = c+st.pop()+v;
                st.push(t);
            }
        }
        return st.pop();
    }
}
