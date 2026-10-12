class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));

        if(visited.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int turns = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String lock = queue.poll();
                if(lock.equals(target)) {
                    return turns;
                }

                for(String next : children(lock)) {
                    if(!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    private List<String> children(String lock) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char)(((arr[i] - '0' + 1) % 10) + '0');
            result.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char)(((arr[i] - '0' - 1 + 10) % 10) + '0');
            result.add(new String(arr));
        }

        return result;
    }
}