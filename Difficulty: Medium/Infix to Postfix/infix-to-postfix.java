//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    public static int precedence(char c)
    {
        switch(c)
        {
            case '(':
                return 1;
                case ')':
                return 1;
                
        
            case '+':
                return 3;
             
            case '-':
                return 3;
               
            case '*':
                return 4;
                
            case '/':
                return 4;
              
            case '^':
                return 5 ;
              
            default :
            return 0;
        }
    }
    public static String infixToPostfix(String exp) {
        
       StringBuilder ans = new StringBuilder();
       Stack<Character> st = new Stack<>();
       
       for(char c: exp.toCharArray())
       {
          //System.out.println(ans);
           
           if(precedence(c) == 0)
           {
               
               ans.append(c);
           }
          else
          {
             // System.out.println(st);
              if(st.isEmpty()){
              st.push(c);
              continue;
              }
              
              if(c == '(')
              {
              st.push(c);
              continue;
              }
              else if(c == ')')
              {
                  
                  char t = st.pop();
                  
                  while(t != '(')
                  {
                      ans.append(t);
                      t=st.pop();
                  }
                  continue;
              }
              else if(precedence(st.peek()) == precedence(c))
                       {
                           
                               ans.append(st.pop());
                               st.push(c);
                         
                        }
                      
              
               else if(precedence(st.peek()) < precedence(c))
               {
                   st.push(c);
               }
               else if(precedence(st.peek()) > precedence(c))
               {
               // System.out.println("there "+c);
                char t = st.pop();
                //System.out.println("h "+t);
                ans.append(t);
               // System.out.println("here "+st.peek());
                   while(!st.isEmpty() && precedence(st.peek()) > precedence(c))
                   {
                       
                        char te = st.pop();
                       //  System.out.println(te);
                       ans.append(te);
                       
                   }
                   if(st.isEmpty())
                   {
                       st.push(c);
                       continue;
                   }
                   //continue;
                    if(precedence(st.peek()) == precedence(c))
                       {
                           if(c == '^')
                           st.push(c);
                           else
                           {
                               ans.append(st.pop());
                               st.push(c);
                           }
                           continue;
                        }
                        st.push(c);
               }
               
              
              }
           }
           while(!st.isEmpty())
           {
               ans.append(st.pop());
           }
           return ans.toString();
       }
       
    }
