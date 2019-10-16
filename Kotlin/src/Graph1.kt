import java.util.Vector
import java.util.LinkedList

// 프로그래머스 그래프1번 가장 먼 노드
fun main(Args: Array<String>) {
	var edge = arrayOf(
		intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2)
		, intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4)
		, intArrayOf(5, 2)
	);

	var num: Int = 6;

	println(solution2(num, edge));
}


fun solution2(n: Int, edge: Array<IntArray>): Int {

	var vector = Vector<Vector<Int>>();
	for (i in 0 until n) {
		vector.add(Vector<Int>());
	}
	var len: Int = edge.size;
	for (i in 0 until len) {
		vector.get(edge[i][0] - 1).add(edge[i][1] - 1);
		vector.get(edge[i][1] - 1).add(edge[i][0] - 1);
	}

	var visited = IntArray(n, { 0 });
	var max = 0;
	var queue = LinkedList<Vertex>();
	queue.add(Vertex(0, 1));
	visited[0] = 1;
	while (!queue.isEmpty()) {
		var vectex: Vertex = queue.poll();
		var now: Int = vectex.point;
		for (i in 0 until vector.get(now).size) {
			var next: Int = vector.get(now).elementAt(i);
			if (visited[next] == 0) {
				visited[next] = vectex.distance + 1;
				queue.add(Vertex(next, vectex.distance + 1));
				max = visited[next];
			}
		}
	}
	var answer = 0;
	for (i in 0 until n) {
		if (visited[i] == max) {
			answer++;
		}
	}

	return answer
}

class Vertex {
	var point: Int = 0;
	var distance: Int = 0;

	constructor(point: Int, distance: Int) {
		this.point = point;
		this.distance = distance;
	}
}