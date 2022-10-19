import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pineapple-man
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap =
				new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
		for (ListNode list : lists) {
			if (list != null) {
				heap.add(list);
			}
		}
		ListNode ans = null;
		ListNode cur = null;
		while (!heap.isEmpty()) {
			ListNode head = heap.poll();
			if (head.next != null) {
				heap.add(head.next);
			}
			head.next = null;
			if (cur == null) {
				cur = head;
				ans = cur;
			} else {
				cur.next = head;
				cur = cur.next;
			}
		}
		return ans;
	}
}
