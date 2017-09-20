public class InvalidDNAStrandException extends RuntimeException {

	// Method Name:			InvalidDNAStrandException
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This is a constructor that is called without any parameters.
	public InvalidDNAStrandException() {
		super("Strand too long");
	}

	// Method Name:			InvalidDNAStrandException
	// Parameters:			molecule: char
	// Return Values:		None
	// Partners:			None
	// Description:			This constructor is called with a parameter when the given molecule is not valid.
	public InvalidDNAStrandException(char molecule) {
		super(String.format("Invalid molecule: %c, try again.", molecule));
	}

}