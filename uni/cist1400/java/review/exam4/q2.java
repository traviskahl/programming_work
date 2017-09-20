public class q2 {
	public static void main(String[] args) {
		int sum;
		int[][] grid;
		for (int currentColumn = 0; currentColumn < grid.length; currentColumn +=3) {
			for (int currentRow = 0; currentRow < grid.length; currentRow++) {
				sum += grid[currentRow][currentColumn];
			}
		}
	}
}