import com.pineapple.generator.ArrayGenerator;
import com.pineapple.generator.NumericalGenerator;
import com.pineapple.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 */
class P3Test {
	/** 暴力解 */
	public static int maxPairNum1(int[] arr, int k) {
		if (k < 0) {
			return -1;
		}
		return process1(arr, 0, k);
	}
	
	/**
	 * 暴力解，使用全排列算法得到当前数组的所有排列，随后将每一个排列的前后两个进行比较， 最终的答案一定可以在全排列中得到
	 */
	public static int process1(int[] arr, int index, int k) {
		int ans = 0;
		if (index == arr.length) {
			for (int i = 1; i < arr.length; i += 2) {
				if (arr[i] - arr[i - 1] == k) {
					ans++;
				}
			}
		} else {
			for (int r = index; r < arr.length; r++) {
				swap(arr, index, r);
				ans = Math.max(ans, process1(arr, index + 1, k));
				swap(arr, index, r);
			}
		}
		return ans;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	@Test
	void solution() {
		int epoch = NumericalGenerator.getRandomPositiveInt(20);
		for (int i = 0; i < epoch; i++) {
			int mxaLength = NumericalGenerator.getRandomPositiveInt(10);
			int[] array = ArrayGenerator.lengthFixed1dIntervalIntArray(mxaLength, -10, 20);
			int k = NumericalGenerator.getRandomPositiveInt(10);
			int[] a1 = Utils.copyArray(array);
			int[] a2 = Utils.copyArray(array);
			int ans1 = maxPairNum1(a1, k);
			int ans2 = P3.solution(a2, k);
			Assertions.assertEquals(ans1, ans2);
		}
	}
}