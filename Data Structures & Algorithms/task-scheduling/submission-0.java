static record WaitingRoom(int task, int idleTime) {};

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq) {
            if(f > 0) {
                maxHeap.offer(f);
            }
        }

        int time = 0;

        Queue<WaitingRoom> queue = new LinkedList<>();

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = queue.peek().idleTime();
            } else {
                int f = maxHeap.poll() - 1;

                if(f > 0) {
                    queue.add(new WaitingRoom(f, time + n));
                }
            }

            if(!queue.isEmpty() && queue.peek().idleTime() == time) {
                maxHeap.offer(queue.poll().task());
            }
        }

        return time;
    }
}
