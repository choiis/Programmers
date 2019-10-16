import java.util.LinkedList

// 프로그래머스 스택/큐 1 기능개발
fun main(Args: Array<String>) {


	val prog = intArrayOf(93, 30, 55);
	val speed = intArrayOf(1, 30, 5);

	val result: IntArray = solution(prog, speed);
	for (i in 0 until result.size) {
		println(result[i]);
	}
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
	var queue = LinkedList<Int>();
	var length: Int = progresses.size;
	var cnt: Int = 0;
	var progressIdx: Int = 0;
	while (true) {

		for (i in progressIdx until length) {
			progresses[i] += speeds[i];
		}

		if (progresses[progressIdx] >= 100) {
			var complete: Int = 1;
			for (i in (progressIdx + 1) until length) {
				if (progresses[i] >= 100) {
					complete++;
				} else {
					progressIdx = i;
					break;
				}
			}
			queue.add(complete);
			cnt += complete;
		}

		if (cnt == length) {
			break;
		}
	}


	var answer = IntArray(queue.size);
	var idx: Int = 0;
	while (!queue.isEmpty()) {
		answer[idx++] = queue.poll();
	}

	return answer;
}