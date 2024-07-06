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
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void heapify(int n, int[] arr , int i)
    {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        
        if(left < n && arr[left] > arr[largest]){
        largest = left;
        }
        
        if(right < n && arr[right] > arr[largest]){
        largest = right;
        }
        
        if(largest != i){
        int t = arr[largest];
        arr[largest] = arr[i];
        arr[i] = t;
        heapify(n , arr , largest);
        }
        
        
        
        
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
    
    int t = N-1;
    t=t/2;
    for(int i = t ;i>=0;i--)
    heapify(N , arr , i);

  }
}
     