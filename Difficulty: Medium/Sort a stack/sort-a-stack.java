//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    
    public static void sort(Stack<Integer> s , int t)
    {
        if(s.isEmpty() || s.peek() < t)
        {
            s.push(t);
        }
        else
        {
            int x = s.peek();
            s.pop();
            sort(s,t);
            s.push(x);
        }
    }
    
    public static void reverse(Stack<Integer> s)
    {
        if(!s.isEmpty())
        {
            int t = s.peek();
            s.pop();
            reverse(s);
            sort(s,t);
        }
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        
        reverse(s);
        return s;
    }
}