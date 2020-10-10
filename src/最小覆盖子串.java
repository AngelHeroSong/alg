import java.util.HashMap;

/**
 * @author srr
 * @date 2020/8/6 17:02
 */
public class 最小覆盖子串 {
    class Solution {
        public String minWindow(String s, String t) {

            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> needs = new HashMap<>();
            for (Character c:t.toCharArray()){
                Integer value = needs.getOrDefault(c, 0);
                needs.put(c,value++);
            }

            int left = 0,right = 0;
            int valid = 0;
            int start=0,len = Integer.MAX_VALUE;
            while(right<s.length()){
                //

            }
            return null;
    }}
}
