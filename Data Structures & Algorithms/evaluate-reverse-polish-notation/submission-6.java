class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        HashSet<String> set = new HashSet<String>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String token : tokens) {
            if(!set.contains(token)) {
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
        
        if(!stack.isEmpty()) {
            return stack.pop();
        } else {
            return -1;
        }
    }
}
