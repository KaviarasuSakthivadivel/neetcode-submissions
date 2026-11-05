static record Node(int temp, int index) {}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            int currentT = temperatures[i];

            while(!stack.isEmpty() && stack.peek().temp() < currentT) {
                result[stack.peek().index()] = i - stack.peek().index();
                stack.pop();
            }
            stack.push(new Node(currentT, i));
        }

        return result;
    }
}
