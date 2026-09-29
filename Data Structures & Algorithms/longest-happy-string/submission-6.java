class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y[0], x[0])
        );

        if (a > 0) {
            pq.offer(new int[]{a, 'a'});
        }

        if (b > 0) {
            pq.offer(new int[]{b, 'b'});
        }

        if (c > 0) {
            pq.offer(new int[]{c, 'c'});
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            // Most frequent character
            int[] first = pq.poll();

            int count = first[0];
            char ch = (char) first[1];

            // Would adding this character create "aaa", "bbb", or "ccc"?
            if (result.length() >= 2
                    && result.charAt(result.length() - 1) == ch
                    && result.charAt(result.length() - 2) == ch) {

                // No alternative character available
                if (pq.isEmpty()) {
                    break;
                }

                // Take the second most frequent character
                int[] second = pq.poll();

                int secondCount = second[0];
                char secondChar = (char) second[1];

                // Use the second character
                result.append(secondChar);
                secondCount--;

                // Put the first character back unchanged
                pq.offer(first);

                // Put second character back if we still have some
                if (secondCount > 0) {
                    pq.offer(new int[]{secondCount, secondChar});
                }

            } else {

                // Safe to use the most frequent character
                result.append(ch);
                count--;

                // Put it back if we have more
                if (count > 0) {
                    pq.offer(new int[]{count, ch});
                }
            }
        }

        return result.toString();
    }
}