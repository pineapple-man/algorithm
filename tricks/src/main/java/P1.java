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
 * @date 2022/9/16 15:12
 */

public class P1 {
	public static int solution(String str) {
		char[] chars = str.toCharArray();
		int n = chars.length;
		int[] gArray = new int[chars.length];
		int[] rArray = new int[chars.length];
		
		gArray[0] = chars[0] == 'G' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			gArray[i] = gArray[i - 1] + (chars[i] == 'G' ? 1 : 0);
		}
		rArray[n - 1] = chars[n - 1] == 'R' ? 1 : 0;
		for (int i = n - 2; i >= 0; i--) {
			rArray[i] = rArray[i + 1] + (chars[i] == 'R' ? 1 : 0);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < chars.length; i++) {
			ans = Math.min(ans, Math.min(n - gArray[i], n - rArray[i]));
		}
		return ans;
	}
	
	public static int newSolution(String str) {
		int RCount = 0;
		int n = str.length();
		char[] chars = str.toCharArray();
		for (char ch : chars) {
			RCount += ch == 'R' ? 1 : 0;
		}
		int ans = RCount;
		int leftGCount = 0;
		for (int i = 0; i < n; i++) {
			leftGCount += chars[i] == 'G' ? 1 : 0;
			RCount -= chars[i] == 'R' ? 1 : 0;
			ans = Math.min(ans, leftGCount + RCount);
		}
		ans = Math.min(ans, leftGCount + (chars[n - 1] == 'G' ? 1 : 0));
		return ans;
	}
}
