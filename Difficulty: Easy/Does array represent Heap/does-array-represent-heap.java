//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public boolean check(long arr[] , int i , long n)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        boolean flag = true;
        
        if(left < n && right < n)
        {
            if(arr[left] <= arr[i] && arr[right] <= arr[i])
            {
                 flag =  check(arr ,left,n ) && check(arr,right , n);
                return flag;
            }
            else
            return false;
        }
        else if(left < n)
        {
            if(arr[left] <= arr[i])
            return check(arr , left , n);
            else
            return false;
        }
        else if(right < n)
        {
            if(arr[right] <= arr[i])
            return check(arr , right , n);
            else
            return false;
        }
        
        return flag;
        
    }
    
    public boolean countSub(long arr[], long n)
    {
        return check(arr , 0,n);
    }
}