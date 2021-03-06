public class rob_198 {
    public static void main(String[] args) {
        int[] nums={1,3,2,1};
        System.out.println(rob(nums));
    }
    //打家劫舍
    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/house-robber
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int[] dp=new int[n+2];      //dp[n-1]=dp[n]=dp[n+1]=0

    //     for(int i=n-1;i>=0;i--){
    //         dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
    //     }
    //     return dp[0];

    // }

    /**优化空间复杂度 */
    public static int rob(int[] nums) {
        int n=nums.length;
        // int[] dp=new int[n+2];      //dp[n-1]=dp[n]=dp[n+1]=0
        int dp0;
        int dp1=0,dp2=0;

        for(int i=n-1;i>=0;i--){
            dp0=Math.max(dp1,nums[i]+dp2);
            dp2=dp1;
            dp1=dp0;
        }
        return dp1;

    }
}
