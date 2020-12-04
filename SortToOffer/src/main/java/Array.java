import java.util.ArrayList;

class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        visitLinkedList(ans, listNode);
        return ans;
    }

    public void visitLinkedList(ArrayList<Integer> ans, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        visitLinkedList(ans, listNode.next);
        ans.add(listNode.val);
    }
}

class TwoDimensionalArray {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，
     * 输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数
     */
    public boolean Find(int target, int[][] array) {
        //这里我们使用左下角开始查找的方法，利用好排序数组
        for (int row = array.length - 1, col = 0; row > 0 && col < array[row].length; ) {
            if (array[row][col] > target) {
                row--;
            }
            if (array[row][col] < target) {
                col++;
            }
            if (array[row][col] == target) {
                return true;
            }
        }
        return false;
    }
}


/**
 * @author ylqq
 */
public class Array {
}
