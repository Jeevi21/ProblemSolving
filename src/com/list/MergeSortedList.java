package com.list;

public class MergeSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode mergedHead = null;
		
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else { // Merge it here..			
			ListNode mergedTail = null;
			ListNode newNode = null;
			while (l1 != null && l2 != null) {

				if (l1.val > l2.val) {
					newNode = new ListNode(l2.val);
					l2 = l2.next;
				}
				else {
					newNode = new ListNode(l1.val);
					l1 = l1.next;
				}

				if (mergedHead == null) {
					mergedHead = newNode;
					mergedTail = newNode;
				} else {
					mergedTail.next = newNode;
					mergedTail = mergedTail.next;
				}

			}

			while (l1 != null) {
				newNode = new ListNode(l1.val);
				mergedTail.next = newNode;
				mergedTail = mergedTail.next;
				l1 =l1.next;
			}

			while (l2 != null) {
				newNode = new ListNode(l2.val);
				mergedTail.next = newNode;
				mergedTail = mergedTail.next;
				l2 =l2.next;
			}
		}
		
		return mergedHead;
	}

	public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRec(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsRec(l1, l2.next);
            return l2;
        }
    }
	
	public static void main(String[] args) {
		MergeSortedList mergeList = new MergeSortedList();
		LinkedList list1 = new LinkedList(new int[] { 1, 3, 5,8 });
		LinkedList list2 = new LinkedList(new int[] { 2, 4, 6,7 });
		ListNode mergedList = mergeList.mergeTwoLists(list1.head, list2.head);		
//		LinkedList.printList(mergedList);
		
		ListNode mergedListRec = mergeList.mergeTwoListsRec(list1.head, list2.head);
		LinkedList.printList(mergedListRec);
		

	}
}
