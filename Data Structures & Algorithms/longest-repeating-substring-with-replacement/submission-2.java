class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0, maxFreq = 0, maxLength = 0;

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            while((end - start + 1) - maxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
