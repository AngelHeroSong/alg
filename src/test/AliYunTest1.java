package test;

import java.util.HashMap;

public class AliYunTest1 {
    boolean match(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<>();

        String[] strs = str.split(" ");

        if (strs.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            boolean isHaveKey = map.containsKey(pattern.charAt(i));
            boolean isHaveValue = map.containsValue(strs[i]);
            String value = map.get(pattern.charAt(i));
            if (isHaveKey) {
                if (!strs[i].equals(value)) return false;
            } else {
                if (isHaveValue)return false;
                map.put(pattern.charAt(i),strs[i]);

            }
        }

        for (Character key :map.keySet()){
            String value = map.get(key);
            System.out.println(key+" "+value);
        }

        return true;
    }

    public static void main(String[] args) {
        AliYunTest1 aliYunTest1 = new AliYunTest1();

        System.out.println(aliYunTest1.match("abbab","杭州 北京 北京 杭州 北京"));
    }
}
