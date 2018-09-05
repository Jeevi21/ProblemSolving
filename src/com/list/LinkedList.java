package com.list;

public class LinkedList {

	ListNode head;
	ListNode tail;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This generated list of range 1 to n 
	 * @param n
	 */
	public LinkedList(int n) {
		
		for(int i=1;i<=n;i++) {
			insert(i);   // We can directly access the list with head. LinkedList.head will give the access.
		}
	}
	
	/**
	 * This generates the list with given array
	 * @param arr
	 */
	public LinkedList(int [] arr) {
		
		for(int a : arr) {
			insert(a);
		}		
	}
	
	
	/**
	 * This method inserts given value at end of the list.
	 * @param val
	 */
	public void insert(int val) {
		ListNode newNode = new ListNode(val);
		if(head==null) {//First node			
			head =newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void printList() {
		ListNode cur = head;
		while(cur!=null) {
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
	
	
	public static void printList(ListNode head) {
		ListNode cur = head;
		while(cur!=null) {
			System.out.println(cur.val);
			cur=cur.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		
		list.printList();
	}
	
}


class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val) {
		// TODO Auto-generated constructor stub
		this.val= val;
		this.next=null;
	}
	
}