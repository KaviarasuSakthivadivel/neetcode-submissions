class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, comb, result);

        return result;
    }

    private void backtrack(int i, int n, int k, List<Integer> comb, List<List<Integer>> result) {
        if(i > n) {
            if(comb.size() == k) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }

        comb.add(i);
        backtrack(i + 1, n, k, comb, result);
        comb.remove(comb.size() - 1);

        backtrack(i + 1, n, k, comb, result);
    }
}