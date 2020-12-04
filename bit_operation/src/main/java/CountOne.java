/**
 * @author ylqq
 */
public class CountOne {
    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            //这里使用与运算来判断最后一位是否为1
            if ((n & 1) == 1) {
                count++;
            }
            //右移，丢弃掉最后一位，倒数第二位变成倒数第一位
            n >>= 1;
        }
        return count;
    }

}
