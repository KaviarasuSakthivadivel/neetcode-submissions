class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], result);

        return result;
    }

    private void backtrack(List<Integer> perm, int[] nums, boolean[] pick, List<List<Integer>> result) {
        if(perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                pick[i] = true;
                perm.add(nums[i]);

                backtrack(perm, nums, pick, result);

                pick[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
