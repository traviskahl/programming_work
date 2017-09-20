#include <iostream>

int readNumber() {
	std::cout << "Enter a number: ";
	int val;
	std::cin >> val;
	return val;
}

void writeAnswer(int answer) {
	std::cout << answer << std::endl;
}

int main() {
	int number1 = readNumber();
	int number2 = readNumber();

	int answer = number1 + number2;
	writeAnswer(answer);

	return 0;
}