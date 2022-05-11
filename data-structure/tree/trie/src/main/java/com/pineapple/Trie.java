package com.pineapple;

/**
 * @author pineapple-man
 * @date 2022-05-11 12:24
 */
public class Trie {
	private final Node root;
	
	public Trie(Node root) {
		this.root = root;
	}
	
	/**
	 * 向前缀树中插入一个字符串
	 *
	 * @param word
	 * 		插入的字符串
	 */
	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			return;
		}
		char[] array = word.toCharArray();
		int length = array.length;
		Node current = root;
		for (char c : array) {
			current.pass++;
			if (current.path[c - 'a'] == null) {
				current.path[c - 'a'] = new Node();
			}
			current = current.path[c - 'a'];
		}
		current.end++;
	}
	
	/**
	 * 查找前缀树中为 word 的数量
	 */
	public int search(String word) {
		if (word == null || word.isEmpty()) {
			return 0;
		}
		int ans = 0;
		Node current = root;
		char[] array = word.toCharArray();
		for (char c : array) {
			Node node = current.path[c - 'a'];
			if (node != null && node.pass > 0) {
				current = node;
			} else {
				return -1;
			}
		}
		return current.end;
	}
	
	/**
	 * 从前缀树删除对应的字符串
	 *
	 * @param word
	 * 		需要删除的字符串
	 */
	public void delete(String word) {
	
	}
	
	private static class Node {
		private final Node[] path;
		private int pass;
		private int end;
		
		public Node() {
			pass = 0;
			end = 0;
			path = new Node[26];
		}
	}
}
