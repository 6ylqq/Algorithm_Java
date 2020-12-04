import java.util.Random;

/**
 * @author ylqq
 */
public class Sort {
    //选择排序
    public static void selectTest(int[] a) {
        int i;
        int j;
        //暂存数据，后面交换用到
        int temp = 0;
        //设置标签，判定是否需要调换数组元素,如果最小元素就在首位
        int flag = 0;
        int n = a.length;

        //外循环
        for (i = 0; i < n; i++) {
            temp = a[i];
            flag = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < temp) {
                    //记录最小数据在数组中的位置
                    flag = j;
                    temp = a[j];
                }
            }
            a[flag] = a[i];
            a[i] = temp;
        }
    }

    /**
     * 归并排序
     */
    public static void merge(int[] array, int p, int q, int r) {
        int j, k, n1, n2;
        n1 = p - q + 1;


    }

    /**
     * 希尔排序
     * 划分为小的子序列，然后进行插入排序
     */
    public static void shellSort(int[] array) {
        //希尔排序
        int gap = array.length;
        do {
            //增量每次减半
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                //将特定步长的当作一组进行排序
                for (int j = i + gap; j < array.length; j += gap) {
                    //这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
        } while (gap != 1);
    }


    public static void InsertSort(int[] a) {
        if (a != null) {
            for (int i = 1; i < a.length; i++) {
                int temp = a[i], j = i;
                while (j >= 1 && a[j - 1] > temp) {
                    //坐标前移，继续找到合适的位置
                    a[j] = a[j - 1];
                    --j;
                }
                //找到合适的位置，将temp加入
                a[j] = temp;
            }
        }
    }

    public static void BubbleSort(int[] array) {
        int i, j, temp;
        for (i = 0; i < array.length - 1; ++i) {
            for (j = array.length - 1; j > i; --j) {
                //如果小，则交换
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     */
    public static void QuickSort(int[] array, int low, int high) {
        int i, j, index;
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        //设置基准
        index = array[i];
        while (i != j) {
            //从右往左找，直到找到比index小的
            while (array[j] >= index && i < j) {
                j--;
            }
            //从左往右找，找到比index大的
            while (array[i] <= index && i < j) {
                i++;
            }
            //交换
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        //i，j相遇，相遇点与index交换
        array[low] = array[i];
        array[i] = index;

        //递归计算右边和左边
        QuickSort(array, low, i - 1);
        QuickSort(array, i + 1, high);
    }

    public static void main(String[] args) {

        //新建一个随机数组测试
        Random random = new Random();
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            int num = random.nextInt();
            a[i] = num;
        }

        long begin = System.currentTimeMillis();
        selectTest(a);
        long end = System.currentTimeMillis();
        System.out.println("执行时间为：" + (end - begin) + "ms");

        //BubbleSort(a);
        //QuickSort(a, 0, a.length - 1);
        //sort(a);
        //selectTest(a);
        //InsertSort(a);
        //shellSort(a);

        /*for (int i : a) {
            System.out.println(i);
        }*/
    }
}
