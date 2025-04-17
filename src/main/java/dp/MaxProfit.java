package dp;


/**
 * 股票买卖最佳时机
 */
public class MaxProfit {

    public static void main(String[] args) {

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices,2));
    }

    public static int maxProfit(int[] prices, int fee) {

        // 交易i次，扣掉一次购买和交易费最好的情况
        int prepar = -prices[0] - fee;
        int done = 0;

        for (int i= 0;i < prices.length;i++){
            done = Math.max(done,prepar + prices[i]);
            prepar = Math.max(prepar, done - prices[i] - fee);
        }

        return done;
    }
}
