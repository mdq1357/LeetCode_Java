public class maxProfit_123 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    //买卖股票的最佳时机2 k=2
    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int maxProfit(int[] prices) {

        //之前的情况都和 k 的关系不太大。要么 k 是正无穷，状态转移和 k 没关系了；要么 k = 1，跟 k = 0 这个 base case 挨得近，最后也没有存在感。
        //这道题考虑k的影响，需要穷举n*max_k*2种情况

        // int max_k=2;        //[0]  [1]  [2]
        // int n=prices.length;
        // int[][][] dp=new int[n][max_k+1][2];

        // //base case
        // for(int k=1;k<=max_k;k++){
        //     dp[0][k][0]=0;
        //     dp[0][k][1]=-prices[0];
        // }

        // for(int i=1;i<n;i++){
        //     for(int k=max_k;k>=1;k--){
        //         dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
        //         dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
        //     }
        // }

        // return dp[n-1][max_k][0];


        //****** 下面是空间复杂度的优化*/
        //首先列出k分别取1和2的状态方程
        // dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
        // dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][-1][0]-prices[i])=Math.max(dp[i-1][1][1],-prices[i]);     //*** k为负数时应该简化***
        // dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);
        // dp[i][2][1]=Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);


        //下面是优化后代码

        int dpi10=0;
        int dpi11=-prices[0];
        int dpi20=0;
        int dpi21=-prices[0];

        // int a=0;
        // int b=-prices[0];
        // int c=0;
        // int d=-prices[0];


        int n=prices.length;

        for(int i=1;i<n;i++){
            dpi10=Math.max(dpi10,dpi11+prices[i]);
            dpi11=Math.max(dpi11,-prices[i]);
            dpi20=Math.max(dpi20,dpi21+prices[i]);
            dpi21=Math.max(dpi21,dpi10-prices[i]);

            // a=Math.max(a,b+prices[i]);
            // b=Math.max(b,-prices[i]);
            // c=Math.max(c,d+prices[i]);
            // d=Math.max(d,a-prices[i]);
        }
        return dpi20;
    }
}
