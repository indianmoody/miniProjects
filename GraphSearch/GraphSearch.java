// @author: Gaurav Bishnoi

import java.util.*;

public class GraphSearch {

	public static void main(String[] args) {
		Graphs graph = new Graphs();
		
		// creating nodes
		GraphNode zero = new GraphNode();
		zero.name = "0";
		GraphNode one = new GraphNode();
		one.name = "1";
		GraphNode two = new GraphNode();
		two.name = "2";
		GraphNode three = new GraphNode();
		three.name = "3";
		GraphNode four = new GraphNode();
		four.name = "4";
		GraphNode five = new GraphNode();
		five.name = "5";
		
		// adding nodes to graph
		graph.nodes.add(zero);
		graph.nodes.add(one);
		graph.nodes.add(two);
		graph.nodes.add(three);
		graph.nodes.add(four);
		graph.nodes.add(five);
		
		// creating edges of graph
		zero.children.add(one);
		zero.children.add(four);
		zero.children.add(five);
		one.children.add(three);
		one.children.add(four);
		two.children.add(one);
		three.children.add(two);
		three.children.add(four);
		
		
		graph.depthSearch(zero);
		for (GraphNode m : graph.nodes) {
			m.visited = false;
		}
		System.out.println("\n");
		graph.breadthSearch(zero);

	}

}

class Graphs {
	public ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
	
	public void graphVisit(GraphNode n) {
		System.out.println(n.name);
	}
	
	// method for Depth-First Search
	public void depthSearch (GraphNode n) {
		if (n == null) {
			return;
		}
		graphVisit(n);
		n.visited = true;
		for (GraphNode m : n.children) {
			if (m.visited == false) {
				depthSearch(m);
			}
		}
	}
	
	// method for Breadth-First Search
	public void breadthSearch(GraphNode n) {
		if (n == null) {
			return;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(n);
		while (!queue.isEmpty()) {
			GraphNode m = queue.remove();
			graphVisit(m);
			m.visited = true;
			for (GraphNode r : m.children) {
				if (r.visited == false) {
					queue.add(r);
					r.visited = true;
				}
			}
		}
	}
}

class GraphNode {
	public String name;
	public ArrayList<GraphNode> children = new ArrayList<GraphNode>();
	public boolean visited = false;
}

