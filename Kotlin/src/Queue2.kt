import java.util.Arrays
import java.util.LinkedList

// 프로그래머스 스택/큐 1 프린터
fun main(Args: Array<String>) {

	var priorities = intArrayOf(2, 1, 3, 2);
	var location = 2;
	println(solution2(priorities, location));
}

fun solution2(priorities: IntArray, location: Int): Int {

	val length: Int = priorities.size;
	var visited = BooleanArray(length, { false });
	val printerQueue = LinkedList<Int>();
	val remainQueue = LinkedList<Int>();

	for (i in 0 until length) {

		if (visited[i]) {
			continue;
		}
		var maxIdx: Int = i;
		var max: Int = priorities[i];
		for (j in i until length) {
			if (max < priorities[j] && !visited[j]) {
				max = priorities[j];
				maxIdx = j;
			}
		}
		if (maxIdx == i) {
			visited[maxIdx] = true;
			printerQueue.add(maxIdx);
		} else {
			remainQueue.add(i);
		}
	}

	while (!remainQueue.isEmpty()) {
		printerQueue.add(remainQueue.poll());
	}

	var answer = 0;
	while (!printerQueue.isEmpty()) {
		val res: Int = printerQueue.poll();
		if (res == location) {
			break;
		}
		answer++;
	}

	return answer + 1;
}

open class Printer : Comparable<Printer> {
	protected var prior: Int = 0
	protected var idx: Int = 0

	constructor() {

	}

	constructor(prior: Int, idx: Int) : super() {
		this.prior = prior
		this.idx = idx
	}

	override fun compareTo(p: Printer): Int {
		return if (this.prior == p.prior) {
			p.idx - this.idx
		} else {
			p.prior - this.prior
		}
	}

}
