import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 判断一个非负整数是否为两个整数的平方和。
 */
class TowSum {
    public int[] towSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) == target) {
                return new int[]{i + 1, j + 1};
            }
            if ((numbers[i] + numbers[j]) > target) {
                --j;
            }
            ++i;
        }
        return null;
    }
}

class JudgeSquareSum {
    public boolean judgeSquareSum(int target) {
        int i = 0;
        int j = (int) Math.sqrt(target);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                --j;
            }
            ++i;
        }
        return false;
    }
}

class ValidPalindrome {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; --j, ++i) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, --j) || isPalindrome(s, ++i, j);
            }
        }
        return true;
    }

    @Test
    public void Test() {
        String test = "";
        System.out.println(validPalindrome(test));
    }
}

class LongestWord {

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String s1 : d) {
            int l1 = longestWord.length(), l2 = s1.length();
            if (l1 > l2 || l1 == l2 && longestWord.compareTo(s1) < 0) {
                //返回最小字典序的字符串
                continue;
            }
            if (isSubstr(s, s1)) {
                longestWord = s1;
            }
        }
        return longestWord;
    }

    /**
     * 判断子序列
     */
    public boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() - target.length() && j < target.length() - 1) {
            if (s.charAt(i) == target.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return j == target.length();
    }
}


/**
 * @author ylqq
 */
public class TwoPointer {
    public static void main(String[] args) {
        TwoPointer twoPointer = new TwoPointer();

    }

    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     */
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String s1 : d) {
            if (result.length() > s1.length()
                    || (result.length() == s1.length()
                    && result.compareTo(s1) < 0)) {
                continue;
            }
            if (isSubstr(s, s1)) {
                result = s1;
            }
        }
        return result;
    }

    public boolean isSubstr(String str, String target) {
        int i = 0, j = 0;
        while (j < target.length() && i < str.length()) {
            if (str.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
