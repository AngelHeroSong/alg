package easy;

public class MajorityElement {
   /* public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0;i<nums.length;i++){
            if(Objects.nonNull(map.get(nums[i]))){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(Integer key:map.keySet()){
            if(map.get(key)>nums.length/3){
                list.add(map.get(key));
            }
        }
        return list;

    }*/
}
