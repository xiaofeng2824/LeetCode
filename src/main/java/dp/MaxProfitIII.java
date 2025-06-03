package dp;

/**
 *  买卖股票的最佳时机  最多可以买卖两次股票
 */
public class MaxProfitIII {

    public static void main(String[] args) {

        int[] prices = {3,3,5,0,0,3,1,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
        //
    }


    // 超时
    public static  int maxProfit(int[] prices) {

        // 边界条件
        if (prices == null || prices.length < 2){
            return 0;
        }

        // 0 - i-1 范围收益最大的数组
        int n = prices.length;
        int[] dp1 = new int[n];

        int min = prices[0];
        for (int i=1;i<n;i++){
           min = Math.min(min,prices[i]);
           dp1[i] = Math.max(dp1[i-1],prices[i] - min);
        }

        // 在i位置上第二次卖出
        int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp2[i] = Math.max(dp2[i],dp1[j] + prices[i] - prices[j]);
            }
        }

        return  dp2[n-1];
    }


    public static  int maxProfit1(int[] prices) {

        // 边界条件
        if (prices == null || prices.length < 2){
            return 0;
        }

        // 0 - i-1 范围收益最大的数组
        int n = prices.length;
        int[] dp1 = new int[n];

        int min = prices[0];
        for (int i=1;i<n;i++){
             min = Math.min(min,prices[i]);
             dp1[i] = Math.max(dp1[i-1],prices[i] - min);
        }

        // 引入best 数组
        int[] best = new int[n];
        best[0] = dp1[0] - prices[0];
        for (int i = 1; i < n; i++) {
            best[i] = Math.max(best[i-1],dp1[i] - prices[i]);
        }

        // 在i位置上第二次卖出
        int maxProfile = 0;
       int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1],best[i]  + prices[i]);
            maxProfile = Math.max(maxProfile,dp2[i]);
        }
        return maxProfile;
    }

    // 所有逻辑都可以写在一个循环里
    public static  int maxProfit2(int[] prices) {

        // 边界条件
        if (prices == null || prices.length < 2){
            return 0;
        }

        // 0 - i-1 范围收益最大的数组
        int n = prices.length;
        int[] dp1 = new int[n];

        int min = prices[0];
        int[] best = new int[n];
        best[0] = dp1[0] - prices[0];
        int maxProfile = 0;
        int[] dp2 = new int[n];
        for (int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            dp1[i] = Math.max(dp1[i-1],prices[i] - min);
            best[i] = Math.max(best[i-1],dp1[i] - prices[i]);
            dp2[i] = Math.max(dp2[i-1],best[i]  + prices[i]);
            maxProfile = Math.max(maxProfile,dp2[i]);
        }
        return maxProfile;
    }


    // 空间压缩的版本
    public static  int maxProfit3(int[] prices) {

        // 边界条件
        if (prices == null || prices.length < 2){
            return 0;
        }

        // 0 - i-1 范围收益最大的数组
        int n = prices.length;
        int dppre = 0;
        int dp1 = 0;

        int min = prices[0];

        int bestpre = dppre - prices[0];
        int best = 0;

        int maxProfile = 0;

        for (int i=1;i<n;i++){
            min = Math.min(min,prices[i]);
            dp1 = Math.max(dppre,prices[i] - min);
            best = Math.max(bestpre,dp1 - prices[i]);
            maxProfile = Math.max(maxProfile,best + prices[i]);

            dppre = dp1;
            bestpre = best;
        }
        return maxProfile;
    }
}
