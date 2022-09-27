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

	public LinkedList returnKthtoLast() {

	}

	public static void main(String[] args) {
		ReturnKthToLast objReturnKthToLast = new ReturnKthToLast();

	}
}