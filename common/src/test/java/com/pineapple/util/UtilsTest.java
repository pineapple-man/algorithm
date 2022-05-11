package com.pineapple.util;

import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @date 2022-05-11 12:55
 */
class UtilsTest {
	
	@Test
	void swapBinary() {
		int a = NumericalGenerator.getRandomPositiveInt();
		int rowA = a;
		int b = NumericalGenerator.getRandomPositiveInt();
		int rowB = b;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		Assertions.assertEquals(rowA, b);
		Assertions.assertEquals(rowB, a);
	}
}