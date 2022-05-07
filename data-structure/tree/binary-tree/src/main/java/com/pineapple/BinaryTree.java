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
public class BinaryTree {
	public BinaryTree left;
	public BinaryTree right;
	public int value;
	
	public BinaryTree(int value) {
		this.value = value;
	}
	
}
