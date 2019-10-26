// 프로그래머스 DP 4번 등굣길
fun main(Args: Array<String>) {
	val m: Int = 4;
	val n: Int = 3;
	var puddles = arrayOf(
		intArrayOf(2, 2)
	);
	println(solution(m, n, puddles));
}

fun solution(m: Int, n: Int, puddles: Array<IntArray>): Int {

	var dp = Array(m + 1, { IntArray(n + 1, { 0 }) });
	for (i in 0 until puddles.size) {
		dp[puddles[i][0]][puddles[i][1]] = -1;
	}
	dp[1][0] = 0;

	for (j in 1 until n + 1) {
		for (i in 1 until m + 1) {
			if (dp[i][j] == -1) {
				dp[i][j] = 0;
			} else {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
			}
		}
	}

	return dp[m][n];
}