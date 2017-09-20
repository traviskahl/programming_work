#include <iostream>

int add(int x, int y) {
	return x + y;
}

int multiply(int x, int y) {
	return x * y;
}

int main() {
	std::cout << add(4, 5) << std::endl;
	std::cout << multiply(2, 3) << std::endl;

	std::cout << add(1 + 2, 3 * 4) << std::endl;

	int a = 5;
	std::cout << add(a, a) << std::endl;

	std::cout << add(1, multiply(2, 3)) << std::endl;
	std::cout << add(1, add(2, 3)) << std::endl;

	return 0;
}