import java.lang.StringBuilder

// 프로그래머스 탐욕법3번 큰 수 만들기
fun main(Args: Array<String>) {
	val number: String = "4177252841";
	val k: Int = 4;

	println(solution(number, k));
}

fun solution(number: String, k: Int): String {
	var idx: Int = 0;
	var ch: Char;

	if (number.get(0) == '0') {
		return "0";
	}
	var answer: StringBuilder = StringBuilder();
	for (i in 0 until number.length - k) {
		ch = '0';
		for (j in idx..k + i) {
			if (ch < number.get(j)) {
				ch = number.get(j);
				idx = j + 1;
			}
		}
		answer.append(ch);
	}

	return answer.toString();
}