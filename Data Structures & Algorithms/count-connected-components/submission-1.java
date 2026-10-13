class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int start, List<List<Integer>> adj, boolean[] visited) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;
        for(int nei : adj.get(start)) {
            if(!visited[nei]) {
                dfs(nei, adj, visited);
            }
        }
    }
}
