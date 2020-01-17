import java.util.HashMap;

public class 罗马数字转整数 {
    public static void main(String[] args) {

        罗马数字转整数 a = new 罗马数字转整数();
        System.out.println(a.romanToInt("IVXL"));
    }
    public int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V" ,5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int len = s.length();
        int j = 0;
        for (int i = 0;i<len;){
           if (i+1<len && map.containsKey(s.substring(i,i+2))){
               j = j+map.get(s.substring(i,i+2));
               i = i+2;
           }else{
               j = j+map.get(s.substring(i,i+1));
               i++;

           }
        }
        return j;

    }
}
