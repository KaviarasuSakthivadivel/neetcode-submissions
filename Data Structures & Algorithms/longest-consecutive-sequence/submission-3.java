class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int length = 0;

        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int streak = 1;

                while(set.contains(num + streak)) {
                    streak++;
                }

                length = Math.max(length, streak);
            }
        }

        return length;
    }
}
