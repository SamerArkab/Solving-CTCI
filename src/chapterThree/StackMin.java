package chapterThree;

import java.util.EmptyStackException;

public class StackMin {
	// in addition to push(data) and pop() this stack will also have a min() method
	// which returns the minimum value in a stack in time complexity of O(1)

	// implement stack as a LL
	// add an integer minimum variable to Node class, with each push of new data
	// update the min variable in the specific new node to be as the new data IF it
	// is the new minimum, or as the former node's minimum if the new pushed data is
	// not the new minimum
	// in summary - save in the last pushed node the minimum value UNTIL that
	// specific node, then, when the method pop is invoked, the minimum value will
	// be at the new top node since it was already saved there
	class Node {
		int data;
		Node next;
		int min;

		public Node(int data) {
			this.data = data;
			next = null;
			min = Integer.MAX_VALUE;
		}
	}

	class Stack {
		Node top;

		public void push(int data) {
			if (top == null) {
				top = new Node(data);
				top.min = data;
				return;
			}
			Node newTop = new Node(data);
			if (data < top.min)
				newTop.min = data;
			else
				newTop.min = top.min;
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

		public int min() {
			return top.min;
		}
	}

	public static void main(String[] args) {
		StackMin objStackMin = new StackMin();
		Stack objStack = objStackMin.new Stack();
		objStack.push(0);
		objStack.push(1);
		objStack.push(-5);
		objStack.push(3);
		objStack.push(-2);

		objStack.pop(); // -5 is the min
		objStack.pop(); // -5 is still the min
		objStack.pop();// after popping -5, the new min is 0

		System.out.println(objStack.min());
	}
}