import java.util.HashSet

// 프로그래머스 완전탐색 2번 소수찾기
fun main(Args: Array<String>) {
	var number: String = "17";

	var num: Int = Integer.parseInt(number);

	println(solution(number));
}

var set = HashSet<Int>();

fun solution(numbers: String): Int {
	var answer = 0;
	var length: Int = numbers.length;
	var intarr = IntArray(length);
	for (i in 0 until length) {
		intarr[i] = numbers.elementAt(i) - '0';
	}

	for (i in 1..length) {
		perm(intarr, 0, length, i);
	}

	return set.size;
}


fun perm(arr: IntArray, depth: Int, n: Int, r: Int) {

	if (depth == r) {
		var cnt: Int = arr[0];
		for (j in 1 until r) {
			cnt = 10 * cnt + arr[j];
		}
		var flag: Boolean = true;
		if (cnt == 0 || cnt == 1) {
			flag = false;
		}

		for (i in 2..Math.sqrt(cnt.toDouble()).toInt()) {
			if (cnt % i == 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			set.add(cnt);
		}
		return;
	}

	for (i in depth until n) {
		swap(arr, depth, i);
		perm(arr, depth + 1, n, r);
		swap(arr, depth, i);
	}
}

fun swap(arr: IntArray, i: Int, j: Int) {
	var temp: Int = arr[j];
	arr[j] = arr[i];
	arr[i] = temp;

}