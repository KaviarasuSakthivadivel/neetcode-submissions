class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {
            // closing bracket
            if(ch == ']') {
                List<Character> list = new ArrayList<>();

                while(stack.peek() != '[') {
                    list.add(stack.pop());
                }

                stack.pop();

                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + base * (stack.pop() - '0');
                    base *= 10;
                }

                while(k != 0) {
                    for(int i = list.size() - 1; i >= 0; i--) {
                        stack.push(list.get(i));
                    }
                    k--;
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}