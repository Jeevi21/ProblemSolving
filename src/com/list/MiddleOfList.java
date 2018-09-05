package com.list;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * @author Jeevi
 *
 */
public class MiddleOfList {
	
	
	public ListNode middleNode(ListNode head) {
		
		if(head==null)
			return null;
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
			
		while(fastPtr!=null && fastPtr.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;        
    }
	
	public static void main(String[] args) {
		MiddleOfList middleList = new MiddleOfList();
		LinkedList list = new LinkedList(5); //This creates the list with elements from 1 to 5.
		ListNode middle = middleList.middleNode(list.head);
		System.out.println(middle.val);
		
		LinkedList list1 = new LinkedList(6); //This creates the list with elements from 1 to 5.
		ListNode middle1 = middleList.middleNode(list1.head);
		System.out.println(middle1.val);
		
		
	}
	

}
