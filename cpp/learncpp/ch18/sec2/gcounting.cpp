#include <iostream>

int main() {
	char strBuf[100];
	std::cin.getline(strBuf, 100);
	std::cout << strBuf << std::endl;
	std::cout << std::cin.gcount() << " characters were read" << std::endl;

	return 0;
}