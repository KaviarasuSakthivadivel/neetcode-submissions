class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curSub = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, curSub, result);

        return result;
    }

    private void dfs(int[] nums, int i, List<Integer> curSub, List<List<Integer>> result) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(curSub));
            return;
        }

        curSub.add(nums[i]);
        dfs(nums, i + 1, curSub, result);
        curSub.remove(curSub.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, i + 1, curSub, result);
    }
}
