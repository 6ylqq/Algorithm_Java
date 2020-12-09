class MaxProfit {

    /**
     * leetcode605种花
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? flowerbed.length - 1 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                count++;
                flowerbed[i] = 1;
            }

        }

        return count >= n;

    }

    /**
     * 一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    /**
     * 可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length <= 2) {
            return true;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi && nums[hi - 1] <= nums[hi]) {
            hi--;
        }
        while (lo < hi && nums[lo] <= nums[lo + 1]) {
            lo++;
        }
        if (hi - lo > 1) {
            return false;
        }
        // hi - lo <= 1 时：
        // 除了nums[hi]其他都递增
        return lo == 0 || hi == nums.length - 1
                // 除了边界，其他都递增
                || nums[lo - 1] <= nums[lo + 1]
                // 除了nums[lo]其他都递增
                || nums[hi - 1] <= nums[hi + 1];
    }
}


/**
 * @author ylqq
 */
public class Greedy {

    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        int[] nums = {1, 1};
        greedy.nextPermutation(nums);
    }
    /**
     * 判断是否为子序列
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.toCharArray().length && j < t.toCharArray().length) {
            if (s.toCharArray()[i] == t.toCharArray()[j]) {
                i++;
            }
            j++;
        }
        return i == s.toCharArray().length;
    }

    /**
     * leetcode31 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须 原地 修改，只允许使用额外常数空间。
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1, j = nums.length - 2; i >= 0 && j >= 0; ) {
            if (nums[i] > nums[j]) {
                swap(nums, i, j);
                return;
            } else {
                j--;
            }
            if (j < 0) {
                i--;
                j=i-1;
            }
        }
        reserve(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reserve( int[] arr ){
        int i=0,j=arr.length-1;
        while(i!=j){
            swap(arr,i,j);
            ++i;
            --j;
        }
    }

}
