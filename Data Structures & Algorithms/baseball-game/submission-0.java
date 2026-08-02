class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {
            if(op.equals("C")) {
                stack.pop();
            } else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if(op.equals("+")) {
                int first = stack.pop();
                int value = stack.peek() + first;
                stack.push(first);
                stack.push(value);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int total = 0;
        for(int num : stack) {
            total += num;
        }

        return total;
    }
}