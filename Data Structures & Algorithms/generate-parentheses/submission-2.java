class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int openN, int closeN, int N, StringBuilder sb, List<String> result) {
        // base case to add it to result
        if(openN == closeN && closeN == N) {
            result.add(sb.toString());
            return;
        }

        if(openN < N) {
            sb.append('(');
            backtrack(openN + 1, closeN, N, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closeN < openN) {
            sb.append(')');
            backtrack(openN, closeN + 1, N, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
