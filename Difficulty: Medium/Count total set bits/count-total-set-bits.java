//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    public static int findmax(int t)
    {
        int ct = 0;
        
        while(t >= (1 << (ct+1)))
        ct++;
        
        return ct;
    }
    public static int countSetBits(int t){
        
        if(t == 0)
        return 0;
        int getp = findmax(t);
        int ct = getp * (1 << (getp-1));
        int z = t- (1 << getp);
        return ct+z+1+countSetBits(z);
        
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends