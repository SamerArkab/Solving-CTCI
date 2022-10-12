package chapterTwo;

public class LoopDetection {

	public Node detectLoop(Node head) {
		// this question will also depend on the references.
		// a circular LL means the next node from the tail, is the head.
		// in this question the circularity could be anywhere, not strictly between tail
		// and head nodes.
		// optimal runtime would be O(n).
		// since there is a loop somewhere, it is possible to depend on the slow\fast
		// runner approach
		// where after k steps in the slow runner, the fast runner will have done 2k,
		// now suppose k steps are the non looped part of the LL, so the fast runner
		// will have done
		// 2k-k steps in the looped part, and eventually both runners will collide.

		// had help with the solution...

		Node slowRunner = head;
		Node fastRunner = head;

		while (fastRunner != null && fastRunner.next != null) { // find collision point (loopSize-kSteps)
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
			if (slowRunner == fastRunner)// both have collided
				break;
		}

		if (fastRunner == null || fastRunner.next == null) // no meeting point, so there's no loop!
			return null;

		// move slow runner to the beginning node, keep fast runner at the collision
		// point
		// now after k steps they both will collide at the loop beginning point.
		slowRunner = head;
		while (slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}

		return fastRunner; // both runners are at the beginning of the loop!
	}
}