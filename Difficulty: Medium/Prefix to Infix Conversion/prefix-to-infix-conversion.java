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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre) {
        
        Stack<String> st = new Stack<>();

        
        for(int i =pre.length()-1;i>=0;i--)
        {
            char c = pre.charAt(i);
            
            if(Character.isLetter(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String c1 = st.pop();
                String c2 = st.pop();
                String c3 = ')'+c2+c+c1+'(';
                st.push(c3);
            }
            
        }
        String temp = st.pop();
        StringBuilder ans = new StringBuilder(temp);
        return ans.reverse().toString();
    }
}
