//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
        int x = arr[0];
        
        for(int i=1;i<n;i++)
        x ^= arr[i];
        
        int bit = x & (~(x-1));
        
        int leftset = 0;
        int rightset = 0;
        
        for(int i : arr)
        {
            if((i & bit) != 0)
            leftset^=i;
            else
            rightset^=i;
        }
        
        if(rightset > leftset)
        {
            int t = leftset;
            leftset = rightset;
            rightset = t;
        }
        
        
        return new int[]{leftset,rightset};
        
    }
}