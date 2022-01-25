public class rob_213 {
    public static void main(String[] args) {
        int[] nums={2,3,2};
        System.out.println(rob(nums));
    }
    //打家劫舍2
    //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/house-robber-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int rob(int[] nums) {
        //首尾房间不能同时被抢，那么只可能有三种不同情况：要么都不被抢；要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢。

        int n=nums.length;
        int dp0,dp1=0,dp2=0;

        //特殊情况，首尾重合（只有一个元素）
        if(n==1){
            return nums[0];
        }

        /* 第一种，首尾都不抢 */
        for(int i=n-2;i>=1;i--){
            dp0=Math.max(dp1,nums[i]+dp2);
            dp2=dp1;
            dp1=dp0;
        }
        int res1=dp1;

        dp1=0;
        dp2=0;

        /* 第二种，首抢尾不抢 */
        for(int i=n-2;i>=0;i--){
            dp0=Math.max(dp1,nums[i]+dp2);
            dp2=dp1;
            dp1=dp0;
        }
        int res2=dp1;

        dp1=0;
        dp2=0;

        /* 第三种，首不抢尾抢 */
        for(int i=n-1;i>=1;i--){
            dp0=Math.max(dp1,nums[i]+dp2);
            dp2=dp1;
            dp1=dp0;
        }
        int res3=dp1;

        return Math.max(res1,Math.max(res2,res3));
    }
}
