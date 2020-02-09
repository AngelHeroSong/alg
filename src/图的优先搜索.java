import java.util.LinkedList;
import java.util.Queue;


public class 图的优先搜索 {
    class Graph {
        private int v;
        private LinkedList<Integer> adj[];

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
                for (int j = 0; j < adj[i].size(); i++) {
                    Integer w = adj[i].get(j);
                    if (!visited[w]) {
                        pre[w] = i;
                        if (w == t) {
                            print(pre, s, t);
                            return;
                        }
                    }
                    visited[w] = true;
                    queue.add(w);

                }
            }
        }

        private void print(int[] pre, int s, int t) {//递归打印s->t的路径
            if (pre[s] != -1 && t != s) {
                print(pre, s, pre[t]);
            }
            System.out.println(t + " ");
        }
    }
}
