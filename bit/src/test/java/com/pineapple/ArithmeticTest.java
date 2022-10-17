package com.pineapple;

import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 */
class ArithmeticTest {
	
	@Test
	void arithmetic() {
		int epoch = NumericalGenerator.getLittleRandomPositiveInt();
		for (int i = 0; i < epoch; i++) {
			int a = NumericalGenerator.getRandomIntervalInt(-100, 100);
			int b = NumericalGenerator.getRandomIntervalInt(-100, 100);
			Assertions.assertEquals(a + b, Arithmetic.add(a, b));
			Assertions.assertEquals(a - b, Arithmetic.sub(a, b));
			Assertions.assertEquals(a * b, Arithmetic.multiply(a, b));
		}
	}
}