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

    static Map<TreeNode,Integer> memo=new HashMap<>();
    public static int rob(TreeNode root) {
        if(root==null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        //抢当前节点，然后找下下个节点
        int do_it= root.val +(
                root.left==null? 0 : rob(root.left.left)+rob(root.left.right)
                )+(
                root.right==null? 0 : rob(root.right.left)+rob(root.right.right)
                );
        //不抢当前节点，找子节点
        int not_do=rob(root.left)+rob(root.right);

        int res=Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }

    public class TreeNode {
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
