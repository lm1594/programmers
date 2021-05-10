package programmers.coding.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
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
