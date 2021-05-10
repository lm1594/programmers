package programmers.coding.test;

import java.util.PriorityQueue;

public class Solution5 {
	/**
	 * 힙(Heap)_더 맵게
	 * @param scoville
	 * @param K
	 * @return
	 */
	public static int solution5(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int num : scoville) {
        	priorityQueue.offer(num);	
        }
        
        int tempInt = 0;
        while (!priorityQueue.isEmpty()) {
        	if(priorityQueue.size() == 1) {
        		answer = -1;
        		break;
        	} else {
        		tempInt = priorityQueue.poll() + (priorityQueue.poll() * 2);
            	priorityQueue.offer(tempInt);
            	answer++;
            	
            	if(priorityQueue.peek() >= K) {
            		break;
            	}
        	}
        }
        
        return answer;
    }
}
