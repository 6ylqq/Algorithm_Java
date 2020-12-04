import java.util.Random;

/**
 * @author ylqq
 */
public class MaxMin {
    static int Max;
    static int Min;

    public static void getMaxAndMin(int[] arr) {
        Max = arr[0];
        Min = arr[0];
        if (arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i += 2) {

            //比较最后两位
            if (i + 1 > arr.length) {
                if (arr[i] > Max) {
                    Max = arr[i];
                }
                if (arr[i] < Min) {
                    Min = arr[i];
                }
            }

            if (arr[i] > arr[i + 1]) {
                if (Max < arr[i]) {
                    Max = arr[i];
                }
                if (Min < arr[i + 1]) {
                    Min = arr[i + 1];
                }
            }

            //取相邻的两个数比较，大的和Max比，小的和Min比
            if (arr[i] > arr[i + 1]) {
                if (Max < arr[i]) {
                    Max = arr[i];
                }
                if (Min < arr[i + 1]) {
                    Min = arr[i + 1];
                }
            }

            if (arr[i] < arr[i + 1]) {
                if (Max < arr[i + 1]) {
                    Max = arr[i];
                }
                if (Min > arr[i]) {
                    Min = arr[i];
                }
            }

        }
    }

    public static void main(String[] args) {
        //新建一个随机数组测试
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            int num = random.nextInt();
            a[i] = num;
        }
        getMaxAndMin(a);

        System.out.println("max=" + Max);
        System.out.println("min=" + Min);
    }
}
