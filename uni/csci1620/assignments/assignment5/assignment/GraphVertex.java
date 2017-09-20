import java.util.LinkedList;
import java.awt.Point;

public class GraphVertex implements Comparable<GraphVertex> {
	private int distanceFromStart;
	private LinkedList<Point> edges;

	public static final boolean START_VERTEX = true;
	public static final boolean INTERIOR_VERTEX = false;

	public GraphVertex(boolean vertexType) {
		edges = new LinkedList<Point>();
		if (vertexType == START_VERTEX)
			setDistanceFromStart(0);
		else
			setDistanceFromStart(Integer.MAX_VALUE);
	}

	public void addEdge(int vertex, int distance) {
		edges.add(vertex);
	}

	public int getDistanceFromStart() {
		return this.distanceFromStart;
	}

	public void setDistanceFromStart(int distance) {
		this.distanceFromStart = distance;
	}

	public void relaxEdges(Graph g) {

	}

	@Override
	public int compareTo(GraphVertex gv) {
		return -1;
	}
}