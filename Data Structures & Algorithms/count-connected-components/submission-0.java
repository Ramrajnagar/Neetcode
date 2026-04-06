class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n; i++){
            adj.add(new ArrayList<>());

        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }
        boolean[] visited= new boolean  [n];
        int component=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                component++;
                dfs(i,adj,visited);

            }
        }
        return component;
        


    }
    private void dfs(int node , List<List<Integer>> adj, boolean[] visited){
        visited[node]= true;
        for(int nbr: adj.get(node)){
            if(!visited[nbr]){
                dfs(nbr,adj,visited);
            }
        }
    }
}
