//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    public int ans(int[] arr , int k , int index , int[] memo,int n)
    {
        if(index == 0)
        return 0;
        
        if(memo[index] != -1)
        return memo[index];
        
        int temp = Integer.MAX_VALUE;
        
        for(int i = 1 ; i<=k ;i++)
        {
            if(index - i >= 0){
            int jump =  Math.abs(arr[index] - arr[index-i]) + ans(arr , k ,index-i , memo,n);
            temp = Math.min(temp ,jump);
            }
        }
        
        return memo[index] = temp; 
    }
    public int minimizeCost(int arr[], int k) {
         int[] memo = new int[arr.length+1];
         int n = arr.length;
         Arrays.fill(memo,-1);
         return ans(arr , k , n-1 , memo,n);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, k);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends