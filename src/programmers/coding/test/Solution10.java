package programmers.coding.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution10 {
	
	/**
	 * [Level2] 정렬_가장 큰 수
	 */
	public static String solution10(int[] numbers) {
        String answer = "";
        
        List<String> resultArr = new ArrayList<String>();
        
        for(int i=0 ; i<numbers.length; i++) {
        	resultArr.add(String.valueOf(numbers[i]));
        }
        
        Comparator<String> comparator = (o1, o2) -> {
        	BigInteger s2s1 = new BigInteger(o2 + o1);
            BigInteger s1s2 = new BigInteger(o1 + o2);
            return s1s2.compareTo(s2s1)*-1;
        };
        
        resultArr.sort(comparator);
        
        for(String str: resultArr) {
        	answer += str;
        }
        
        return answer.startsWith("0") ? "0" : answer;
    }
}
