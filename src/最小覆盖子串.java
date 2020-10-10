import java.util.HashMap;

/**
 * @author srr
 * @date 2020/8/6 17:02
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
    }
    static class Solution {

        public String minWindow(String s, String t) {

            HashMap<Character,Integer> needs = new HashMap();
            HashMap<Character,Integer> window = new HashMap();

            for (char c:t.toCharArray()){
                needs.put(c,needs.getOrDefault(c,0)+1);
            }
            int left =0,right = 0;
            int valid = 0;
            int start = 0,len = Integer.MAX_VALUE;
            while (right<s.length()){
                char c = s.charAt(right);
                right++;
                if(needs.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    if(window.get(c) == needs.get(c)){
                        valid ++;
                    }
                }
                while(valid == needs.size()){
                    if(right - left <len){
                        start = left;
                        len = right -left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (needs.containsKey(d)){
                        if(window.get(d) == needs.get(d)){
                            valid --;
                        }
                        window.put(d,window.getOrDefault(d,0)-1);
                    }

                }
            }

            return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
        }
    }
}
