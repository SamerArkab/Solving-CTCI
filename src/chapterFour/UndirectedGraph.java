package chapterFour;

import java.util.ArrayList;

public class UndirectedGraph {
	ArrayList<ArrayList<Integer>> myGraph = new ArrayList<>();

	public void addEdge(int src, int dst) {
		myGraph.get(src).add(dst);
		myGraph.get(dst).add(src);
	}
}