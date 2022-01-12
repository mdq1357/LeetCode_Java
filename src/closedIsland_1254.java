import java.util.Arrays;

public class closedIsland_1254 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(closedIsland(grid));
    }
    //统计封闭岛屿的数目
    //有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
    //
    //我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
    //
    //如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
    //
    //请返回封闭岛屿的数目。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/number-of-closed-islands
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int closedIsland(int[][] grid) {
        int res=0;
        int m=grid.length,n=grid[0].length;

        //‘0’为陆地，'1'为海水
        for(int j=0;j<n;j++){
            dfs(grid,0,j,m,n);      //淹没第0行和最后一行
            dfs(grid,m-1,j,m,n);
        }

        for(int i=0;i<m;i++){
            dfs(grid,i,0,m,n);      //淹没第0列和最后一列
            dfs(grid,i,n-1,m,n);
        }


        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==0){
                    res++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] grid,int i,int j,int m,int n){
        if(i<0||j<0||i>=m||j>=n) return;        //越界
        if(grid[i][j]==1) return;     //已是海水

        grid[i][j]=1;     //置为海水

        dfs(grid,i+1,j,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i,j-1,m,n);

    }
}
