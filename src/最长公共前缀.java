public class 最长公共前缀 {
    public static void main(String[] args) {
        最长公共前缀 最长公共前缀 = new 最长公共前缀();
        System.out.println(最长公共前缀.longestCommonPrefix(new String[]{"abc", "ab", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
