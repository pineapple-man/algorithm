/**
 * @author pineapple-man
 */
public class ReverseInteger {
	public static void main(String[] args) {
		int x = 2147483647;
		for (int i : new int[]{2147483647, -2147483647, -2147483648, 746384741})
			System.out.println(reverse(i));
	}
	
	public static int reverse(int x) {
		boolean isNeg = x < 0;
		int sum = 0;
		int bound = Integer.MIN_VALUE / 10;
		int carryBound = Integer.MIN_VALUE % 10;
		while (x != 0) {
			if (sum < bound || (sum == bound && -(x % 10) < carryBound)) {
				return 0;
			}
			sum = sum * 10 + (x % 10) * (isNeg ? 1 : -1);
			x /= 10;
		}
		return isNeg ? sum : -sum;
	}
}
