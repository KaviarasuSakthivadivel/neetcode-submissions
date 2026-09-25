class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // [enqueueTime, processingTime, index]
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(sortedTasks, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Pick shortest processing time,
        // then smallest index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[2], b[2]);
            }
        );

        int[] answer = new int[n];

        int i = 0;
        int k = 0;

        long time = 0;

        while (i < n || !pq.isEmpty()) {

            // CPU is idle, so jump to the next task's arrival time
            if (pq.isEmpty()) {
                time = Math.max(time, sortedTasks[i][0]);
            }

            // Add every task that has arrived
            while (i < n && sortedTasks[i][0] <= time) {
                pq.offer(sortedTasks[i]);
                i++;
            }

            // Pick the task with shortest processing time
            int[] task = pq.poll();

            answer[k++] = task[2];

            // Process the task completely
            time += task[1];
        }

        return answer;
    }
}