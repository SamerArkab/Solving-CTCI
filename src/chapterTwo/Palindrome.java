package chapterTwo;

import java.util.Stack;

public class Palindrome {
	class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
			next = null;
		}
	}

	class LinkedList {
		Node head;

		public void appendTail(char data) {
			if (head == null) {
				head = new Node(data);
				return;
			}
			Node iterate = head;
			while (iterate.next != null)
				iterate = iterate.next;
			iterate.next = new Node(data);
		}
	}

	public void printLL(Node head) {
		Node iterate = head;
		while (iterate != null) {
			System.out.print(iterate.data + " ");
			iterate = iterate.next;
		}
		System.out.println();
	}

	public boolean isPalindrome(Node head) {
		// optimal time complexity is O(n)
		// assume we're using ASCII code
		// using the hints mentioned in the book, one possible approach is using a stack
		// this technique will require iterating over half of the LL
		// and pushing it's data in a stack,
		// afterwards we'll pop the stack while comparing it's data with the second half
		// in order to iterate over halves of the LL, it's possible to use the
		// fast\slow runner method, meaning we'll have one slow iterator over the list,
		// which moves one node at a time, and another which jumps two nodes at a time
		// finally, if the LL length is odd, we'll move the slow runner to the next
		// node, since in that case the middle node data doesn't matter
		Stack<Character> myStack = new Stack<Character>();
		Node slowRunner = head, fastRunner = head;
		while (fastRunner != null && fastRunner.next != null) {
			myStack.push(slowRunner.data);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}
		if (fastRunner != null) // this means LL is of odd length, thus slow runner needs to move to the middle
								// node
			slowRunner = slowRunner.next;

		// now we'll check the second half and whether this list is a palindrome
		while (slowRunner != null) {
			char compare = myStack.pop();
			if (slowRunner.data != compare)
				return false;
			slowRunner = slowRunner.next;
		}
		return true;
	}

	public static void main(String[] args) {
		Palindrome objPalindrome = new Palindrome();
		LinkedList objLinkedList = objPalindrome.new LinkedList();

		objLinkedList.appendTail('1');
		objLinkedList.appendTail('a');
		objLinkedList.appendTail('b');
		// objLinkedList.appendTail('b');
		objLinkedList.appendTail('a');
		objLinkedList.appendTail('1');
		objPalindrome.printLL(objLinkedList.head);
		System.out.println(objPalindrome.isPalindrome(objLinkedList.head));
	}
}