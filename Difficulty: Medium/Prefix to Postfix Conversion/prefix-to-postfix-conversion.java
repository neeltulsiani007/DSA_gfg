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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre) {
        
        Stack<String> st = new Stack<>();
        
        
        for(int i =pre.length()-1 ; i>=0;i--)
        
        {
            if(Character.isLetter(pre.charAt(i)))
            {
                st.push(String.valueOf(pre.charAt(i)));
            }
            else
            {
                String t = st.pop();
                String v = pre.charAt(i)+st.pop()+t;
                st.push(v);
            }
        }
        String temp = st.pop();
        StringBuilder ans = new StringBuilder(temp);
        return ans.reverse().toString();
    }
}
