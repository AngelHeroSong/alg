package test;

import java.util.HashMap;

public class 有序数组重复元素出现的次数 {


    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        count(new String[]{"abc", "ack", "abc", "abb", "bbb"});

        for (String key : map.keySet()) {

            System.out.println(key + ":" + map.get(key));
        }


    }

    public static void count(String[] strs) {
        for (int i = 0; i < strs.length; i++) {

            if (map.containsKey(strs[i])) {
                Integer count = map.get(strs[i]);
                map.put(strs[i], count + 1);
            } else {
                map.put(strs[i], 1);
            }
        }
    }
}
