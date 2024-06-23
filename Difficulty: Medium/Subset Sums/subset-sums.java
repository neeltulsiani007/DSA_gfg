//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
     public static void generate(ArrayList<Integer> candidates  ,ArrayList<Integer> l, ArrayList<Integer> temp , int start )
    {
        if(start>candidates.size())
        return;

        if(start == candidates.size()){
            int ans = 0;
            for(int t : temp)
            ans+=t;
            l.add(ans);
         return;
        }
   
            temp.add(candidates.get(start));
            generate(candidates  , l ,temp , start+1);
            temp.remove(temp.size()-1);
            generate(candidates , l ,temp , start+1);
            return;


    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> candidates, int n) {
        ArrayList<Integer> l = new ArrayList<>();
        generate(candidates  , l , new ArrayList<>() , 0);
        return l;
    }
}