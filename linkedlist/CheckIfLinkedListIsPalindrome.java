package linkedlist;
import tools.*;

public class CheckIfLinkedListIsPalindrome {

	public boolean isPalindrome(ListNode head) {

		if (head == null) {
			return true;
		}

		// find middle node
		ListNode slow = head;
		ListNode fast = head.next;	// fast node always runs twice faster than slow

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secHalf = slow.next;
		slow.next = null;

		secHalf = reverseList(secHalf);

		while (head != null && secHalf != null) {
			if (head.value != secHalf.value) {
				return false;
			}
			head = head.next;
			secHalf = secHalf.next;
		}
		return true;
	}

	private ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}

		return pre;
	}
}
