#include <iostream>

int getUserInput() {
	std::cout << "Please enter an integer: ";
	int value;
	std::cin >> value;
	return value;
}

int getMathematicalOperation() {
	std::cout << "Please enter which operator you want (1=+, 2=-, 3=*, 4=/): ";

	int op;
	std::cin >> op;

	// What if the user enters an invalid character?
	// We'll ignore this possibility for now

	return op;
}

int calculateResult(int x, int op, int y) {
	// note: we use the == operator to compare two values to see if they are equal
	// we need to use if statements here because there's no direct way to convert op into the appropriate operator

	if (op == 1)
		return x + y;
	if (op == 2)
		return x - y;
	if (op == 3)
		return x * y;
	if (op == 4)
		return x / y;

	return -1; // default "error" value in case user passed in an invalid op
	// note: this isn't a good way to handle errors, since -1 could be returned as a legitimate value
}

void printResult(int result) {
	std::cout << "Your result is: " << result << std::endl;
}

int main() {
	// Get first number from user
	int input1 = getUserInput();

	// get operation from user
	int op = getMathematicalOperation();

	// get second number from user
	int input2 = getUserInput();

	// calculate result and store in temp variable
	int result = calculateResult(input1, op, input2);

	// print result
	printResult(result);
}