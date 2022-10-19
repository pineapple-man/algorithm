import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pineapple-man
 */
public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		ThreeSum t = new ThreeSum();
		List<List<Integer>> lists = t.threeSum(nums);
		System.out.println(lists.toString());
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				List<List<Integer>> list = twoSum(nums, i + 1, nums.length - 1,
						-nums[i]);
				if (list.size() > 0) {
					for (List<Integer> integers : list) {
						integers.add(nums[i]);
						ans.add(integers);
					}
				}
			}
		}
		return ans;
		
	}
	
	public List<List<Integer>> twoSum(int[] nums, int left, int right, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		int begin, end;
		begin = left;
		end = right;
		while (begin < end) {
			int temp = nums[begin] + nums[end];
			if (temp < k) {
				begin++;
			} else if (temp > k) {
				end--;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(nums[begin]);
				list.add(nums[end]);
				ans.add(list);
				begin++;
				while (begin < end && nums[begin] == nums[begin - 1]) {
					begin++;
				}
			}
		}
		return ans;
	}
}
