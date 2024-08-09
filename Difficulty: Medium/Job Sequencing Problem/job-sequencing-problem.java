//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
         int fin[] = new int[n];
        for(int i=0;i<n;i++)
        {
            fin[i]= -1;
        }
        
        int val = 0;
        int c=0;
        
        List<int[]> l = new ArrayList<>();
        
        for(int i =0;i<n;i++)
        {
            int [] temp = {arr[i].id , arr[i].deadline , arr[i].profit};
            l.add(temp);
        }
        
        Collections.sort(l , new Comparator<int[]>(){
            public int compare(int[] A , int[] B)
            {
                return A[2] - B[2];
            }
        });
        

        
       for(int i = n-1;i>=0;i--)
       {
           for(int j = l.get(i)[1] ;j>0;j--)
           {
              
               if(fin[j-1] == -1){
                    c++;
                    val+=l.get(i)[2];
                   fin[j-1] = 1;
                   break;
               }
           }
       }
        
        return new int[]{c , val};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/