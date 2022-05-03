/*
 * Copyright (c) 2022. pineapple-man
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pineapple.generator;

/**
 * String 相关用例生成器
 *
 * @author pineapple-man
 * @version 1.0
 * @date 2022/5/3 11:06
 */


public class StringGenerator {
	private static final StringBuilder SB = new StringBuilder();
	
	/**
	 * @return 返回长度小于 100 的整型字符串
	 */
	public static String getIntString() {
		int length = NumericalGenerator.getLittleRandomPositiveInt();
		return getLengthFixedIntString(length);
	}
	
	public static String getLengthFixedIntString(int length) {
		for (int i = 0; i < length; i++) {
			SB.append(NumericalGenerator.getRandomIntervalInt(0, 9));
		}
		String generatorString = SB.toString();
		SB.delete(0, SB.length());
		return generatorString;
	}
	
	/**
	 * 生成长度随机的字母字符串
	 *
	 * @return 生成的字符串
	 */
	public static String getLowerCaseString() {
		int n = NumericalGenerator.getLittleRandomPositiveInt();
		return getLengthFixedIntString(n);
	}
	
	/**
	 * 返回最大长度的只有小写字母的字符串
	 *
	 * @param maxLength
	 * 		字符串的最大长度
	 * @return 生成的字符串
	 */
	public static String getRandomLengthLowerCaseString(int maxLength) {
		int n = NumericalGenerator.getRandomPositiveInt(maxLength);
		return getLengthFixedLowerCaseString(n);
	}
	
	/**
	 * 生成长度固定的字母字符串
	 *
	 * @param length
	 * 		字符串长度
	 * @return 生成的字母字符串
	 */
	public static String getLengthFixedLowerCaseString(int length) {
		for (int i = 0; i < length; i++) {
			// 'a' -> 97 'z' -> 122
			int random = NumericalGenerator.getRandomIntervalInt(97, 122);
			SB.append(Character.valueOf((char) random));
		}
		String generatorString = SB.toString();
		SB.delete(0, SB.length());
		return generatorString;
	}
}
