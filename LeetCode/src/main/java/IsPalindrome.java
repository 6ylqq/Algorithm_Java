/**
 * @author ylqq
 */
public class IsPalindrome {
    public boolean isPalindrome(int x){
        //取模运算解决
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int ans=0;
        int old=x;
        while (x>0){
            ans=ans*10+x%10;
            x/=10;
        }
        return ans==old;
    }
}
