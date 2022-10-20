package chapterThree;

import java.util.EmptyStackException;

public class QueueViaStacks {
	// A Queue is a DS which works on the concept of FIFO.
	// building a queue using stacks, will require the use of a second stack
	// in order to reach the first pushed element
	// So, implementing this would be as follows:
	// first stack will be used to normally push the data into the stack
	// meaning first stack will be of LIFO concept and this shouldn't be a concern
	// for any changes since it's "only" loading the data into the DS
	// but when popping an element (or peeking) we'll need to move all elements
	// from the first stack to the second stack by popping from first and pushing
	// into second stack (and continue pushing normally)

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

		public void printStack() {
			Node iterator = top;
			while (iterator != null) {
				System.out.print(iterator.data + " ");
				iterator = iterator.next;
			}
			System.out.println();
		}
	}

	class MyQueue {
		Stack firstStack = new Stack(); // "normal" stack
		Stack secondStack = new Stack(); // the "queue" as this stack will be of FIFO concept

		public void add(int data) {
			firstStack.push(data);
		}

		private void moveToFifo() { // make sure all elements from first stack are moved to the second
			while (!firstStack.isEmpty())
				secondStack.push(firstStack.pop()); // "remove" from first stack and load into the second
		}

		public int remove() {
			moveToFifo();
			int retData = secondStack.pop();
			return retData;
		}

		public int peek() {
			moveToFifo();
			return secondStack.peek();
		}

		public boolean isEmpty() {
			return firstStack == null;
		}
	}

	public static void main(String[] args) {
		QueueViaStacks objQueueViaStacks = new QueueViaStacks();
		MyQueue objMyQueue = objQueueViaStacks.new MyQueue();

		System.out.println(objMyQueue.isEmpty());

		objMyQueue.add(0);
		objMyQueue.add(1);
		objMyQueue.add(2);
		objMyQueue.add(3);
		objMyQueue.add(4);
		objMyQueue.firstStack.printStack(); // will be a normal stack

		objMyQueue.remove();
		objMyQueue.secondStack.printStack(); // FIFO, so remove the "0" data
		System.out.println(objMyQueue.peek()); // return the "1" data
	}
}