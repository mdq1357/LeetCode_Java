public class maxProfix_714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices,2));
    }

    //买卖股票的最佳机会含手续费
    //给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
    //
    //你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    //
    //返回获得利润的最大值。
    //
    //注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int[] prices, int fee) {

        // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);

        int n=prices.length;
        int dpi0=0;
        int dpi1=-prices[0]-fee;

        for(int i=1;i<n;i++){
            dpi0=Math.max(dpi0,dpi1+prices[i]);
            dpi1=Math.max(dpi1,dpi0-prices[i]-fee);
        }

        return dpi0;

    }
}
