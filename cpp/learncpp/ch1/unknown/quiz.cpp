#include <iostream>

int doubleNumber(int num) {
	return num * 2;
}

int main() {
	std::cout << "Enter a value: ";
	int val;
	std::cin >> val;

	std::cout << doubleNumber(val) << std::endl;

	return 0;
}