fun main(Args: Array<String>) {

	val n: Int = 5;
	val lost: IntArray = intArrayOf(2, 4);
	val reserve: IntArray = intArrayOf(3);

	println(solution(n, lost, reserve));
}

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
	var answer: Int = n - lost.size;

	var canReserve: Int = 0;
	for (i in 0 until reserve.size) {
		for (j in 0 until lost.size) {
			if (lost[j] == reserve[i]) {
				reserve[i] = -1;
				lost[j] = -1;
				canReserve++;
				break;
			}
		}
	}

	var given: Int = 0;
	for (i in 0 until lost.size) {
		for (j in 0 until reserve.size) {
			if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
				given++;
				reserve[j] = -1;
				break;
			}
		}
	}
	return answer + canReserve + given;
}