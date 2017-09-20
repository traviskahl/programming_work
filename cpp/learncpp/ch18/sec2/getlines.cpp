#include <iostream>

int main() {
	char strBuf[11];
	// Read up to 10 characters
	std::cin.getline(strBuf, 11);
	std::cout << strBuf << std::endl;

	// Read up to 10 more characters
	std::cin.getline(strBuf, 11);
	std::cout << strBuf << std::endl;

	return 0;
}