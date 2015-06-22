package leetcode;
import java.util.*;

/**
* https://leetcode.com/problems/basic-calculator/
* Solution: https://leetcode.com/discuss/39553/iterative-java-solution-with-stack
**/

public class BasicCalculator {
    public int calculate(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Stack<String> stack = new Stack<String>();
        
        int numStartIndex = -1;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(numStartIndex == -1 && c == ' '){
                continue;
            }
            
            if(c >= '0' && c <= '9'){
                
                if(numStartIndex == -1){
                    numStartIndex = i;
                }
                
            }else{
                
                if(numStartIndex != -1){
                    String num = s.substring(numStartIndex, i);
                    calcuateInStack(num, stack);
                }
                
                if(c == ' '){
                    // do nothing
                }
                else if(c == ')'){
                    String n = stack.pop();
                    stack.pop(); // poped char should be ')'
                    calcuateInStack(n, stack);
                }else{ // c == '(' || c == '+' || c == '-'
                    stack.push(String.valueOf(c));
                }
                
                numStartIndex = -1;
            }
        }
        
        if(numStartIndex != -1){
            String num = s.substring(numStartIndex, s.length());
            calcuateInStack(num, stack);
        }
        
        return Integer.parseInt(stack.pop());
        
    }
    
    private void calcuateInStack(String num, Stack<String> stack){
   
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
   
        String pre = stack.peek();
        
        if(pre.equals("+")){
            stack.pop();
            int result = Integer.parseInt(stack.pop()) + Integer.parseInt(num);
            calcuateInStack(String.valueOf(result), stack);
        }else if(pre.equals("-")){
            stack.pop();
            int result = Integer.parseInt(stack.pop()) - Integer.parseInt(num);
            calcuateInStack(String.valueOf(result), stack);
        }else{
            stack.push(num);
        }
    }
}
