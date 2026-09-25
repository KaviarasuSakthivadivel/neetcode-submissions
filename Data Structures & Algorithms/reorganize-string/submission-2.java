class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        // Add characters to heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        // Check if impossible
        int maxFreq = pq.peek()[1];

        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        while (!pq.isEmpty()) {

            // Take the most frequent character
            int[] current = pq.poll();

            // Use it
            result.append((char) ('a' + current[0]));
            current[1]--;

            // Put previous character back
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            // Current becomes previous
            previous = current;
        }

        return result.toString();
    }
}