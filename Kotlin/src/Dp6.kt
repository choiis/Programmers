// 프로그래머스 DP 6번 도둑질
fun main(Args: Array<String>) {

	val money: IntArray = intArrayOf(1, 2, 3, 1);
	println(solution2(money));
}

fun solution2(money: IntArray): Int {
	var answer: Int = 0;
	val length: Int = money.size;
	var dp: IntArray = IntArray(length, { 0 });

	dp[0] = money[0];
	dp[1] = dp[0];
	for (i in 2 until length - 1) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
	}
	answer = dp[length - 2];

	dp[0] = 0;
	dp[1] = money[1];
	for (i in 2 until length) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
	}

	return Math.max(answer, dp[length - 1]);
}