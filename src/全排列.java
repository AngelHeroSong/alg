import java.util.LinkedList;
import java.util.List;

/**
 * @author srr
 * @date 2020/8/5 16:04
 */
public class 全排列 {
    class Solution {

        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {

            LinkedList<Integer> track = new LinkedList();
            backTrack(nums, track);
            return res;
        }

        public void backTrack(int[] nums, LinkedList<Integer> track) {
            if (nums.length == track.size()) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i : nums) {
                if (track.contains(i)) {
                    continue;
                }

                track.add(i);
                backTrack(nums, track);
                track.removeLast();
            }


        }


    }
}
