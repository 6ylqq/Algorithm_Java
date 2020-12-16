public class DFS {
    /**
     * 找出最大的联通面积
     * leetcode 695
     * */
    private int m,n;
    private int[][] direction={{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null||grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int maxArea=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea=Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c]=0;
        int area=1;
        for (int[] ints : direction) {
            area+=dfs(grid,r+ints[0],c+ints[1]);
        }
        return area;
    }

    /**
     * leetcode200
     * 矩阵中的连通分量数目
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     * */
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int islandsNum=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]!='0'){
                    dfs(grid,i,j);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }
    private void dfs(char[][] grid,int i,int j){
        if (i<0||i>=m||j<0||j>=n||grid[i][j]=='0'){
            return;
        }
        //置为0表示已经包括计算，即对已经遍历过的节点进行标记
        grid[i][j]=0;
        for (int[] ints : direction) {
            dfs(grid,i+ints[0],j+ints[1]);
        }
    }


    /**
     * leetcode 547
     * 班上有N名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B的朋友，B 是 C的朋友，那么我们可以认为 A 也是 C的朋友。所谓的朋友圈，是指所有朋友的集合。
     * 给定一个N * N的矩阵M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     */
    public int findCircleNum(int[][] M) {
        int count=0;
        //找一边三角形的1的个数
        for (int i = 0; i < M.length; i++) {
            for (int j = M[i].length; j > i; j--) {
                if (M[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

}
