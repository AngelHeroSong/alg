package sort;

public class MergeSort {
    public int[] mergeSort(int nums[]){
        int left = 0;
        int right = nums.length-1;
        int[] temp = new int[nums.length];
        sort(nums,left,right,temp);
        return nums;
    }
    public void mergeSort(int[] nums,int left,int right,int[] temp){
        if (left<right){
            int mid  = (left+right)/2;
            mergeSort(nums,left,mid,temp);
            mergeSort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }

    }
    public void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = nums[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = nums[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            nums[left++] = temp[t++];
        }
        System.out.println("temp: ");
        for (int te : temp){
            System.out.print(te+" ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,4,7,5,1,3,2,6};
        MergeSort mergeSort  = new MergeSort();
         nums = mergeSort.mergeSort(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }

    /**
     * 练习
     * @param nums
     * @param lo
     * @param hi
     * @param temp
     */
    void sort(int[] nums,int lo,int hi,int[] temp){

        if (lo<hi){
            int mid = lo + (hi - lo)/2;
            sort(nums,lo,mid,temp);
            sort(nums,mid+1,hi,temp);
            merge1(nums,lo,mid,hi,temp);
        }

    }
    void merge1(int[] nums,int lo,int mid,int hi,int[] temp){
        int i = lo;
        int j = mid+1;
        int t = 0;
        while(i<=mid&&j<=hi){
            if(nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }


        while(i<=mid){
            temp[t++] = nums[i++];
        }
        while(j<=hi){
            temp[t++] = nums[j++];
        }

        t=0;

        while(lo<=hi){
            nums[lo++] = temp[t++];
        }

        System.out.println("temp: ");
        for (int te : temp){
            System.out.print(te+" ");
        }
        System.out.print("\n");
    }

}
