package chapterTwo;

public class Partition {
	// Ask if LL is Singly or Doubly (assume it's Singly)
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
			Node iterate = head;
			while (iterate.next != null)
				iterate = iterate.next;
			iterate.next = new Node(data);
		}

		// for this problem it is necessary to implement the appendHead method as well
		public void appendHead(int data) {
			if (head == null) {
				head = new Node(data);
				return;
			}
			Node newHead = new Node(data);
			newHead.next = head;
			head = newHead;
		}
	}

	public Node partition(Node head, int pivot) {
		// optimal runtime complexity is O(n)
		// one possibility is to create a new LL and append to tail or head while
		// comparing to data to the chosen pivot element
		Node iterate = head;
		LinkedList newLL = new LinkedList();
		while (iterate != null) {
			if (iterate.data < pivot)
				newLL.appendHead(iterate.data);
			else
				newLL.appendTail(iterate.data);
			iterate = iterate.next;
		}
		return newLL.head;
	}

	public void printLL(Node head) {
		Node iterate = head;
		while (iterate != null) {
			System.out.print(iterate.data + " ");
			iterate = iterate.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Partition objPartition = new Partition();
		LinkedList objLinkedList = objPartition.new LinkedList();
		objLinkedList.appendTail(9);
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(1);
		objLinkedList.appendTail(6);
		objLinkedList.appendHead(2);
		objLinkedList.appendTail(5);
		objLinkedList.appendTail(2);

		objPartition.printLL(objLinkedList.head);
		objLinkedList.head = objPartition.partition(objLinkedList.head, 3); // example of pivot not in LL
		objPartition.printLL(objLinkedList.head);
		// only requirement for the partition element is to be on the "right partition".
	}
}