import java.util.ArrayList;

public class around {

	private class KitType {

		public String m_type;
		public int m_cost;

		public KitType(String type, int cost) {
			m_type = type;
			m_cost = cost;
		}

		public String toString() { return String.format("%s,%d\n", m_type, m_cost); }
	}

	public around() {
		ArrayList<KitType> testAL = new ArrayList<KitType>();

		for (int x = 0; x < 5; x++) {
			testAL.add(new KitType("type"+x, x+7));

			System.out.println(testAL.get(x));
		}

		// now search it
		int cost = -1;
		for (int x = 0; x < testAL.size(); ++x) {
			if (testAL.get(x).m_type.equals("type3")) {
				cost = testAL.get(x).m_cost;
			}
		}

		System.out.println(cost);
	}

	public static void main(String[] args) {
		around progDriver = new around();
	}
}