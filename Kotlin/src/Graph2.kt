import java.util.Vector

// 프로그래머스 그래프2번 순위
fun main(Args: Array<String>) {

	val n: Int = 5;
	val results = arrayOf(
		intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2)
		, intArrayOf(1, 2), intArrayOf(2, 5)
	);
	println(solution3(n, results));

}

var wins: IntArray? = null;
var loses: IntArray? = null;
var visited: BooleanArray? = null;
var result: Array<IntArray>? = null;
var winvec: Vector<Vector<Int>>? = null;
var losevec: Vector<Vector<Int>>? = null;

fun dfs_wins(length: Int, startPoint: Int, nowPoint: Int) {
	visited!![nowPoint] = true;
	for (j in 0 until winvec!!.get(nowPoint).size) {
		val next: Int = winvec!!.get(nowPoint).elementAt(j);
		if (!visited!![next]) {
			wins!![startPoint]++;
			dfs_wins(length, startPoint, next);
		}
	}
}

fun dfs_loses(length: Int, startPoint: Int, nowPoint: Int) {
	visited!![nowPoint] = true;
	for (j in 0 until losevec!!.get(nowPoint).size) {
		val next: Int = losevec!!.get(nowPoint).elementAt(j);
		if (!visited!![next]) {
			loses!![startPoint]++;
			dfs_loses(length, startPoint, next);
		}
	}

}

fun solution3(n: Int, results: Array<IntArray>): Int {
	var answer = 0;
	result = results;
	wins = IntArray(n, { 0 });
	loses = IntArray(n, { 0 });
	winvec = Vector<Vector<Int>>();
	losevec = Vector<Vector<Int>>();
	for (i in 0 until n) {
		winvec!!.add(Vector<Int>());
		losevec!!.add(Vector<Int>());
	}
	for (i in 0 until results.size) {
		winvec!!.elementAt(result!![i][0] - 1).add(result!![i][1] - 1);
		losevec!!.elementAt(result!![i][1] - 1).add(result!![i][0] - 1);
	}

	for (i in 0 until n) {
		visited = BooleanArray(n, { false });
		dfs_wins(n, i, i);
		visited = BooleanArray(n, { false });
		dfs_loses(n, i, i);
	}

	for (i in 0 until n) {
		if (wins!![i] + loses!![i] == n - 1) {
			answer++;
		}
	}

	return answer;
}