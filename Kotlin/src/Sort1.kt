import java.util.Arrays

// 프로그래머스 정렬 1번 K번째 수
fun main(Args: Array<String>) {

	val array = intArrayOf(3, 30, 34, 5, 9);
	println(solution(array));
}

fun solution(numbers: IntArray): String {
	val arr = arrayOfNulls<String>(numbers.size);
	for (i in numbers.indices) {
		arr[i] = numbers[i].toString();
	}
	Arrays.sort(arr) { o1, o2 -> (o2 + o1).compareTo(o1 + o2) };


	if (arr[0] == "0") {
		return "0";
	}

	val sb = StringBuilder();
	for (i in arr.indices) {
		sb.append(arr[i]);
	}

	return sb.toString();
}