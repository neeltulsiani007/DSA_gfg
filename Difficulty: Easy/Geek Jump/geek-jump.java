//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        
        int[] f = new int[N+1];
        
        if(N == 1)
        return 0;
        if(N==2)
        {
            return Math.abs(arr[1] - arr[0]);
        }
        
        f[1] = Math.abs(arr[1] - arr[0]);
        f[0] = 0;
        
        
        for(int i = 2;i<N;i++)
        {
            f[i] = Math.min((f[i-2] + Math.abs(arr[i] - arr[i-2])) , f[i-1] + Math.abs(arr[i] - arr[i-1]));
        }
        
        return f[N-1];
    }
}