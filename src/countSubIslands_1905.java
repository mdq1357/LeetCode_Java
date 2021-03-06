public class countSubIslands_1905 {
    public static void main(String[] args) {
       int[][]  grid1={
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}};
        int[][] grid2={
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}};
        //[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]
//        [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]
        //[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//        [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]

        System.out.println(countSubIslands(grid1,grid2));

    }
    //统计子岛屿
    //给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
    //
    //如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。
    //
    //请你返回 grid2 中 子岛屿 的 数目 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/count-sub-islands
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        //1为陆地，0为海水
        int m=grid1.length,n=grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1&&grid1[i][j]==0)       //如果grid2中岛屿的一部分不可能是grid1的子岛屿，那么令整个岛屿为海水
                    dfs(grid2,i,j,m,n);
            }
        }

        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1)
                    res++;
                dfs(grid2,i,j,m,n);
            }
        }
        return res;
    }

    public static void dfs(int[][] grid,int i,int j,int m,int n){
        if(i<0||j<0||i>=m||j>=n) return;
        if(grid[i][j]==0) return;

        grid[i][j]=0;

        dfs(grid,i+1,j,m,n);
        dfs(grid,i-1,j,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i,j-1,m,n);
    }
}
