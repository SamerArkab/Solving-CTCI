package chapterTwo;

public class Intersection {
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

		public void appendToTail(int data) {
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

	public Node doIntersect(Node first, Node second) {
		// it's explicitly specified in the question, that the intersection is defined
		// based on reference!
		// meaning the "pointer" to the memory address.
		// in order to find such node, we'll have to check a few things:
		// is the last node on both LL's the same? if not, then there's no intersection
		// else, run through both nodes and compare their references, when they're the
		// same, it means this is the intersection node - return it
		// from hints: if the two LL's aren't of the same length, will need to fix that
		// (in order to properly find the intersection)
		// this could be done by ignoring the first nodes of the longer LL and starting
		// the count afterwards
		// optimal run time is O(n+m) depending on the LL's lengths
		Node intersection = null;

		Node firstTail = first;
		Node iterateFirst = first;
		int firstLLSize = 0;
		while (iterateFirst != null) {
			firstLLSize++;
			firstTail = iterateFirst;
			iterateFirst = iterateFirst.next;
		}
		Node secondTail = second;
		Node iterateSecond = second;
		int secondLLSize = 0;
		while (iterateSecond != null) {
			secondLLSize++;
			secondTail = iterateSecond;
			iterateSecond = iterateSecond.next;
		}

		// initialize iterators
		iterateFirst = first;
		iterateSecond = second;
		if (firstLLSize > secondLLSize) {
			int counter = firstLLSize - secondLLSize;
			while (counter > 0 && iterateFirst != null) {
				iterateFirst = iterateFirst.next;
				counter--;
			}
		} else if (firstLLSize < secondLLSize) {
			@SuppressWarnings("unused")
			int counter = secondLLSize - firstLLSize;
			while (secondLLSize - firstLLSize > 0 && iterateSecond != null) {
				iterateSecond = iterateSecond.next;
				counter--;
			}
		}
		// if both LL's are of equal length, there'd be no need to iterate on either
		// now to check if the LL's will eventually intersect:
		if (firstTail != secondTail) {
			System.out.println("Linked Lists do no intersect!");
			return null;
		}

		// meaning they will intersect, so find the intersection node:
		while (iterateFirst != null && iterateSecond != null) {
			if (iterateFirst == iterateSecond) {
				intersection = iterateFirst;
				break;
			}
			iterateFirst = iterateFirst.next;
			iterateSecond = iterateSecond.next;
		}

		System.out.println("Linked Lists do intersect.");
		return intersection;
	}

	public void printLL(Node intersection) {
		Node iterate = intersection;
		while (iterate != null) {
			System.out.print(iterate.data + " ");
			iterate = iterate.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Intersection objIntersection = new Intersection();

		LinkedList objLinkedList = objIntersection.new LinkedList();
		objLinkedList.appendToTail(0);
		objLinkedList.appendToTail(1);
		objLinkedList.appendToTail(2);
		objLinkedList.appendToTail(3);

		LinkedList objLinkedList2 = objIntersection.new LinkedList();
		objLinkedList2.appendToTail(4);
		objLinkedList2.head.next = objLinkedList.head.next.next; // example: node data = 2 is the intersection

		Node intersection = objIntersection.doIntersect(objLinkedList.head, objLinkedList2.head);
		objIntersection.printLL(intersection);
	}
}