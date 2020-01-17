import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int count = 1;
        int major=nums[0];
        for(int i = 1 ;i <nums.length;i++){
            if (nums[i] == major){
                count++;
            }else{
                count--;
                if (count == 0){
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }
    public List<Integer> majorityElement2(int[] nums) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        if (nums.length<=0){
            return list;
        }
        for (int i = 0; i<length;i++){
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }
        for (Integer key:hashMap.keySet()){
            if (hashMap.get(key)>length/3){
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = new int[]{1,3,3,5,5,5,2,3};
        List<Integer> list = majorityElement.majorityElement2(nums);
        for (Integer li:list){
            System.out.println(li);
        }

    }
}
