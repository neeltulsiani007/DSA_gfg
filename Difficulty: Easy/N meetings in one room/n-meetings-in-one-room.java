//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Timings{
    int start , end ,  dur;
    Timings(int start ,int end ,int dur)
    {
        this.start = start;
        this.end = end;
        this.dur = dur;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Timings> l = new ArrayList<>();
        int m = 1;
        
        for(int i =0;i<start.length;i++)
        {
            l.add(new Timings(start[i] , end[i] , end[i] - start[i]));
        }
        
        Collections.sort(l , new Comparator<Timings>(){
            public int compare(Timings a , Timings b){
            return a.end - b.end;
            }
        });
        int lastend = l.get(0).end;
        for(int t =1;t<l.size();t++)
        {
            int s = l.get(t).start;
            int e = l.get(t).end;
            //System.out.println(s +" "+e);
            
            if(s > lastend)
            {
                m++;
                lastend = e;
            }
            
        }
        return m;
        
    }
}
