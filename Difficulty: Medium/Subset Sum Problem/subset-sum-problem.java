//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    public static boolean ans(int[] arr , int ind , int sum , Boolean[][] memo)
    {
        if(sum == 0)
        return true;
        if(ind >= arr.length || sum < 0)
        return false;

        if(memo[ind][sum]!=null) return memo[ind][sum];

        boolean np = ans(arr , ind+1 , sum , memo);
        boolean p = false;
        if(sum - arr[ind] >=0)
        p = ans(arr , ind+1 , sum-arr[ind] , memo);

        return memo[ind][sum] = np || p;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        

        Boolean[][] memo = new Boolean[arr.length+1][sum+1];

        return ans(arr , 0 , sum , memo);
       
    }
}