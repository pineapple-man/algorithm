package com.pineapple;

import com.pineapple.generator.NumericalGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pineapple-man
 * @date 2022-05-11 13:02
 */
class ExtractBitInformationSolutionTest {
	@Test
	void extractRightestOneBit() {
		for (int i = 0; i < 20; i++) {
			int num = NumericalGenerator.getRandomInt();
			int i1 = getRightestOntBit(num);
			int i2 = ExtractBitInformationSolution.extractRightestOneBit(num);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	public static int getRightestOntBit(int a) {
		int ans = 1;
		while ((a & ans) == 0) {
			ans = ans << 1;
		}
		return ans;
	}
}