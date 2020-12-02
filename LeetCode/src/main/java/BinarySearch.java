import java.util.Arrays;

/**
 * @author ylqq
 *
 */
public class BinarySearch {
    public int binarySearch(int[] nums,int key){
        int l=0,m=nums.length-1;
        while (l<m){
            int load=l+(m-1)/2;
            if (nums[load]>=key){
                m=load;
            }else {
                l=load+1;
            }
        }
        return l;
    }

    /**
     * 大于给定元素的最小元素
     * */
    public char nextGreatestLetter(char[] letters, char target){
        int l=0,h=letters.length-1;
        while (l<h){
            int m=l+(h-1)/2;
            if (letters[m]<=target){
                l=m+1;
            }else {
                h=m-1;
            }
        }
        return l<letters.length?letters[l]:letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters) {
            seen[c - 'a'] = true;
        }

        while (true) {
            target++;
            if (target > 'z') {
                target = 'a';
            }
            if (seen[target - 'a']) {
                return target;
            }
        }
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1,-1};
        }

        int first=findFirst(nums,target);
        int end=findEnd(nums,target);
        if(first == nums.length || nums[first] != target){
            return new int[]{-1,-1};
        }
        return new int[]{first,end};
    }

    public int findFirst(int[] nums,int target){
        int l=0,h=nums.length-1;
        while (l<h){
            /* 往下取 */
            int m=l+(h-l)/2;
            if (nums[m]<target){
                l=m+1;
            }else if (nums[m]==target){
                h=m;
            }else {
                h=m-1;
            }
        }
        return l;
    }

    public int findEnd(int[] nums,int target){
        int l=0,h=nums.length-1;
        while (l<h){
            //往上取
            int m=(l+h+1)/2;
            if (nums[m]<target){
                l=m+1;
            }else if (nums[m]==target){
                l=m;
            }else {
                h=m-1;
            }
        }
        return l;
    }



    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        BinarySearch binarySearch=new BinarySearch();
        System.out.println(Arrays.toString(binarySearch.searchRange(nums, target)));
    }

}
