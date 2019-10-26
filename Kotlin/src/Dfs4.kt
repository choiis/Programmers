import java.util.Arrays;
import java.util.Vector

// 프로그래머스 Dfs 4번 여행경로
fun main(Args: Array<String>) {

	val tickets = arrayOf(
		arrayOf<String>("ICN", "SFO"),
		arrayOf<String>("ICN", "ATL"),
		arrayOf<String>("SFO", "ATL"),
		arrayOf<String>("ATL", "ICN"),
		arrayOf<String>("ATL", "SFO")
	);
	solution(tickets);
}


var vec: Vector<String>? = null;
fun dfs(now: String, tickets: Array<Array<String>>, visited: BooleanArray) {
	vec!!.add(now);
	for (i in 0 until tickets.size) {
		if (!visited[i] && tickets[i][0].equals(now)) {
			visited[i] = true;
			dfs(tickets[i][1], tickets, visited);
			break;
		}
	}
}

fun solution(tickets: Array<Array<String>>): Array<String?> {

	Arrays.sort(tickets) { o1, o2 -> o1[1].compareTo(o2[1]) };
	var visited = BooleanArray(tickets.size, { false });
	vec = Vector<String>();
	dfs("ICN", tickets, visited);

	var answer = arrayOfNulls<String>(vec!!.size);
	for (i in 0 until vec!!.size) {
		answer[i] = vec!!.get(i);
	}
	return answer;
}