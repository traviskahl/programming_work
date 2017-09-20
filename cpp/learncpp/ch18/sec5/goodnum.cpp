#include <iostream>
#include <cctype>

int main() {
	int nAge;

	while (1) {
		std::cout << "Enter your age: ";
		std::cin >> nAge;

		if (std::cin.fail()) { // no extraction took place
			std::cin.clear(); // reset state bits back to goodbit so we can use ignore()
			std::cin.ignore(1000, '\n'); // clear out the bad input from stream
			continue; // try again
		}

		std::cin.ignore(1000, '\n'); // clear any additional input
		if (std::cin.gcount() > 1) // if we cleared more than one additional character
			continue; // we'll consider this input to be invalid

		if (nAge <= 0)
			continue;

		break;
	}

	std::cout << "You entered: " << nAge << std::endl;
}