package tools;

public class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int x) {
		this.value = x;
		this.next = null;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	public static ListNode createLinkedList(int[] A) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int i = 0; i < A.length; ++i) {
			ListNode newNode = new ListNode(A[i]);
			cur.next = newNode;
			cur = cur.next;
		}

		return dummy.next;		
	}
}
