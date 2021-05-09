package programmers.coding.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 프로그래머스
 * @author 이경민
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		// System.out.println("답: " + solution1(13));
		// System.out.println("답: " + solution2("xababcdcdababcdcd"));
		// System.out.println("답: " + solution3("baabaa"));
		String[] strArray = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	}
	
	/**
	 * 124 나라의 숫자
	 * @param n
	 * @return
	 */
	public static String solution1(int n) {
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
	
	/**
	 * 2020 KAKAO BLIND RECRUITMENT_문자열 압축
	 * @param s
	 * @return
	 */
	public static int solution2(String s) {
        int answer = s.length();
        
        if(answer == 1) {
        	return answer;
        }
        
        for(int i=1; i<=s.length()/2 ; i++) {	// 비교 문자열의 길이를 지정한다.
        	int count = 1;
        	
        	String baseStr = s.substring(0, i);	// 비교 기준 문자열 
        	String tempStr = "";				// 비교할 문자열
        	String resultStr = "";				// 결과 문자열
        	
        	for(int j=i; j<s.length(); j += i) {// 비교 기준 문자열과 비교
        		tempStr = s.substring(j, j+i);	// 위에서 지정한 길이(i)만큼 잘라서 비교할 문자열 생성
        		
        		if (baseStr.equals(tempStr)) {	// 기준 문자열과 비교하여 같으면 count+1
        			count++;
        		} else {						// 기준 문자열과 다르면 새로운 기준 문자열 세팅 및 현재까지 같았던 문자열 정보 세팅
        			if (count == 1) {			// 1이면 숫자 생략
        				resultStr = resultStr + baseStr;
            			baseStr = s.substring(j, j+i);
        			} else {					// 2이상이면 숫자 + 문자열로 세팅
        				resultStr = resultStr + String.valueOf(count)+ baseStr;
            			baseStr = s.substring(j, j+i);
            			count = 1;
        			}
        		}
        		
        		if((i+j+i) > s.length()) {		// 다음 진행할 index가 총 길이를 넘어섰을 때
        			if (count != 1) {			// count가 1이 아니면 count + 기준문자열 + 나머지 문자열
        				resultStr = resultStr + String.valueOf(count)+ baseStr + s.substring(i+j);
            		} else {					// count가 1이면 숫자 생략한 후 남은 문자열 +
            			resultStr = resultStr + s.substring(j);
            		}
        			break;
        		}

        	}

            answer = (answer > resultStr.length()) ? resultStr.length() : answer;
        }
        return answer;
    }

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
	
	/**
	 * 2019 KAKAO BLIND RECRUITMENT_오픈채팅방
	 */
	public static String[] solution4(String[] record) {
		// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	
		// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
        String[] answer = {};
        List<String> resultList = new ArrayList<String>();
        
        Map<String, String> userMap = new HashMap<String, String>();
        for (String str : record) {
        	String[] splitStr = str.split(" ");
        	switch(splitStr[0]) {
        		case "Enter":
        			userMap.put(splitStr[1], splitStr[2]);
        			resultList.add(splitStr[1]+" Enter");
        			break;
        		case "Change":
        			userMap.put(splitStr[1], splitStr[2]);
        			break;
        		case "Leave":
        			resultList.add(splitStr[1]+" Leave");
        			break;
        	}
        }
        
        answer = resultList.toArray(answer);
        
        for (int i=0 ; i<answer.length; i++) {
        	String[] splitStr = answer[i].split(" ");
        	switch(splitStr[1]) {
    		case "Enter":
    			answer[i] = userMap.get(splitStr[0])+"님이 들어왔습니다.";
    			break;
    		case "Leave":
    			answer[i] = userMap.get(splitStr[0])+"님이 나갔습니다.";
    			break;
        	}
        }
        
        return answer;
    }
}
