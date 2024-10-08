//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void bfs(ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> l , int s ,boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        
        
        while(!q.isEmpty())
        {
            int u = q.poll();
            l.add(u);
            
            for(int i=0;i<adj.get(u).size();i++)
            {
                if(visited[adj.get(u).get(i)] == false)
                {
                    visited[adj.get(u).get(i)] = true;
                    q.add(adj.get(u).get(i));
                }
            }
        }
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        bfs(adj , l , 0 , visited);
        return l;
    }
}