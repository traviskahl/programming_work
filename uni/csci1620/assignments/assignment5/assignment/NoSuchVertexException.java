public class NoSuchVertexException extends RuntimeException {

	public NoSuchVertexException(int vert) {
		super(String.format("Vertex does not exist: %d", vert));
	}
}