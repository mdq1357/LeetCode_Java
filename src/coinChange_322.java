//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/coin-change
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.Arrays;

public class coinChange_322 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {2},3));
    }

    //零钱兑换
    //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/coin-change
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int coinChange(int[] coins, int amount) {

        //需要dp数组
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);

        dp[0]=0;
        for(int i=1;i<=amount;i++){

            for(int coin:coins){
                if(i-coin<0) {
                    continue;
                }
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }

        return (dp[amount]==amount+1)?-1:dp[amount];

    }



}


