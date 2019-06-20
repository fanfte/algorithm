package leetcode;

/**
 * Created by tianen on 2019/6/12
 *
 * @author fanfte
 * @date 2019/6/12
 **/
public class Test005 {

    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            String s1 = extendString(s, i, i);
            String s2 = extendString(s, i, i + 1);
            if (s1.length() > res.length()) {
                res = s1;
            }
            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    private String extendString(String s, int start, int end) {
        while (start >= 0  && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start --;
            end ++;
        }
        return s.substring(start + 1, end);
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        String res = null;
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

        for(int i = n-1; i >= 0; i--) { // keep increasing the possible palindrome string
            for(int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                        &&
                        ( j-i < 3  // if window is less than or equal to 3, just end chars should match
                                || dp[i+1][j-1]  ); // if window is > 3, substring (i+1, j-1) should be palindrome too

                //update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }


    public static void main(String[] args) {
        String abcba = longestPalindrome2("abcba");
        System.out.println(abcba);
    }
}
