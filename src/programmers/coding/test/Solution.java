package programmers.coding.test;

/**
 * 프로그래머스
 * @author 이경민
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.println("답: " + solution(13));
	}
	
	/**
	 * 124 나라의 숫자
	 * @param n
	 * @return
	 */
	public static String solution(int n) {
        String answer = "";
        
        while (n > 0) {
        	
        	// 3으로 나누었을 때 나머지가 0이면 4세팅 -> 124나라에는 0이라는 숫자가 없기 때문에
        	if(n%3 == 0) {
        		answer = "4"+answer;
        		n = (n/3)-1;	// 자릿수가 바뀌지 않았기 때문에 -1 해줘야함.
        	}else {	// 나머지 세팅
        		answer = String.valueOf((n%3))+answer;
            	n = n/3;   
        	}
        }
        
        return answer;
    }

}
