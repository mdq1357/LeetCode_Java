public class maxProfit_122 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    //买卖股票的最佳时机2 k为无穷大
    //给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int[] prices) {
        // //一般的状态方程
        // dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
        // dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
        // //base case，需要的最早的值
        // dp[-1][][0]=0;
        // dp[-1][][1]=-infinity;
        // dp[][0][0]=0;
        // dp[][0][1]=-infinity;

        // //当k=正无穷时，就可以认为k=k-1
        // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        // dp[0][0]=0;
        // dp[0][1]=-prices[0];

        int n=prices.length;
        int dpi0=0;
        int dpi1=-prices[0];

        for(int i=1;i<n;i++){
            dpi0=Math.max(dpi0,dpi1+prices[i]);
            dpi1=Math.max(dpi1,dpi0-prices[i]);
        }

        return dpi0;


    }
}
