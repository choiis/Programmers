import java.util.Arrays

// 프로그래머스 해시1 완주하지 못한 선수
fun main(Args: Array<String>) {

	val participant = arrayOf("leo", "kiki", "eden")
	val completion = arrayOf("kiki", "eden")

	System.out.println(solution(participant, completion))
}

fun solution(participant: Array<String>, completion: Array<String>): String {
	Arrays.sort(participant)
	Arrays.sort(completion)
	val length = completion.size
	for (i in 0 until length) {
		if (completion[i] != participant[i]) {
			return participant[i]
		}
	}
	return participant[length]
}