class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            int currentT = temperatures[i];

            while(!stack.isEmpty() && stack.peek()[0] < currentT) {
                result[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[] {currentT, i});
        }

        return result;
    }
}
