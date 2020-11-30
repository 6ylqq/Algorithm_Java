import java.util.Arrays;

class NumArray{
    private int[] sums;
    
    public NumArray(int[] nums){
        //注意，这里的长度要设为length+1，因为sum[i]表示的是0-i-1的和
        sums=new int[nums.length+1];
        for (int i = 1; i < nums.length-1; i++) {
            sums[i]=sums[i-1]+nums[i-1];
        }
    }

    public int sumRage(int i,int j){
        return sums[j+1]-sums[i];
    }

}

/**
 * @author ylqq
 */
public class DynamicProgramming {
    /**
     * Climbing Stairs
     * */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }


    /**
     * 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
     * */
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int num : nums) {
            int cur = Math.max(pre2 + num, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    /**
     * 求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
     * */
    public int minPathSum(int[][] grid) {
        int[] dp=new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j==0){
                    //只能从上面走下来,这里的dp[j]是上一行的dp路径最小值
                    dp[j]=dp[j];
                }else if (i==0){
                    //只能从左边走
                    dp[j]=dp[j-1];
                }else {
                    dp[j]=Math.min(dp[j-1],dp[j]);
                }
                dp[j]+=grid[i][j];
            }
        }
        return dp[grid[0].length-1];
    }

    /**
     * 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
     * */
    public int uniquePaths(int m, int n){
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }


}
