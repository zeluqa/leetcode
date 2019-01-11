package backspacestringcompare;
//https://leetcode.com/problems/backspace-string-compare/

public class BackspaceStringCompare {
	
	public static String doBackspace(String s) {
		String r = "";
		int backspaceCount = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == '#') backspaceCount++;
			else {
				if(backspaceCount == 0)
					r = s.charAt(i) + r;
				else
					backspaceCount--;
			}
		}
		return r;
	}
	
    public static boolean backspaceCompare(String S, String T) {
        return doBackspace(S).equals(doBackspace(T));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}
}
