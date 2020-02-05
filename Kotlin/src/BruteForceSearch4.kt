import java.util.HashSet

// 프로그래머스 완전탐색 4번 카펫
fun main(Args: Array<String>) {
	val brown: Int = 10;
	val red: Int = 10;
	solution(brown, red);
}

fun solution(brown: Int, red: Int): IntArray {
	var answer: IntArray = IntArray(2);
	val totalBlock: Int = brown + red;
	for (x in 1..totalBlock) {
		val y: Int = totalBlock / x;
		if (x * y == totalBlock && (2 * x + 2 * y - 4) == brown) {
			if (x >= y) {
				answer[0] = x;
				answer[1] = y;
			} else {
				answer[0] = y;
				answer[1] = x;
			}
		}
	}
	return answer;
}