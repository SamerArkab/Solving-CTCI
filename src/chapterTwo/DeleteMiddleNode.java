package chapterTwo;

public class DeleteMiddleNode {
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

		public void insertToTail(int data) {
			Node newNode = new Node(data);
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

	// didn't notice that the given input in the question is "given only access to
	// that node" (node to be deleted)
//	public void deleteMidNode(Node head, int k) {
//		if (head == null) {
//			System.out.println("Nothing to delete.");
//			return;
//		}
//
//		Node iterate = head;
//		int llSize = 0;
//		while (iterate.next != null) {
//			llSize++;
//			iterate = iterate.next;
//		}
//
//		if (k <= 0 || k >= llSize) {
//			System.out.println("Can't delete first\\last nodes.");
//			return;
//		}
//
//		Node secondHalf = head;
//		int nextOfToDelete = 0;
//		while (nextOfToDelete <= k) {
//			secondHalf = secondHalf.next;
//			nextOfToDelete++;
//		}
//
//		Node firstHalf = head;
//		int prevOfToDelete = 0;
//		while (prevOfToDelete < k - 1) {
//			firstHalf = firstHalf.next;
//			prevOfToDelete++;
//		}
//		firstHalf.next = secondHalf;
//	}

	public void deleteMidNode(Node deleteNode) {
		// time and space complexities O(1)
		if (deleteNode.next == null) { // if it's last node in LL, can't be deleted because there's no way to
										// overwrite the node...
			System.out.println("Can't delete last node.");
			return;
		}

		Node nextNode = deleteNode.next; // simply overwrite the current node to be deleted with the next node
		deleteNode.data = nextNode.data;
		deleteNode.next = nextNode.next;
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
		DeleteMiddleNode objDeleteMiddleNode = new DeleteMiddleNode();
		LinkedList objLinkedList = objDeleteMiddleNode.new LinkedList();
		objLinkedList.insertToTail(0);
		objLinkedList.insertToTail(1);
		objLinkedList.insertToTail(2);
		objLinkedList.insertToTail(3);
		objLinkedList.insertToTail(4);
		objLinkedList.insertToTail(5);

		objDeleteMiddleNode.printLL(objLinkedList.head);

		objDeleteMiddleNode.deleteMidNode(objLinkedList.head.next.next);
		// objDeleteMiddleNode.deleteMidNode(objLinkedList.head, 0);
		// objDeleteMiddleNode.deleteMidNode(objLinkedList.head, 2);
		// objDeleteMiddleNode.deleteMidNode(objLinkedList.head, 5);

		objDeleteMiddleNode.printLL(objLinkedList.head);
	}
}