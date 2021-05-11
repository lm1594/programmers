package programmers.coding.test;

public class Solution6 {
	/**
	 * [Level2] 깊이/너비 우선 탐색(DFS/BFS)_타겟 넘버
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int solution6(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }
	
	// 그래프의 깊이 우선 탐색
	// 그래프 설명 참고: https://itholic.github.io/kata-target-number/
	public static int dfs(int[] numbers, int node, int sum, int target) {
		System.out.println("node: " + node + " sum: " + sum);
		if(numbers.length == node) {
			if(sum == target) {
				return 1;
			}
			
			return 0;
		}
		
		return dfs(numbers, node+1, sum+numbers[node], target) + dfs(numbers, node+1, sum-numbers[node], target);
	}
}
