package com.pineapple;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author pineapple-man
 * @date 2022-05-07 22:14
 */
@ToString
@EqualsAndHashCode
@Data
@NoArgsConstructor
public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
}
