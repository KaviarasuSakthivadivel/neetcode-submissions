class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String token : tokens) {
            if(!((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/")))) {
                stack.push(Integer.parseInt(token));
            } else {
                if(!stack.isEmpty()) {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    
                    if(token.equals("+")) {
                        stack.push(a+b);
                    } else if(token.equals("-")) {
                        stack.push(b-a);
                    } else if(token.equals("*")) {
                        stack.push(a*b);
                    } else if(token.equals("/")) {
                        stack.push(b/a);    
                    } 
                }
            }
        }

        return !stack.isEmpty() ? stack.pop() : -1;
    }
}
