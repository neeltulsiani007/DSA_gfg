//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class Triplet implements Comparable<Triplet>{
    int val , num , ind;
    
    Triplet(int val , int num , int ind)
    {
        this.val = val;
        this.num = num;
        this.ind = ind;
    }
    
    public int compareTo(Triplet t)
    {
        if(val <= t.val)
        return -1;
        else
        return 1;
    }
}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        
        ArrayList<Integer> p = new ArrayList<Integer>();

       PriorityQueue<Triplet> q = new PriorityQueue<Triplet>();
        
        for(int i =0;i<K;i++)
        {
           // System.out.println(arr[i][i]);
            q.add(new Triplet(arr[i][0] , i , 0));
        }
        // System.out.println("here");
        
        while(!q.isEmpty())
        {
            
           // System.out.println(q.peek().val + " "+q.peek().num+" "+q.peek().ind);
            Triplet m = q.poll();
            p.add(m.val);
            int num = m.num;
            int ind = m.ind;
            ind+=1;
            
            if(ind < K)
            {
              //  System.out.println(arr[num][ind]);
                q.add(new Triplet(arr[num][ind] , num , ind));
            }
        }
        
        return p;
        
        
    }
}