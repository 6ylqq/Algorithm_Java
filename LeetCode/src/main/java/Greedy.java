class MaxProfit {
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
}
