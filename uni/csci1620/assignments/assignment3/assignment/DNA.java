public class DNA {

	private String strandString;
	private DNA bestMatch;
	private String substringMatch;

	// Method Name:			DNA
	// Parameters:			strand: String
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the DNA class.
	public DNA(String strand) {
		setStrand(strand);
		bestMatch = null;
		substringMatch = "";
	}

	// Method Name:			getStrand
	// Parameters:			None
	// Return Values:		the strandString data member: String
	// Partners:			None
	// Description:			This method returns the strandString data member.
	public String getStrand() {
		return this.strandString;
	}

	// Method Name:			setStrand
	// Parameters:			strand: String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the strandString data member.
	public void setStrand(String strand) {
		this.strandString = strand;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		String ret = new String();

		ret += String.format("DNA Strand: %s", this.strandString);

		if (bestMatch == null) {
			ret += "No match found\n";
		}
		else {
			ret += String.format("Best Match Strand: %s", this.bestMatch.getStrand());
			ret += String.format("Matching Substring: %s", this.substringMatch);
		}

		return ret;
	}

	// Method Name:			checkMatch
	// Parameters:			matchCandidate: DNA
	// Return Values:		None
	// Partners:			None
	// Description:			This method checks if the passed DNA has a longer substring than is currently stored.
	//						It calls upon the RabinKarp method.
	public void checkMatch(DNA matchCandidate) {

	}

	// Method Name:			RabinKarp
	// Parameters:			find: String
	// Return Values:		The string as a hash: int
	// Partners:			None
	// Description:			This method does preprocessing 
	private int RabinKarp(String find) {
		return -1;
	}

	// Method Name:			stringHash
	// Parameters:			s: String
	// Return Values:		The hashed parameter: int
	// Partners:			None
	// Description:			This method hashes an entire string.
	private int stringHash(String s) {
		int ret = 0;

		for (int index = s.length() - 1; index >= 0; index--) {
			ret += charNumericValue((s.charAt(index))) * Math.pow(4, index);		
		}

		return ret;
	}

	// Method Name:			charNumericValue
	// Parameters:			c: char
	// Return Values:		The value of the parameter in the base 4 system: int
	// Partners:			None
	// Description:			This method returns the value of the passed char in base 4.
	private int charNumericValue(char c) {

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

	// Method Name:			RabinKarpHashes
	// Parameters:			All hashes: int[] , the current position and the length of the substrings: int
	// Return Values:		A hash value: int
	// Partners:			None
	// Description:			This method recursively finds all the hash values of all substrings of size length
	//						in the array starting at pos.
	private int RabinKarpHashes(int[] hashes, int pos, int length) {
		int ret = 0;

		if (pos + length >= hashes.length) {
			return -1;
		}
		else {
			
		}
	}

	// Method Name:			linearSearchRecursive
	// Parameters:			An array to search: int[] , a search key and a position: int
	// Return Values:		The position of the key in the array: int
	// Partners:			None
	// Description:			This method searches an array recursively.
	private int linearSearchRecursive(int[] data, int key, int pos) {
		int ret = 0;

		System.out.println("Pos is: " + pos);

		if (pos == data.length) {
			ret =  -1;
		}
		else if (data[pos] == key) {
			ret = key;
		}
		else {
			ret = linearSearchRecursive(data, key, pos+1);
		}

		return ret;		
	}

}