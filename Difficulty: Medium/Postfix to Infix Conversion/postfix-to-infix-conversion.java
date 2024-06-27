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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static boolean isop(char c)
    {
        if(c == '*')
        return true;
         if(c == '/')
        return true;
         if(c == '+')
        return true;
         if(c == '-')
        return true;
         if(c == '^')
        return true;
        return false;
    }
    static String postToInfix(String exp) {
        
        StringBuilder s = new StringBuilder();
        Stack<String> st = new Stack<>();
        
        for(char c : exp.toCharArray())
        {
            if(!isop(c))
            st.push(String.valueOf(c));
            else if(isop(c))
            {
                String c1 = st.pop();
                String c2 = st.pop();
                String t = ')'+c1+c+c2+'(';
                st.push(t);
            }
        }
        while(!st.isEmpty())
        s.append(st.pop());
        
        s.reverse();
    
    return s.toString();
    }
}
