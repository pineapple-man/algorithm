package com.pineapple.generator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author pineapple-man
 * @date 2022-05-05 12:16
 */
@Slf4j
class ArrayGeneratorTest {
	private static int epoch;
	
	@BeforeAll
	private static void init() {
		epoch = NumericalGenerator.getLittleRandomPositiveInt();
	}
	
	@Test
	void lengthFixed1dIntArray() {
		for (int i = 0; i < epoch; i++) {
			int length = NumericalGenerator.getRandomPositiveInt(20);
			int[] arr = ArrayGenerator.lengthFixed1dIntArray(length);
			log.info(Arrays.toString(arr));
		}
	}
}