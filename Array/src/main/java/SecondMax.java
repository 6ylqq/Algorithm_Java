import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author ylqq
 */
public class SecondMax {
    public static int FindSecMax(int[] data){
        if (data.length<2){
            return data[0];
        }

        int maxNum=data[0];
        int secMaxNum=data[0];

        for (int i = 0; i < data.length; i++) {
            if (data[0]>maxNum){
                secMaxNum=maxNum;
                maxNum=data[0];
            }else {
                if (data[i]>secMaxNum){
                    secMaxNum=data[i];
                }
            }
        }
        return secMaxNum;
    }

    @Test
    public void test(){
        //新建一个随机数组测试
        Random random=new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            int num=random.nextInt();
            a[i]=num;
        }

        System.out.println("secondMaxNum="+FindSecMax(a));
    }
}
