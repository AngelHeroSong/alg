package sort;

public class QuickSort {
    public void quickSort(int[] nums,int start,int end){
        int i,j,temp;
        if (start>end){
            return;
        }
        i = start;
        j = end;
        temp = nums[start];

        while(i<j){
            while(temp<=nums[j]&&i<j){
                j--;
            }
            while(temp>=nums[i]&&i<j){
                i++;
            }
            if (i<j){
                int z = nums[i];
                int y =nums[j];
                nums[j] = z;
                nums[i] = y;
            }
        }
        nums[start] = nums[i];
        nums[i] = temp;

        quickSort(nums,start,j-1);
        quickSort(nums,j+1,end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,7,2,4,7,62};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums,0,nums.length-1);
        for (int num : nums){
            System.out.println(num);
        }
    }

    /**
     * 练习
     * @param nums
     * @param start
     * @param end
     */
    void sort(int[] nums,int start,int end){

        if(start>end){
            return;
        }
        int i,j,temp;
        i=start;
        j=end;
        temp = nums[start];

        while(i<j){
            while(temp<=nums[j]&&i<j){
                j--;
            }
            while(temp>=nums[i]&&i<j){
                i++;
            }

            if(i<j){
                int x = nums[j];
                int y = nums[i];

                nums[j] = y;
                nums[i] = x;
            }
        }
        nums[start] = nums[i];
        nums[i] = temp;

        sort(nums,start,j-1);
        sort(nums,j+1,end);
    }
}
