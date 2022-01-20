public class maxProfit_309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    //买卖股票的最佳时期含冷冻期
    //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    //
    //设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    //
    //你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int[] prices) {

        // //k是无穷大，所以k=k-1，状态方程中去掉k
        // //下面是基础状态方程
        // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);

        // //融合冷冻期的状态方程
        // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
        // dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);

        //base case
        // dp[-1][0]=0;
        // dp[-1][1]=-infinity;
        // dp[0][0]=0;
        // dp[0][1]=-prices[0];
        // dp[1][0]=0;


        int n=prices.length;
        int dpi0=0;
        int dpi1=-prices[0];
        int dpi0pre=0;

        for(int i=1;i<n;i++){
            int tmp=dpi0;       //存放当前i对应的dp[i-1]
            if(i==1){
                dpi0=Math.max(dpi0,dpi1+prices[i]);     //生成当前dp[i]
                dpi1=Math.max(dpi1,dpi0-prices[i]);
            }else{
                dpi0=Math.max(dpi0,dpi1+prices[i]);
                dpi1=Math.max(dpi1,dpi0pre-prices[i]);
            }
            dpi0pre=tmp;        //对于下一循环的i，dpi0pre代表dp[i-2]
        }

        return dpi0;

    }
}
