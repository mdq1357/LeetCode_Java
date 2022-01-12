//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/n-queens
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(3));
//        System.out.println(solveNQueens(1));
    }

    //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //
    //给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    //
    //每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/n-queens
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static List<List<String>> res=new ArrayList<>();       //结果集

    public static List<List<String>> solveNQueens(int n) {
        List<String> board=new ArrayList<>();       //一种可行解
        backtrack(board,0,n);
        return res;
    }
    //参数依次为：棋盘、当前行索引、总行数
    public static void backtrack(List<String> board,int r,int n){
        //判断是否到达结束条件
        if(r==n){
            res.add(new ArrayList<>(board));
            return;
        }

        for(int c=0;c<n;c++){
            if(isValid(board,r,c,n)){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<c;i++){
                    sb.append(".");
                }
                sb.append("Q");
                for(int i=0;i<(n-(c+1));i++){
                    sb.append(".");
                }
                board.add(sb.toString());

                //决策下一行
                backtrack(board,r+1,n);
                //撤销决策
                board.remove(board.size()-1);
            }
        }

    }

    public static boolean isValid(List<String> board,int r,int c,int n){
        for(int r1=0;r1<r;r1++){
            char cur=board.get(r1).charAt(c);
            if(cur=='Q'){
                return false;
            }
        }

        int r1=r-1,c1=c-1;
        while(r1>=0&&c1>=0){
            char cur=board.get(r1).charAt(c1);
            if(cur=='Q'){
                return false;
            }
            r1--;
            c1--;
        }

        int r2=r-1,c2=c+1;
        while(r2>=0&&c2<n){
            char cur=board.get(r2).charAt(c2);
            if(cur=='Q'){
                return false;
            }
            r2--;
            c2++;
        }

        return true;
    }

}