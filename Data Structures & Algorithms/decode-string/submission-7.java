class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int num = 0;
        StringBuilder currentS = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if(ch == '[') {
                countStack.push(num);
                stringStack.push(currentS);

                num = 0;
                currentS = new StringBuilder();
            } else if(ch == ']') {
                int repeat = countStack.pop();
                currentS = stringStack.pop().append(currentS.toString().repeat(Math.max(0, repeat)));
            } else {
                currentS.append(ch);
            }
        }
        return currentS.toString();
    }
}