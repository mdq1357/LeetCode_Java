public class maxProfit_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    //买卖股票的最佳时机 k=1
    //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //
    //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int[] prices) {
        //        //一般的状态方程
        //        dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
        //        dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
        //        //base case，需要的最早的值
        //        dp[-1][][0]=0;
        //        dp[-1][][1]=-infinity;
        //        dp[][0][0]=0;
        //        dp[][0][1]=-infinity;

        // //k=1时
        // dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
        // dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);       //其中dp[i-1][0][0]=0 所以dp[i-1][0][0]-prices[i]=-prices[i] 此时方程中所有k都为1，不造成影响
        // //简化状态方程
        // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        //base case
        // dp[-1][0]=0;
        // dp[-1][1]=-infinity;

        ///////  正式解题

        // int n=prices.length;
        // int[][] dp=new int[n][2];

        // dp[0][0]=0;     //由状态方程和base case算得
        // dp[0][1]=-prices[0];

        // for(int i=1;i<n;i++){
        //     dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //     dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        // }
        // return dp[n-1][0];

        //优化空间复杂度版本
        int n=prices.length;
        int dpi0=0;
        int dpi1=-prices[0];

        for(int i=1;i<n;i++){
            dpi0=Math.max(dpi0,dpi1+prices[i]);
            dpi1=Math.max(dpi1,-prices[i]);
        }

        return dpi0;
    }
}
