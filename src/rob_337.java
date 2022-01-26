import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class rob_337 {
    public static void main(String[] args) {

    }
    //打家劫舍3
    //在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
    //
    //计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/house-robber-iii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**法一 */
    static Map<TreeNode,Integer> memo=new HashMap<>();
    public static int rob(TreeNode root) {
        if(root==null) return 0;
        if(memo.containsKey(root)) return memo.get(root);

        int do_it=
                root.val +(
                        root.left==null? 0 : rob(root.left.left)+rob(root.left.right)
                )+(
                        root.right==null? 0 : rob(root.right.left)+rob(root.right.right)
                );
        int not_do=rob(root.left)+rob(root.right);

        int res=Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }

    /**法二 */
//    public static int rob(TreeNode root) {
//        int[] res=dp(root);
//        return Math.max(res[0],res[1]);
//    }
//
//    public static int[] dp(TreeNode root){ //res[0]代表不抢的结果，res[1]代表抢的结果
//        if(root==null) return new int[]{0,0};
//        int[] rob_left=dp(root.left);
//        int[] rob_right=dp(root.right);
//        //抢
//        int do_it=root.val+rob_left[0]+rob_right[0];
//        //不抢
//        int not_do=Math.max(rob_left[0],rob_left[1])+Math.max(rob_right[0],rob_right[1]);
//        return new int[]{not_do,do_it};
//    }

    //TreeNode说明
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
}
