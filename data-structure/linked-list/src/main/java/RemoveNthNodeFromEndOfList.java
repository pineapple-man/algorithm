/**
 * @author pineapple-man
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode cur, pre;
		cur = head;
		pre = null;
		while (cur != null) {
			n--;
			if (n == -1) {
				pre = head;
			} else if (n < -1) {
				assert pre != null;
				pre = pre.next;
			}
			
			cur = cur.next;
		}
		if (n > 0) {
			return head;
		}
		if (pre == null) {
			return head.next;
		}
		pre.next = pre.next.next;
		return head;
	}
}
