package chapterTwo;

public class SumLists {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	class LinkedList {
		Node head;

		public void appendTail(int data) {
			if (head == null) {
				head = new Node(data);
				return;
			}
			Node iterator = head;
			while (iterator.next != null)
				iterator = iterator.next;
			iterator.next = new Node(data);
		}
	}

	public void printLL(Node head) {
		Node iterator = head;
		while (iterator != null) {
			System.out.print(iterator.data + " ");
			iterator = iterator.next;
		}
		System.out.println();
	}

	// receive two numbers, each one as a REVERSED list
	// (meaning 7->1->6 is the number 617)
	// optimal runtime complexity would be O(n+m) and also for space, since we need to
	// create a new node to return
	// one way is to add them using the "long addition" method:
	// 617 +
	// 295
	// which is 5+7=12, we use the 2 and add the 1 to 1+9 making it 1+9+1=11, take
	// the 1 and add the 1 to 6+2 and so on

	// **there is repetitive code which can be encapsulated into one private method
	// and then called when needed (3 times in total)**
	public Node sumLists(Node first, Node second) {
		Node iteratorFirst = first;
		Node iteratorSecond = second;

		LinkedList sumLL = new LinkedList();
		Node sumIterator = new Node(0);
		int sumTenAbove = 0;

		while (iteratorFirst != null && iteratorSecond != null) { // meaning the iterations are still of the same
																	// 'index' on both lists
			sumIterator.data += iteratorFirst.data + iteratorSecond.data;
			if (sumIterator.data > 9) {
				sumIterator.data -= 10; // sum result is obviously between 0-18, so subtracting the 10 is enough
				sumTenAbove++; // add the 'carry'
			}

			sumLL.appendTail(sumIterator.data); // building the number in reversed order
			sumIterator.next = new Node(sumTenAbove); // initialize with 0 or 1 in case there's carry or not

			sumTenAbove = 0;
			sumIterator = sumIterator.next;
			iteratorFirst = iteratorFirst.next;
			iteratorSecond = iteratorSecond.next;
		}

		// if first/second node is longer than the other (for instance, 100+99999)
		while (iteratorFirst != null) {
			sumIterator.data += iteratorFirst.data;
			if (sumIterator.data > 9) {
				sumIterator.data -= 10;
				sumTenAbove++;
			}

			sumLL.appendTail(sumIterator.data);
			sumIterator.next = new Node(sumTenAbove);

			iteratorFirst = iteratorFirst.next;
			sumIterator = sumIterator.next;
			sumTenAbove = 0;
		}

		while (iteratorSecond != null) {
			sumIterator.data += iteratorSecond.data;
			if (sumIterator.data > 9) {
				sumIterator.data -= 10;
				sumTenAbove++;
			}

			sumLL.appendTail(sumIterator.data);
			sumIterator.next = new Node(sumTenAbove);

			iteratorSecond = iteratorSecond.next;
			sumIterator = sumIterator.next;
			sumTenAbove = 0;
		}

		if (sumIterator.data != 0) // meaning there was 1 carry left on the end result
			sumLL.appendTail(sumIterator.data);

		return sumLL.head;
	}

	public static void main(String[] args) {
		SumLists objSumLists = new SumLists();
		LinkedList objLinkedList = objSumLists.new LinkedList();
//		objLinkedList.appendTail(7);
//		objLinkedList.appendTail(1);
//		objLinkedList.appendTail(6);
//		objLinkedList.appendTail(9);
//		objLinkedList.appendTail(4);
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(1);
		objSumLists.printLL(objLinkedList.head);

		LinkedList objLinkedList2 = objSumLists.new LinkedList();
//		objLinkedList2.appendTail(5);
//		objLinkedList2.appendTail(9);
//		objLinkedList2.appendTail(2);
		objLinkedList2.appendTail(9);
		objLinkedList2.appendTail(9);
		objLinkedList2.appendTail(9);
		objLinkedList2.appendTail(9);
		objLinkedList2.appendTail(9);
		objSumLists.printLL(objLinkedList2.head);

		LinkedList objSum = objSumLists.new LinkedList();
		objSum.head = objSumLists.sumLists(objLinkedList.head, objLinkedList2.head);
		objSumLists.printLL(objSum.head);
	}
}

//FOLLOW UP: solve the above if the digits are stored in FORWARD order.
/*
 * in order to keep the solution in O(N) time complexity, we'll need to know the
 * length of each LL, then it's similar to the above implementation while
 * appending to the head of the solution LL
 */