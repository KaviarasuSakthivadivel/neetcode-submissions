class Solution {
    public String minWindow(String s, String t) {
        int windowStart = 0, matched = 0, minLength = s.length() + 1, subStrStart = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : t.toCharArray()) {
        charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
    }
    
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        char rightChar = s.charAt(windowEnd);
        if (charFrequencyMap.containsKey(rightChar)) {
            charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
            if (charFrequencyMap.get(rightChar) >= 0) {
                matched++;
            }
        }
        
        while (matched == t.length()) {
            if (minLength > windowEnd - windowStart + 1) {
                minLength = windowEnd - windowStart + 1;
                subStrStart = windowStart;
            }
            
            char leftChar = s.charAt(windowStart);
            windowStart++;
            if (charFrequencyMap.containsKey(leftChar)) {
                if (charFrequencyMap.get(leftChar) == 0) {
                    matched--;
                }
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
            }
        }
    }
    
    return minLength > s.length() ? "" : s.substring(subStrStart, subStrStart + minLength);
    }
}
