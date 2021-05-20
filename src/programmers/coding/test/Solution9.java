package programmers.coding.test;

import java.util.HashSet;
import java.util.Set;

public class Solution9 {
	
	public static Set<Integer> setNumber = new HashSet<Integer>();
	
	/**
	 * [Level2] 완전탐색_소수 찾기
	 * 참고: https://gorakgarak.tistory.com/522
	 * @return
	 */
	public static int solution9(String numbers) {
        int answer = 0;
        
        String[] str = numbers.split("");
        int[] number = new int[str.length];
        for(int i=0 ; i<str.length; i++) {
        	number[i] = Integer.parseInt(str[i]);	
        }
        
        for(int i=1 ; i<=number.length; i++) {
            perm(number, 0 , number.length, i);
        }
        
        int[] resultNumArr = setNumber.stream().mapToInt(i->i).toArray();
        for(int i=0; i<resultNumArr.length ; i++) {
        	if(primeNum(resultNumArr[i])) {
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void perm(int[] arr, int depth, int n, int k) {
		if(depth == k) {
			print(arr, k);
		}
		
		for(int i=depth; i<n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void print(int[] arr, int k) { 
		String str = "";
		for (int i = 0; i < k; i++) {
			str += arr[i];
		} 
		
		setNumber.add(Integer.parseInt(str));
	}
	
	public static boolean primeNum(int num) {
		if(num<2) {
			return false;
		}
		for(int i=2; i<num; i++){
		   if(num % i == 0) return false;
		}
        return true;
	}
}
