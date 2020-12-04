/**
 * @author ylqq
 */
public class IsPower {
    public static boolean isPower(int n) {
        if (n < 1) {
            return false;
        }
        //从1开始不断的进行位移1位操作，直到n，相当于遍历，有点蠢吧
        int i = 1;
        while (i <= n) {
            if (i == n) {
                return true;
            }
            //乘2
            i <<= 1;
        }
        return false;
    }

    /**
     * 一个数是否是2的某次方——>二进制是否只有一位是1——>与n-1&结果是否为0
     * 注：位运算&，|（或），^（判等），~（取反）都是基于二进制的
     */
    public static boolean isPower2(int n) {
        if (n < 1) {
            return false;
        } else {
            int m = n & (n - 1);
            return m == 0;
        }
    }
}
