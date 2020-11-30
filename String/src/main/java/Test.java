import java.util.HashMap;

/**
 * 计算一组字符集合可以组成的回文字符串的最大长度
 * */
class LongestPalindrome{
    public int longestPalindrome(String s){
        int[] cnt=new int[256];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        int palindrome=0;
        for (int i : cnt) {
            palindrome+=(i/2)*2;
        }
        if (palindrome<s.length()){
            palindrome++;
        }
        return palindrome;
    }

    public int longestPalindromeHashmap(String s){
        if (s.length()==0){
            return 0;
        }
        int count=0;
        HashMap<Character,Integer> hashMap=new HashMap<>(256);
        for (char c : s.toCharArray()) {
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        for (Integer value : hashMap.values()) {
            count+=(value/2)*2;
        }

        if (count<s.length()){
            ++count;
        }
        return count;
    }
}

/**
 * 判断字符串是否重构
 * */
class IsIsomorphic{
    public boolean isIsomorphic(String s,String t){
        int[] preIndexOfS=new int[256];
        int[] preIndexOfT=new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if (preIndexOfS[sc]!=preIndexOfT[tc]){
                return false;
            }
            preIndexOfS[sc]=i+1;
            preIndexOfT[tc]=i+1;
        }
        return true;
    }
    
    public boolean isIsomorphicHash(String s,String t){
        HashMap<Character,Integer> hashMapS=new HashMap<>(256);
        HashMap<Character,Integer> hashMapT=new HashMap<>(256);
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!hashMapS.getOrDefault(s.charAt(i), 0).equals(hashMapT.getOrDefault(t.charAt(i), 0))){
                return false;
            }
            //默认初始化的键值为0
            hashMapS.put(s.charAt(i),i+1);
            hashMapT.put(t.charAt(i),i+1);
        }
        return true;
    }
}

/**
 * 回文子字符串个数
 * */
class CountSubstrings{
    private int count;
    public int countSubstrings(String s){
        for (int i = 0; i < s.length(); i++) {
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        return this.count;
    }

    public void isPalindrome(String s,int start,int end){
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            this.count++;
        }
    }
}


class JumpFloor{
    public int jumpFloor(int target) {
        int a = 1, b = 1;
        for (int i = 1; i < target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}

/**
 * @author ylqq
 */
public class Test {
    public static void main(String[] args) {
        //LongestPalindrome longestPalindrome=new LongestPalindrome();
        CountSubstrings substrings=new CountSubstrings();
        String str="aaabccc";
        substrings.countSubstrings(str);


        JumpFloor jumpFloor=new JumpFloor();
        jumpFloor.jumpFloor(5);
    }
}
