package chapterThree;

import java.util.EmptyStackException;

public class ThreeInOne {
	// One method would be to divide the array size by 3 and build each stack
	// depending on third of the array's data

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public class Stack {
		// implement as a sort of LL
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
			int dataPop = top.data;
			top = top.next;
			return dataPop;
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

	public static void main(String[] args) {
		// Most of this problem implementation is done "manually" in `main`, of course
		// it is possible to do it through a dynamic method which receives the number of
		// stacks, builds them (using an ArrayList for example) then does basically
		// the same as follows:

		ThreeInOne objThreeInOne = new ThreeInOne();
		Stack first = objThreeInOne.new Stack();
		Stack second = objThreeInOne.new Stack();
		Stack third = objThreeInOne.new Stack();
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < arr.length / 3; i++)
			first.push(arr[i]);
		for (int i = arr.length / 3; i < 2 * arr.length / 3; i++)
			second.push(arr[i]);
		for (int i = 2 * arr.length / 3; i < arr.length; i++)
			third.push(arr[i]);

		for (int i = 0; i < arr.length / 3; i++) {
			System.out.println(first.pop() + "\t" + second.pop() + "\t" + third.pop());
		}
	}
}