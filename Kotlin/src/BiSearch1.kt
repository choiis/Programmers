// 프로그래머스 이분탐색1 입국심사
fun main(Args: Array<String>) {

	var n: Int = 6;
	var times = intArrayOf(7, 10);
	println(solution(n, times));
}

fun solution(n: Int, times: IntArray): Long {
	var answer: Long = Long.MAX_VALUE;

	var length = times.size;
	var max: Int = 0;
	for (i in 0 until length) {
		max = Math.max(max, times[i]);
	}

	var left: Long = 0;
	var right: Long = max.toLong() * n;

	while (left <= right) {
		var mid: Long = (left + right) / 2;
		var sum: Long = 0;
		for (i in 0 until length) {
			sum += mid / times[i];
		}

		if (sum < n) {
			left = mid + 1;
		} else {
			if (answer > mid) {
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
	}
	return answer;
}