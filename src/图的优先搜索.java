import java.util.LinkedList;
import java.util.Queue;


/**
 * 深度遍历搜索
 * 广度遍历搜索
 */
public class 图的优先搜索 {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(4,5);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        System.out.println("开始广度优先搜索");
        graph.bfs(0,7);
        System.out.println("开始深度优先搜索");
        graph.dfs(0,7);

    }
    static class Graph {
        private int v;
        private LinkedList<Integer> adj[];

        //在深度优先遍历中用到，当我们已经找到终止顶点 t 之后，我们就不再递归地继续查找了。
        boolean found = false;

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }


        public void bfs(int s, int t) {
            if (s == t) {
                return;
            }
            boolean[] visited = new boolean[v];
            visited[s] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            int[] pre = new int[v];

            for (int i = 0; i < v; i++) {
                pre[i] = -1;
            }
            while (queue.size() != 0) {
                Integer i = queue.poll();
                for (int j = 0; j < adj[i].size(); j++) {
                    Integer w = adj[i].get(j);
                    if (!visited[w]) {
                        pre[w] = i;
                        if (w == t) {
                            print(pre, s, t);
                            return;
                        }
                        visited[w] = true;
                        queue.add(w);
                    }
                }
            }
        }

        private void print(int[] pre, int s, int t) {//递归打印s->t的路径
            if (pre[t] != -1 && t != s) {
                print(pre, s, pre[t]);
            }
            System.out.println(t + " ");
        }

        /**
         * 深度优先遍历
         * @param s
         * @param t
         */
        public void dfs(int s, int t) {
            found = false;
            boolean[] visited = new boolean[v];
            int[] pre = new int[v];
            for (int i = 0; i < v; i++) {
                pre[i] = -1;
            }
            recurDfs(s, t, visited, pre);
            print(pre,s,t);

        }

        private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
            if (found) {
                return;
            }
            visited[w] = true;
            if (w == t) {
                found = true;
                return;
            }

            for (int i = 0; i < adj[w].size(); i++) {
                Integer q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    recurDfs(q, t, visited, prev);
                }

            }

        }
    }
}
