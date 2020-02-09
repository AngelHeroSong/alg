import java.util.LinkedList;

public class 拓扑排序 {
    class Graph {
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s 先于 t，边 s->t
            adj[s].add(t);
        }

        /**
         * Kahn算法
         */
        public void topoSortByKahn() {
            int[] inDegree = new int[v];//统计顶点的入度
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j);
                    inDegree[w]++;
                }
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < v; i++) {
                if (inDegree[i] == 0) {
                    queue.add(inDegree[i]);
                }
            }
            while (!queue.isEmpty()) {
                int i = queue.remove();
                System.out.println("->"+i);
                for (int j = 0; i < adj[i].size(); j++) {
                    int k = adj[i].get(j);
                    inDegree[k]--;
                    if (inDegree[k] == 0) {
                        queue.add(inDegree[k]);
                    }
                }
            }

        }


        /**
         * 深度优先遍历
         */
        public void topoSortByDFS() {
            LinkedList<Integer>[] inverseAdj = new LinkedList[v];
            //初始化逆邻接表
            for (int i = 0;i<v;i++){
                inverseAdj[i] = new LinkedList<>();
            }
            //将邻接表转成逆邻接表
            for (int i = 0;i<v;i++){
                for (int j = 0;j<adj[i].size();j++){
                    int w  = adj[i].get(j);
                    inverseAdj[w].add(i);

                }
            }

            boolean[] visited = new boolean[v];
            //深度优先遍历
            for (int i = 0 ;i<v;i++){
                if (!visited[i]){
                    visited[i] = true;
                    dfs(i,inverseAdj,visited);
                }

            }
        }

        private void dfs( int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited){
            for (int i=0;i<inverseAdj[i].size();i++){
                int w = inverseAdj[vertex].get(i);
                if (visited[w]){
                    continue;
                }
                visited[w] = true;
                dfs(w,inverseAdj,visited);
            }
            //先把所达的顶点都打印出来再打印自己
            System.out.println("->"+vertex);

        }
    }


}
