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
}

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
}

/**
 * @author ylqq
 */
public class Test {
}
