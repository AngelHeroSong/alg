package easy;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0;i<prices.length-1;i++){
            for (int j = i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    maxProfit = prices[j] - prices[i]>maxProfit?prices[j] - prices[i]:maxProfit;
                }
            }
        }
        return maxProfit;
    }
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0;i<prices.length;i++){
           minPrice = prices[i]<minPrice?prices[i]:minPrice;
           maxProfit = prices[i]-minPrice>maxProfit?prices[i]-minPrice:maxProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices= new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit.maxProfit2(prices));
    }
}
