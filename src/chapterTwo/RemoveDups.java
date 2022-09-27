package chapterTwo;

import java.util.HashSet;

public class RemoveDups {
	// ask whether it's a singly or doubly LL (assume it's double, although this has
	// no effect in this problem)
	class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	class LinkedList {
		Node head;

		public void appendTail(int newData) {
			Node newNode = new Node(newData);
			if (head == null) {
				head = newNode;
				return;
			}
			Node iterate = head;
			while (iterate.next != null)
				iterate = iterate.next;
			iterate.next = newNode;
		}
	}

	public void removeDups(Node inputHead) {
		// an optimal solution would be O(n).
		// it is possible to solve this problem by time complexity of O(n^2), while
		// having two "iterators" running over the linked list in a double loop, one
		// would 'stand' still over the first value, and another inside loop would run
		// over all of the values, if a duplicate is found, skip it, doing:
		// x.next = x.next.next.
		// the above will also solve the follow up question (removing duplicates without
		// a temporary buffer, O(1) space).
		// the O(n) time solution would be best if a hash table is used,
		// add the data to the hash table and with each iteration check if it's already
		// there, if it is then skip it in the LL, otherwise continue looping AND adding
		// the current data to the hash table.

		Node newHead = null;
		HashSet<Integer> myHS = new HashSet<Integer>(); // O(1) time for add, remove and search operations

		while (inputHead != null) {
			if (myHS.contains(inputHead.data)) // search in time complexity of O(1) (constant)
				newHead.next = inputHead.next; // skip the duplicate data
			else {
				myHS.add(inputHead.data);
				newHead = inputHead; // create a reference
			}
			inputHead = inputHead.next;
		}
	}

	public static void main(String[] args) {
		RemoveDups objRemoveDups = new RemoveDups();
		LinkedList objLinkedList = objRemoveDups.new LinkedList();
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(1);
		objLinkedList.appendTail(1);
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(1);
		Node iterate = objLinkedList.head;
		while (iterate != null) {
			System.out.println(iterate.data);
			iterate = iterate.next;
		}
		System.out.println();
		objRemoveDups.removeDups(objLinkedList.head);
		Node iterateNew = objLinkedList.head;
		while (iterateNew != null) {
			System.out.println(iterateNew.data);
			iterateNew = iterateNew.next;
		}
	}
}