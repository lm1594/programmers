package programmers.coding.test;

import java.util.Stack;

public class Solution3 {
	/**
	 * 2017 팁스타운_짝지어 제거하기
	 * @param s
	 * @return
	 */
	public static int solution3(String s)
    {
        // 내가 만든 재귀 함수
        // s = removeStr(s);
        
        // 모범 답안_Stack 자료형 이용
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
        
        return stack.isEmpty() ? 1 : 0;
    }
	// 내가 만든 재귀 함수
	public static String removeStr(String s) {
		
		for (int i=0 ; i<=s.length()-2; i++) {
			if(s.substring(i, i+1).equals(s.substring(i+1, i+2))) {
				if (i == 0) {
					return removeStr(s.substring(i+2));
				} else {
					return removeStr(s.substring(0,  i) + s.substring(i+2));
				}
			}
		}
		
		return s;
	}
}
