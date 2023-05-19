class Solution {
    
    static boolean bfs(int[][] arr,int source,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[source] = 1;
        while(!q.isEmpty()){
        int node = q.poll();

        for(int i=0;i<arr[node].length;i++){
            if(color[arr[node][i]] == -1){
            color[arr[node][i]] = 1-color[node];
            q.add(arr[node][i]);
            }else if(color[arr[node][i]] == color[node]){
            return false; 
            }
        }
        }
        return true; 
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
        color[i] = -1;
        }

        for(int i=0;i<color.length;i++){
        if(color[i] == -1){
            if(!bfs(graph,i,color)){
            return false;
            }
        }
        }
        return true;
    }
}