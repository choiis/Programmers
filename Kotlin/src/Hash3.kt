import java.util.HashMap

// 프로그래머스 해시3 위장
fun main(Args: Array<String>) {

	var cloths = arrayOf(
		arrayOf<String>("yellow_hat", "headgear"),
		arrayOf<String>("blue_sunglasses", "eyewear"),
		arrayOf<String>("green_turban", "headgear")
	);
	println(solution2(cloths));
}

fun solution2(clothes: Array<Array<String>>): Int {

	var hashMap = HashMap<String, Int>();
	var length: Int = clothes.size;

	for (i in 0 until length) {
		if (hashMap.containsKey(clothes[i][1])) {
			var cnt:Int = hashMap.get(clothes[i][1])!! + 1;
			hashMap.put(clothes[i][1], cnt);
		} else {
			hashMap.put(clothes[i][1], 1);
		}
	}

	var answer = 1;
	for (value in hashMap.values) {
		answer *= value + 1;
	}
	answer -= 1;

	return answer;
}