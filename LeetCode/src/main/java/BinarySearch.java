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

}
