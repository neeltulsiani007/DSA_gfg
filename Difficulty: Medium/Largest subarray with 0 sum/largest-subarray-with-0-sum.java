//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int ma = 0;
        int s = 0;
        int ms = 0;
        
        Map<Integer , Integer> m = new HashMap<>();
        
        for(int i = 0;i<n;i++)
        {
            
            s+=arr[i];
            if(s == 0)
            {
                ma = i+1;
            }
            
          //  System.out.println(s);
            if(m.containsKey(s))
            {
                   ma = Math.max(ma ,i-m.get(s));
            }
            else
            m.put(s,i);
        }
        return ma;
    }
}