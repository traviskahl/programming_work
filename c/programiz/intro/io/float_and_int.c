#include <stdio.h>

int main() {
	int integer = 9876;
	float decimal = 987.6543;

	// prints the number right justified within 6 columns
	printf("4 digit integer right justified to 6 column: %6d\n", integer);

	// tries to print number right justified to 3 digits but the number is not right adjusted because there are only 4 numbers
	printf("4 digit integer right justified to 3 column: %3d\n", integer);

	// rounds to two digit places
	printf("Floating point number rounded to 2 digits: %.2f\n", decimal);

	// rounds to 0 digit places
	printf("Floating point number rounded to 0 digits: %.f\n", decimal);

	// prints the number in exponential notation(scientific notation)
	printf("Floating point number in exponential form: %e\n", decimal);

	return 0;
}
