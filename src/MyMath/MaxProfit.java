package MyMath;

/**
 * 题意是给出一个数组代表每天的股票金额，让你在最多买卖一次的情况下算出最大的收益额，
 * 最简单的就是模拟即可，每次记录当前值减去最小值的差值，与上一次的进行比较然后更新最大值即可
 */
public class MaxProfit {

    public int maxProfit(int[] prices)
    {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0;i<prices.length;i++)
        {
            if(prices[i] < minPrice) minPrice = prices[i];
            int delta = prices[i] - minPrice;
            if(delta > max) max = delta;
        }

        return max;

    }
}
