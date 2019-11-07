import java.util.Vector

// 프로그래머스 완전탐색 1번 모의고사

fun main(Args: Array<String>) {

	var answers: IntArray = intArrayOf(1, 2, 3, 4, 5);
	solution4(answers);
}

fun solution4(answers: IntArray): IntArray {
	var select1: IntArray = intArrayOf(1, 2, 3, 4, 5);
	var repeat1: Int = select1.size;

	var select2: IntArray = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5);
	var repeat2: Int = select2.size;

	var select3: IntArray = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
	var repeat3: Int = select3.size;

	var length: Int = answers.size;
	var cnt = intArrayOf(0, 0, 0);
	for (i in 0 until length) {
		if (answers[i] == select1[i % repeat1]) {
			cnt[0]++;
		}

		if (answers[i] == select2[i % repeat2]) {
			cnt[1]++;
		}

		if (answers[i] == select3[i % repeat3]) {
			cnt[2]++;
		}
	}
	var max: Int = -1;
	for (i in 0 until 3) {
		if (max < cnt[i]) {
			max = cnt[i];
		}
	}

	var vec = Vector<Int>();
	for (i in 0 until 3) {
		if (max == cnt[i]) {
			vec.add(i + 1);
		}
	}
	var sol: IntArray = vec.toIntArray();
	return sol;
}