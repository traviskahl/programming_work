#include <iostream>

int main() {
	std::cout << "Enter a single digit integer: ";
	int input;
	std::cin >> input;

	bool isPrime = false;
	if (input == 1 || input == 4 || input == 6 ||
		input == 8 || input == 9) {
		isPrime = false;
	}
	else {
		isPrime = true;
	}

	if (isPrime) {
		std::cout << "The digit is prime." << std::endl;
	}
	else {
		std::cout << "The digit is not prime." << std::endl;
	}

	return 0;
}