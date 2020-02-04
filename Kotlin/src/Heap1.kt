import java.util.PriorityQueue
import java.util.Queue

fun main(Args: Array<String>) {

	var arr: IntArray = intArrayOf(1, 2, 3, 9, 10, 12);
	println(solution5(arr, 7));
}


fun solution5(scoville: IntArray, N: Int): Int {
	var answer: Int = 0;
	var heap: Queue<Int> = PriorityQueue<Int>();
	scoville.forEach { it -> heap.add(it); };

	while (!heap.isEmpty() && heap.peek() <= N) {
		if (heap.size == 1) {
			return -1;
		}
		var first = heap.poll();
		var second = heap.poll();
		heap.add(first + 2 * second);
		answer++;
	}
	return answer;
};