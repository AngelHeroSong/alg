import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author srr
 * @date 2020/8/5 15:02
 */
public class 打开转盘锁 {

    class Solution {
        public int openLock(String[] deadends, String target) {

            HashSet<String> deadendsSet = new HashSet<>();
            for (String dead:deadends) deadendsSet.add(dead);
            HashSet<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer("0000");
            int step = 0;
            while(q!=null && q.size()>0){
                int sz = q.size();
                for (int i = 0;i<sz;i++){
                    String poll = q.poll();
                    if (deadendsSet.contains(poll)) continue;
                    if (target.equals(poll)) return step;

                    for (int j = 0; j<4;j++){
                        String down = down(poll, j);
                        if (!visited.contains(down)){
                            q.offer(down);
                            visited.add(down);
                        }
                        String up = up(poll, j);
                        if (!visited.contains(up)){
                            q.offer(up);
                            visited.add(up);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        public String down(String s,int index){
            char[] chars = s.toCharArray();
            if (chars[index] == '0'){
                chars[index] = '9';
            }else{
                chars[index] -=1;
            }
            return new String(chars);
        }

        public String up(String s,int index){
            char[] chars = s.toCharArray();
            if (chars[index] == '9'){
                chars[index] = '0';
            }else{
                chars[index]+=1;
            }
            return new String(chars);
        }

    }
}
