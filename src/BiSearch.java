public class BiSearch {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8};
        BiSearch biSearch = new BiSearch();
        System.out.println(biSearch.biSearch(a,0));
    }
    public int biSearch(int[] array,int a){
        int start = 0;
        int end = array.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if (array[mid]==a){
                return mid;
            }else if (array[mid]<a){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
