// 프로그래머스 BFS 1번 타켓넘버
fun main(Args: Array<String>) {
	var arr = intArrayOf(
		1, 1, 1, 1, 1
	);
	var N: Int = 3;
	println(solution(arr, N));
}

fun solution(numbers: IntArray, target: Int): Int {

	return dfs(numbers, target, 0, 0);
}

fun dfs(arr: IntArray, sum: Int, idx: Int, subsum: Int): Int {

	if (arr.size == idx) {
		if (sum == subsum) {
			return 1;
		} else {
			return 0;
		}
	}

	var cnt: Int = 0;
	cnt += dfs(arr, sum, idx + 1, subsum + arr[idx]);
	cnt += dfs(arr, sum, idx + 1, subsum - arr[idx]);
	return cnt;
}
