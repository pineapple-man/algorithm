package com.pineapple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pineapple-man
 */
public class Permute46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		f(nums, 0, ans);
		return ans;
	}
	
	public void f(int[] nums, int index, List<List<Integer>> ans) {
		if (index == nums.length) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int num : nums) {
				list.add(num);
			}
			ans.add(list);
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			f(nums, index + 1, ans);
			swap(nums, i, index);
			
		}
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
