package programmers.coding.test;

public class Solution7 {
	/**
	 * [Level2] Summer/Winter Coding(2019)_멀쩡한 사각형
	 * @return
	 */
	public static long solution7(int w, int h) {
        long answer = 0;
        
        for(long i=0 ; i<h ; i++) {
        	answer += (long) (i*w/h);
        }
        
        return (long) answer*2;
    }
}
