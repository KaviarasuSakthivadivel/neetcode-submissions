class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxL = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(freqMap.containsKey(ch)) {
                start = Math.max(start, freqMap.get(ch) + 1);
            }

            freqMap.put(ch, end);
            maxL = Math.max(maxL, end - start + 1);
        }

        return maxL;
    }
}
