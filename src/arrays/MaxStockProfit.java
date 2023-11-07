package arrays;

public class MaxStockProfit {

        public int maxProfit(int[] prices)
        {
            int n = prices.length;

            int minSoFar = Integer.MAX_VALUE;
            int maxProfit = Integer.MIN_VALUE;
            for(int i=0; i<n;i++) {
                minSoFar = Math.min(minSoFar, prices[i]);
                maxProfit = Math.max(maxProfit,prices[i] - minSoFar);
            }

            return maxProfit;
        }

}
