import java.util.LinkedList

// 프로그래머스 BFS 3번 단어변환
fun main(Args: Array<String>) {

	val begin: String = "hit";
	val end: String = "cog";
	//val words = arrayOf<String>("hot", "dot", "dog", "lot", "log", "cog");
	val words = arrayOf<String>("hot", "dot", "dog", "lot", "log");
	println(solution(begin, end, words));
}

fun solution(begin: String, target: String, words: Array<String>): Int {
	var answer = 1;
	val length: Int = words.size;
	var visited = BooleanArray(length, { false });

	var queue = LinkedList<String>();
	queue.add(begin);

	while (!queue.isEmpty()) {

		val cnt: Int = queue.size;
		for (i in 0 until cnt) {
			val now: String = queue.poll();
			for (j in 0 until length) {
				if (!visited[j]) {
					if (isNext(now, words[j])) {

						if (target.equals(words[j])) {
							return answer;
						}
						visited[j] = true;
						queue.add(words[j]);
					}
				}
			}
		}

		answer++;
	}

	return 0;
}

fun isNext(begin: String, target: String): Boolean {
	val wordLength: Int = begin.length;
	var diff: Int = 0;

	for (i in 0 until wordLength) {
		if (begin.elementAt(i) != target.elementAt(i)) {
			diff++;
		}
		if (diff > 1) {
			return false;
		}
	}

	if (diff == 1) {
		return true;
	} else {
		return false;
	}
}