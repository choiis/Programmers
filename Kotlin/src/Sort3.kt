import java.util.Arrays

// 프로그래머스 정렬 3번 H-Index
fun main(Args: Array<String>) {

	val arr: IntArray = intArrayOf(3, 0, 6, 1, 5);
	println(solution3(arr));
}

fun solution3(citations: IntArray): Int {
	Arrays.sort(citations);
	var answer = 0;
	val length = citations.size;
	for (i in 0 until length) {
		if (citations[i] >= length - i) {
			answer = length - i;
			break;
		}
	}

	return answer;
}