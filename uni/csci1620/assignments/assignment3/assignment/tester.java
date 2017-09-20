public class tester {

	public static void main(String[] args) {

		DNA deenay = new DNA("duuble");
		String lul = "ACG";
		System.out.println(stringHash(lul));

	}

	public static int stringHash(String s) {
		int ret = 0;

		for (int index = s.length() - 1; index >= 0; index--) {
			ret += charNumericValue((s.charAt(index))) * Math.pow(4, index);		
		}

		return ret;
	}

	public static int charNumericValue(char c) {

		int toReturn = -1;

		switch (c) {
			case 'A': toReturn = 0; break;
			case 'C': toReturn = 1; break;
			case 'G': toReturn = 2; break;
			case 'T': toReturn = 3; break;
			default: toReturn = -1; break;
		}

		return toReturn;

	}

}