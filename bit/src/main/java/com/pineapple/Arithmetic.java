package com.pineapple;

/**
 * @author pineapple-man
 */
public class Arithmetic {
	public static int sub(int a, int b) {
		return add(a, negativeNumber(b));
	}
	
	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			int temp = (sum & b) << 1;//进位信息
			sum = sum ^ b; //原本两个数的无进位相加
			b = temp;//如果当前进位不为0，需要重复进行
		}
		return sum;
	}
	
	public static int negativeNumber(int a) {
		return add(~a, 1);
	}
	
	public static int multiply(int a, int b) {
		int sum = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				sum = add(sum, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return sum;
	}
	
	public static int subtract(int a, int b) {
		return 0;
	}
}
