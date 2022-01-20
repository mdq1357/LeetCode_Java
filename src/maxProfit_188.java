public class maxProfit_188 {

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(2,prices));
    }
    //买卖股票的最佳时机 IV 最难
    //给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int k, int[] prices) {

        int n=prices.length;

        if(n==0){
            return 0;
        }

        if(k>n/2){
            return infinity(prices);   //无约束，相当于k=k-1
        }

        int[][][] dp=new int[n][k+1][2];        //**定义数组时，第二栏的长度是max_k + 1 */

        //如果k<=n/2
        for(int k0=k;k0>=1;k0--){
            dp[0][k0][0]=0;
            dp[0][k0][1]=-prices[0];
        }

        /**这里要不要说明k0=0的情况 */
        //当k0=0时
        // for(int i=0;i<n;i++){
        //     dp[i][0][0]=0;
        //     dp[i][0][1]=Integer.MIN_VALUE;
        // }

        for(int i=1;i<n;i++){
            for(int k0=k;k0>=1;k0--){
                dp[i][k0][0]=Math.max(dp[i-1][k0][0],dp[i-1][k0][1]+prices[i]);
                dp[i][k0][1]=Math.max(dp[i-1][k0][1],dp[i-1][k0-1][0]-prices[i]);
            }
        }

        return dp[n-1][k][0];

    }

    public static int infinity(int[] prices){
        //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

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
