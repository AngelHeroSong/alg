//给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。 
//
// 返回这两个区间列表的交集。 
//
// （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间
//。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。） 
//
// 
//
// 示例： 
//
// 
//
// 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length < 1000 
// 0 <= B.length < 1000 
// 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9 
// 
// Related Topics 双指针 
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if (A.length == 0 || B.length == 0 ){
            return new int[0][2];
        }

        int i=0,j=0;
        List<int[]> res = new ArrayList<>();

        while (i<A.length && j<B.length){
            int a1=A[i][0],a2=A[i][1];
            int b1=B[j][0],b2=B[j][1];
            if (b1<=a2&&a1<=b2){
                int[] c = new int[2];
                c[0] = Math.max(a1,b1);
                c[1] = Math.min(a2,b2);
                res.add(c);
            }
            if (a2>b2){
                j++;
            }else{
                i++;
            }
        }


          return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
