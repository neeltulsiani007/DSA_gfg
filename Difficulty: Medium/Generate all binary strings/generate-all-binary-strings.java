//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static void generate(int k , char[] ch , int n , List<String> l)
    {
        
        if(n==k)
        {
            String s = new String(ch);
            l.add(s);
            return;
        }
        
        if(ch[n-1] == '0')
        {
            ch[n] = '0';
            generate(k,ch,n+1,l);
            ch[n] = '1';
            generate(k,ch,n+1,l);
        }
        else
        {
            ch[n] = '0';
            generate(k,ch,n+1,l);
        }
    }
    
    public static void fun(int k ,List<String> l)
    {
        if(k<=0)
        return;
        
        char[] ch = new char[k];
        ch[0] = '0';
        generate(k , ch , 1 , l);
        ch[0] = '1';
        generate(k , ch , 1 , l);
    }
    
    
  public static List<String> generateBinaryStrings(int n) {
    
    List<String> l = new ArrayList<>();
    fun(n , l);
    return l;
    
  }
}
     
     