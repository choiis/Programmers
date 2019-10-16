// 프로그래머스 DP 2번 타일장식물
fun main(Args: Array<String>) {

	var N: Int = 5;

	println(solution(N));
	N = 6;
	println(solution(N));
}

fun solution(N: Int): Long {

	var dp = LongArray(81);
	dp[0] = 2;
	dp[1] = 4;

	for (i in 2 until N + 1) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	return dp[N];
}

