package chapterThree;

import java.util.EmptyStackException;

public class SortStack {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	class Stack {
		Node top;

		public void push(int data) {
			if (top == null) {
				top = new Node(data);
				return;
			}
			Node newTop = new Node(data);
			newTop.next = top;
			top = newTop;
		}

		public int pop() {
			if (top == null)
				throw new EmptyStackException();
			int retData = top.data;
			top = top.next;
			return retData;
		}

		public int peek() {
			if (top == null)
				throw new EmptyStackException();
			return top.data;
		}

		public boolean isEmpty() {
			return top == null;
		}
	}

	public void printLL(Node top) {
		Node iterate = top;
		while (iterate != null) {
			System.err.print(iterate.data + " ");
			iterate = iterate.next;
		}
		System.out.println();
	}

	// sort a stack such that the smallest items are on the top (allowed to use only
	// one additional, temporary, stack).
	// since a stack is of LIFO concept and the program is required to keep the
	// smallest items on top, the thought process is "how will I shift the elements
	// between two stacks?"
	// because the additional stack is temporary, what needs to be done is as
	// follows:
	// pop the top element from the given stack,
	// check if it's smaller than the temp stack, if it is then move all of the
	// bigger elements into the given stack
	// else, just push it into the temp stack
	// after this step is finished, we'll have a sorted temp stack while the biggest
	// elements are on top
	// and just pushing them into the given stack, in that order, will give us the
	// reverse and wanted result.
	// Run time complexity is O(n^2)!

	public void sortStack(Stack top) {
		Stack tempStack = new Stack();
		while (!top.isEmpty()) {
			int tempElement = top.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > tempElement)
				top.push(tempStack.pop());
			tempStack.push(tempElement);
		}
		while (!tempStack.isEmpty())
			top.push(tempStack.pop());
	}

	public static void main(String[] args) {
		SortStack objSortStack = new SortStack();
		Stack objStack = objSortStack.new Stack();

		objStack.push(0);
		objStack.push(5);
		objStack.push(4);
		objStack.push(7);
		objStack.push(10);
		objStack.push(1);
		objStack.push(2);
		objStack.push(8);

		objSortStack.printLL(objStack.top); // 8 2 1 10 7 4 5 0

		objSortStack.sortStack(objStack);
		objSortStack.printLL(objStack.top); // sorted: 0 1 2 4 5 7 8 10
	}
}