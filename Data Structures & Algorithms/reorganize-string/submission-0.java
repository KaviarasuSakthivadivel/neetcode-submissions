class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        // Not possible to Reorganize String
        if(pq.peek()[1] > (s.length() + 1) / 2) {
            return "";
        }

        int[] previous = null;
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int[] current = pq.poll();

            sb.append((char) (current[0] + 'a'));
            current[1]--;

            if(previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            previous = current;
        }

        return sb.toString();
    }
}