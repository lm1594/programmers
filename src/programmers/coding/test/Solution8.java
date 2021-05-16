package programmers.coding.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution8 {
	/**
	 * [Level2] 스택/큐_기능개발
	 * @return
	 */
	public static int[] solution8(int[] progresses, int[] speeds) {
		int[] answer = {};
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        int count=0;
        
        // 스택 SET
        for(int i=progresses.length-1 ; i>=0 ; i--) {
        	stack.push(i);
        }
        
        // 작업이 전부 완료 될 때까지 loop
        while (true) {
        	if(stack.isEmpty()) {
        		break;
        	}
        	
        	list = new ArrayList<Integer>();
        	
        	// 작업 완료 시 list에 add
        	for(int i=0 ; i<progresses.length ; i++) {
            	progresses[i] += speeds[i];
            	if(progresses[i] >= 100) {
            		list.add(i);
            	}
            }
        	
        	// 한방에 배포될 작업 갯수 구하기
        	count = 0;
        	for(int i=0 ; i<list.size() ; i++) {
        		if(!stack.isEmpty()) {
        			if(list.contains(stack.peek())) {
                		count++;
                		stack.pop();
                	}
        		}else {
        			break;
        		}
            }
        	
    		if(count != 0) 
    			resultList.add(count);
        }
        
        answer = resultList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
