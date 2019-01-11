package palindromicsubstring;
//https://leetcode.com/problems/palindromic-substrings

public class PalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstrings("abba"));
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
		System.out.println(countSubstrings("racecaracec"));
	}
	
    public static int countSubstrings(String s) {
    	int n = s.length();
    	//isPalindrome[i][j] contains boolean whether substring that starts
    	//from i to j is palindrome
    	boolean[][] isPalindrome = new boolean[n][n];
    	
    	//All single character are palindrome
    	for (int i = 0; i < n; i++) isPalindrome[i][i] = true;
    	
    	//Two char length palindrome
    	for (int i = 0; i < n-1 && i+1 < n; i++)
    		if (s.charAt(i) == s.charAt(i+1))
    			isPalindrome[i][i+1] = true;
    	
    	//More than two char length palindrome
    	for (int length = 3; length <= n; length++) {
    		for (int i = 0; i+length-1 < n; i++) {
    			if (s.charAt(i) == s.charAt(i+length-1) &&
    				isPalindrome[i+1][i+length-2])
    				isPalindrome[i][i+length-1] = true;
    		}
    	}
    	
    	int count = 0;
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < n; j++)
    			if (isPalindrome[i][j]) count++;
    	return count;
    }
    
}
