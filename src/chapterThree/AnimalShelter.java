package chapterThree;

import java.util.LinkedList;

public class AnimalShelter {
	// the animal shelter gives up to adoption only dogs and cats, BUT it will give
	// the "oldest" dog\cat, meaning the dog\cat which entered the shelter FIRST
	// so the optimal DS is a Queue (will use a LL DS to implement the queue, since
	// it's
	// given that this is allowed)
	// return the first equal element (dog\cat strings) and remove from shelter (the
	// DS)
	// run time complexity O(n), where n is the length of the LL, could be an LL
	// full of "Cat" and the wanted dequeue is "Dog" at the end of the LL

	class Queue {
		LinkedList<String> shelterQ = new LinkedList<>();

		public void enqueue(String dogCat) {
			shelterQ.add(dogCat);
		}

		public boolean isEmpty() {
			return shelterQ.isEmpty();
		}

		public String dequeueAny() {
			if (shelterQ.isEmpty()) {
				System.err.println("Shelter is empty!");
				System.exit(1);
			}
			return shelterQ.remove(0);
		}

		public String dequeueDog() {
			if (shelterQ.isEmpty()) {
				System.err.println("Shelter is empty!");
				System.exit(1);
			}
			int i = 0;
			while (!shelterQ.get(i).equals("Dog"))
				i++;
			return shelterQ.remove(i);
		}

		public String dequeueCat() {
			if (shelterQ.isEmpty()) {
				System.err.println("Shelter is empty!");
				System.exit(1);
			}
			int i = 0;
			while (!shelterQ.get(i).equals("Cat"))
				i++;
			return shelterQ.remove(i);
		}
	}

	public static void main(String[] args) {
		AnimalShelter objAnimalShelter = new AnimalShelter();
		Queue objQueue = objAnimalShelter.new Queue();

		objQueue.enqueue("Dog");
		objQueue.enqueue("Cat");
		objQueue.enqueue("Cat");
		objQueue.enqueue("Dog");
		objQueue.enqueue("Dog");
		System.out.println(objQueue.shelterQ.toString());

		objQueue.dequeueCat();
		System.out.println(objQueue.shelterQ.toString());

		objQueue.dequeueAny();
		System.out.println(objQueue.shelterQ.toString());

		objQueue.dequeueDog();
		System.out.println(objQueue.shelterQ.toString());
	}
}

//A VERY efficient solution would be to keep TWO queues, one for dogs and another for cats, 
//then when dequeuing it'll be as easy as dequeueAny()