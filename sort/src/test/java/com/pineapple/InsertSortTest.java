package com.pineapple;

import com.pineapple.generator.ArrayGenerator;
import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author pineapple-man
 * @date 2022-07-12 14:08
 */
class InsertSortTest {
	private static final int EPOCH = 20;
	
	@Test
	void sort() {
		for (int i = 0; i < EPOCH; i++) {
			int length = NumericalGenerator.getLittleRandomPositiveInt();
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(length);
			int[] a1 = arr.clone();
			int[] a2 = arr.clone();
			Arrays.sort(a1);
			InsertSort.sort(a2);
			Assertions.assertArrayEquals(a1, a2);
			
		}
	}
}