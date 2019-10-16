// 프로그래머스 DP 3번 정수삼각형
fun main(Args: Array<String>) {
	var arr = arrayOf(
		intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0)
		, intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5)
	);
	println(solution(arr));
}

fun solution(triangle: Array<IntArray>): Int {

	var N: Int = triangle.size;
	var dp = Array(N, { IntArray(N, { 0 }) });
	dp[0][0] = triangle[0][0];

	for (i in 1 until N) {
		for (j in 0..i) {
			if (j == 0) {
				dp[i][j] = dp[i - 1][j] + triangle[i][j];
			} else if (i == j) {
				dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
			} else {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
			}
		}
	}

	var answer: Int = 0;
	for (i in 0 until N) {
		answer = Math.max(answer, dp[N - 1][i]);
	}
	return answer;
}