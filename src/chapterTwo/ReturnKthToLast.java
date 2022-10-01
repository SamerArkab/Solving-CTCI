package chapterTwo;

public class ReturnKthToLast {
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
			Node newNode = new Node(data);
			Node iterate = head;
			while (iterate.next != null)
				iterate = iterate.next;
			iterate.next = newNode;
		}
	}

	public Node returnKthtoLast(Node head, int k) {
		// Kth to last element means that we'll need to find `LastIndexElement - K`
		// The following takes O(n) in both time and space complexities
		// Find the size of LL, and then iterate from the beginning of the LL to it's
		// kth from last element
		Node iterate = head;
		int llSize = 0;
		while (iterate.next != null) { // find LL size
			llSize++;
			iterate = iterate.next;
		}

		if (llSize < k) {
			System.out.println("ERROR! No such node in LL.");
			System.exit(1);
		}

		int kthToLastIndex = llSize - k;
		iterate = head; // initialize iterator
		while (kthToLastIndex > 0) {
			iterate = iterate.next;
			kthToLastIndex--;
		}
		return iterate;
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
		ReturnKthToLast objReturnKthToLast = new ReturnKthToLast();
		LinkedList objLinkedList = objReturnKthToLast.new LinkedList();
		objLinkedList.appendTail(0);
		objLinkedList.appendTail(1);
		objLinkedList.appendTail(2);
		objLinkedList.appendTail(3);
		objLinkedList.appendTail(4);
		objReturnKthToLast.printLL(objLinkedList.head);
		Node kthToLast = objReturnKthToLast.returnKthtoLast(objLinkedList.head, 4);
		System.out.println(kthToLast.data);
	}
}