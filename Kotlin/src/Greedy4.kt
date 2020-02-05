import java.util.Arrays

// 프로그래머스 탐욕법4번 구명보트
fun main(Args: Array<String>) {
	val people: IntArray = intArrayOf(70, 50, 80, 50);
	val limit: Int = 100;

	println(solution3(people, limit));
}

fun solution3(people: IntArray, limit: Int): Int {
	var answer: Int = 0;
	Arrays.sort(people);

	var biggest: Int = people.size - 1;
	var smallest: Int = 0;

	for (i in biggest downTo smallest step 1) {
		if (i < smallest) {
			break;
		} else if (people[i] + people[smallest] > limit) {
			answer++;
		} else {
			answer++;
			smallest++;
		}
	}

	return answer;
};