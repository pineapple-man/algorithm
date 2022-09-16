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

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/16 14:16
 */

public class P1 {
	public static boolean Solution(String str) {
		char[] chars = str.toCharArray();
		int leftBracketCnt;
		leftBracketCnt = 0;
		for (char c : chars) {
			if (c == '(') {
				leftBracketCnt++;
			} else if (c == ')') {
				if (leftBracketCnt > 0) {
					leftBracketCnt--;
				} else {
					return false;
				}
			}
		}
		return leftBracketCnt == 0;
	}
	
	public static int Solution2(String str) {
		char[] chars = str.toCharArray();
		int leftBracketCnt = 0;
		int needRightBracketCnt = 0;
		for (char c : chars) {
			if (c == '(') {
				leftBracketCnt++;
			} else if (c == ')') {
				if (leftBracketCnt > 0) {
					leftBracketCnt--;
				} else {
					leftBracketCnt = 0;
					needRightBracketCnt++;
				}
			}
		}
		return leftBracketCnt + needRightBracketCnt;
	}
	
}
