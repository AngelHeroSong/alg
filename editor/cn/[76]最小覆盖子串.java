//给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 
//
// 示例： 
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC" 
//
// 
//
// 提示： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 779 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }

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
//leetcode submit region end(Prohibit modification and deletion)
