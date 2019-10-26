import java.util.Arrays

// 프로그래머스 정렬 2번 가장큰수
fun main(Args: Array<String>) {

	val array = intArrayOf(1, 5, 2, 6, 3, 7, 4);
	val commands = arrayOf(
		intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3)
	);
	solution(array, commands);
}


fun quickSort(data: IntArray, first: Int, last: Int) {
	if (first >= last) {
		// 원소가 1개인 경우
		return;
	}

	val pivot: Int = first;
	var left: Int = pivot + 1;
	var right: Int = last;
	var temp: Int;

	while (left < right) {
		while (left <= last && data[left] < data[pivot]) {
			left++;
		}
		while (right >= pivot && data[pivot] < data[right]) {
			right--;
		}

		if (left < right) {
			temp = data[left];
			data[left] = data[right];
			data[right] = temp;
		} else {
			temp = data[pivot];
			data[pivot] = data[right];
			data[right] = temp;
		}
		quickSort(data, first, right - 1);
		quickSort(data, right + 1, last);
	}
}

fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
	val size: Int = commands.size;
	var answer = IntArray(size);
	for (i in 0 until size) {
		val data: IntArray = IntArray(commands[i][1] - commands[i][0] + 1);
		for (j in 0 until data.size) {
			data[j] = array[j + commands[i][0] - 1];
		}
		Arrays.sort(data);
		answer[i] = data[commands[i][2] - 1];
	}

	return answer;
}