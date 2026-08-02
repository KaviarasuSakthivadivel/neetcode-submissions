class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(']', '[');
        closeToOpenMap.put(')', '(');

        for(char ch : s.toCharArray()) {
            if(closeToOpenMap.containsKey(ch)) {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    if(closeToOpenMap.get(ch) != stack.pop()) {
                        return false;
                    }
                }
            } else {
                stack.push(ch);
            }

        }
        return stack.isEmpty();
    }   
}

