package programmers.coding.test;

/**
 * 프로그래머스
 * @author 이경민
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		// System.out.println("답: " + solution1(13));
		System.out.println("답: " + solution2("xababcdcdababcdcd"));
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

}
