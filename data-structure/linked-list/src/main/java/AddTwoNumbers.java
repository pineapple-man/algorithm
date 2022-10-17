/**
 * @author pineapple-man
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode(0);
		ListNode tmp = ans;
		int sum = 0;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 == null ? 0 : l1.val;
			int n2 = l2 == null ? 0 : l2.val;
			sum = n1 + n2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			tmp.next = new ListNode(sum);
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			tmp = tmp.next;
		}
		
		if (carry > 0) {
			tmp.next = new ListNode(carry);
		}
		return ans.next;
	}
	
}
