import java.util.HashSet;

public class numDistinctIslands_694 {
    public static void main(String[] args) {
        int[][] grid={
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };
        System.out.println(numDistinctislands(grid));
    }

    public static int numDistinctislands(int[][] grid){
        //1为陆地，0为海水
        int m=grid.length,n=grid[0].length;
        HashSet<String> islands=new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    dfs(grid,i,j,sb,666);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    public static void dfs(int[][] grid,int i,int j,StringBuilder sb,int dir){
        int m=grid.length,n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0) return;

        grid[i][j]=0;
        sb.append(dir).append(",");

        dfs(grid,i+1,j,sb,1);
        dfs(grid,i-1,j,sb,2);
        dfs(grid,i,j+1,sb,3);
        dfs(grid,i,j-1,sb,4);

        sb.append(-dir).append(",");
    }
}