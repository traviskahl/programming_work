#include <iostream>
#include <string>
#include <cctype>
#include <sstream>

int main() {
	int nAge;

	while (1) {
		std::cout << "Enter your age: ";
		std::string strAge;
		std::cin >> strAge;

		// Check to make sure each character is a digit
		bool bValid = true;
		for (unsigned int nIndex = 0; nIndex < strAge.length(); ++nIndex) {
			if (!isdigit(strAge[nIndex])) {
				bValid = false;
				break;
			}
		}

		if (!bValid)
			continue;

		// At this point, we have to use something that can be converted to a number
		// So we'll use stringstream to do that conversion
		std::stringstream strStream;
		strStream << strAge;
		strStream >> nAge;

		if (nAge <= 0) // make sure nAge is positive
			continue;

		break;
	}

	std::cout << "You entered: " << nAge << std::endl;

	return 0;
}