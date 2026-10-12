class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            preMap.get(pre[1]).add(pre[0]);
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[n];
        int idx = 0;
        while(!queue.isEmpty()) {
            int c = queue.poll();

            result[idx++] = c;

            for(int pre : preMap.get(c)) {
                if(--indegree[pre] == 0) {
                    queue.offer(pre);
                }
            }
        }
        return idx == n ? result : new int[0];
    }
}
