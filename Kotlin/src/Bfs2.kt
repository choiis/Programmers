import java.util.*

// 프로그래머스 DP 3번 정수삼각형
fun main(Args: Array<String>) {
	var arr = arrayOf(
		intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)
	);
	var N: Int = 3
	println(solution(N, arr));
}

fun solution(n: Int, computers: Array<IntArray>): Int {
	var cnt: Int = 0;
	var queue = LinkedList<Int>();

	var visited = BooleanArray(n, { false });

	for (i in 0 until n) {
		if (!visited[i]) {
			cnt++;
			queue.add(i);
			visited[i] = true;

			while (!queue.isEmpty()) {
				var now: Int = queue.poll();
				for (j in 0 until n) {
					if (j == now || visited[j]) {
						continue;
					}

					if (computers[now][j] == 1) {
						visited[j] = true;
						queue.add(j);
					}
				}
			}
		}
	}

	return cnt;
}
