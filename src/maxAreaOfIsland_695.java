public class maxAreaOfIsland_695 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                        };
        System.out.println(maxAreaOfIsland(grid));
    }
    //岛屿的最大面积
    //给你一个大小为 m x n 的二进制矩阵 grid 。
    //
    //岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
    //
    //岛屿的面积是岛上值为 1 的单元格的数目。
    //
    //计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/max-area-of-island
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static int maxAreaOfIsland(int[][] grid) {
        //1为陆地，0为海水
        int m=grid.length,n=grid[0].length;
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res=Math.max(res,dfs(grid,i,j,m,n));
                }
            }
        }

        return res;

    }

    public static int dfs(int[][] grid,int i,int j,int m,int n){

        if(i<0||j<0||i>=m||j>=n) return 0;      //return
        if(grid[i][j]==0) return 0;

        grid[i][j]=0;

        return  dfs(grid,i+1,j,m,n)+            //return的表达
                dfs(grid,i-1,j,m,n)+
                dfs(grid,i,j+1,m,n)+
                dfs(grid,i,j-1,m,n)+1;      //重要，要+1
    }
}
