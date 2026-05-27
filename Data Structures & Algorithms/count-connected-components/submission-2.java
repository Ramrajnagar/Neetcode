class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        // initially every node have its own parents 
        for(int i=0;i<n; i++){
            parent[i]=i;
            rank[i]=1;
        }
        int components=n;

        for(int[]edge: edges){
            //if union is succesful ,we decresed the component by one
            components-= union(edge[0],edge[1],parent,rank);
        }
        return components;

    }
    //helper function to find the root parent 
    private int find(int node, int[] parent){
        if(parent[node]== node){
            return node;
        }
        return parent[node]=find(parent[node], parent);
    }
    // helper function to union two components
    private int union(int u, int v, int[] parent, int[] rank){
        int rootU= find(u, parent);
        int rootV= find(v,parent);
        if(rootU!=rootV){
            //check rank
            if(rank[rootU]>rank[rootV]){
                parent[rootV]=rootU;
            }else if(rank[rootU]<rank[rootV]){
                parent[rootU]=rootV;
            }else{
                parent[rootV]=rootU;
                rank[rootU]++;
            }
            return 1; //sucessfully merged
        }
        return 0;

    }
}
