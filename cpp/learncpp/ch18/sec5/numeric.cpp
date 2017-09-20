#include <iostream>
#include <cctype>

int main() {
	int nAge;

	while (1) {
		std::cout << "Enter your age: ";
		std::cin >> nAge;

		if (std::cin.fail()) { // no extraction took place
			std::cin.clear(); // reset the state bits back to goodbit so we can use ignore()
			std::cin.ignore(1000, '\n'); // clear out the bad input from the stream
			continue; // try again
		}

		if (nAge <= 0) // make sure nAge is positive
			continue;

		break;
	}

	std::cout << "You entered: " << nAge << std::endl;
}