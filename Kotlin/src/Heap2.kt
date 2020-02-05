import java.util.PriorityQueue
import java.util.Queue

// 프로그래머스 힙2 라면공장
fun main(Args: Array<String>) {

	val stock: Int = 4;
	val dates: IntArray = intArrayOf(4, 10, 15);
	val supplies: IntArray = intArrayOf(20, 5, 10);
	val k: Int = 30;
	println(solution(stock, dates, supplies, k));
}

fun solution(stock: Int, dates: IntArray, supplies: IntArray, K: Int): Int {
	var stock: Int = stock;
	var answer: Int = 0;
	val priorityQueue: Queue<Flour> = PriorityQueue<Flour>();

	var idx: Int = 0;
	for (day in 0 until K) {
		if (idx < dates.size && day == dates[idx])
			priorityQueue.add(Flour(supplies[idx++]));

		if (stock == 0) {
			stock += priorityQueue.poll().supply;
			answer++;
		}
		stock -= 1;
	}
	return answer;
};

internal class Flour(var supply: Int) : Comparable<Flour> {

	override fun compareTo(o: Flour): Int {
		return o.supply - this.supply
	}

}