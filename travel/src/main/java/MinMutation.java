package com.pineapple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pineapple-man
 * @date 2022-05-07 22:43
 */
public class MinMutation {
	/**
	 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
	 * <p>
	 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
	 * <p>
	 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
	 * <p>
	 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
	 * <p>
	 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
	 * <p>
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/minimum-genetic-mutation 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param start
	 * 		起始基因序列
	 * @param end
	 * 		需要转变到的基因序列
	 * @param bank
	 * 		基因库
	 * @return 转换的最小步数
	 */
	public int minMutation(String start, String end, String[] bank) {
		if (start.length() != end.length()) {
			return -1;
		}
		char[] s = start.toCharArray();
		char[] t = end.toCharArray();
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(bank));
		if (!set.contains(end)) {
			return -1;
		}
		int n = s.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] != t[i]) {
				ans++;
			}
		}
		return ans;
	}
}
