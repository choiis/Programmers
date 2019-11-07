import java.util.Arrays
import java.util.LinkedList

// 프로그래머스 스택/큐 3 탑
fun main(Args: Array<String>) {

	var heights = intArrayOf(3, 9, 9, 3, 5, 7, 2);
	println(solution5(heights));
}

fun solution5(heights: IntArray): IntArray {
	val length = heights.size;
	val answer = IntArray(length);

	for (i in length - 1 downTo 1) {
		for (j in 0 until i) {
			if (heights[j] > heights[i])
				answer[i] = j + 1;
		}
	}
	return answer;
}