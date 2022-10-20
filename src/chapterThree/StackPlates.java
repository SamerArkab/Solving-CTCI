package chapterThree;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackPlates {
	final int fullStack = 3;

	class SetOfStack {
		ArrayList<Stack<Integer>> setOfStacks = new ArrayList<>();

		// Create an array of stacks, pushing new data into a stack is done as follows:
		// if the array contains a constructed stack, and it's not full, then simply
		// push
		// else create a new stack with the new data, and add it to the array
		// As for pop, same concept, but when the stack is empty (last element is
		// removed), also delete it from the array

		// getLastStack() method is important in order to check if the array of stacks
		// is actually empty OR contains at least one stack, whose position in the array
		// will be returned

		public Stack<Integer> getLastStack() {
			if (setOfStacks.size() == 0)
				return null;
			return setOfStacks.get(setOfStacks.size() - 1);
		}

		public void push(int data) {
			Stack<Integer> lastStack = getLastStack();
			if (lastStack != null && lastStack.size() < fullStack)
				lastStack.push(data);
			else {
				Stack<Integer> newStack = new Stack<>();
				newStack.push(data);
				setOfStacks.add(newStack);
			}
		}

		public int pop() {
			Stack<Integer> lastStack = getLastStack();
			if (lastStack == null)
				throw new EmptyStackException();
			int retData = lastStack.pop();
			if (lastStack.size() == 0)
				setOfStacks.remove(setOfStacks.size() - 1);
			return retData;
		}
	}

	public static void main(String[] args) {
		StackPlates objStackPlates = new StackPlates();
		SetOfStack objSetOfStack = objStackPlates.new SetOfStack();

		objSetOfStack.push(0);
		objSetOfStack.push(1);
		objSetOfStack.push(2);
		objSetOfStack.push(3);
		objSetOfStack.push(4);
		System.out.println(objSetOfStack.setOfStacks.get(0).toString());
		System.out.println(objSetOfStack.setOfStacks.get(1).toString());

		objSetOfStack.pop();
		objSetOfStack.pop();
		objSetOfStack.pop();
		System.out.println(objSetOfStack.setOfStacks.get(0).toString());
	}
}