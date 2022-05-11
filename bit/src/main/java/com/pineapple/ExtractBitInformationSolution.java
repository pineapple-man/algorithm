package com.pineapple;

/**
 * @author pineapple-man
 * @date 2022-05-11 13:00
 */
public class ExtractBitInformationSolution {
	/**
	 * 提取出 a 最右侧的 1
	 *
	 * @param a
	 * 		需要提取的数
	 * @return 提取出 1 的数值
	 */
	public static int extractRightestOneBit(int a) {
		return a & (-a);
	}
}
