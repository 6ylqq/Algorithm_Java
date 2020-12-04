import org.junit.jupiter.api.Test;

/**
 * 求最大子数组之和
 * 根据数组的最后一个元素arr[n-1]和最大字数组的关系进行求解
 *
 * @author ylqq
 */
public class MaxSubArray {
    public static int maxSubArray(int[] arr) {
        //n个数字数组的最大子数组和
        int nAll = arr[0];

        //包含最后一个元素的子数组的最大和
        int nEnd = arr[0];

        for (int i : arr) {
            nEnd = Math.max(nEnd + i, i);
            nAll = Math.max(nEnd, nAll);
        }
        return nAll;
    }

    public int maxSubArrayGreedy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int preNums = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            preNums = preNums > preNums + nums[i] ? nums[i] : preNums + nums[i];
            max = Math.max(preNums, max);
        }
        return max;

    }

    @Test
    public void test() {
        int[] arr = {1, 2};
        System.out.println(maxSubArray(arr));
    }

}
