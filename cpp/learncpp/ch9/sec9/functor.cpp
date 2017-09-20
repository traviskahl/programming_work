#include <iostream>

class Accumulator {
private:
	int m_counter = 0;

public:
	Accumulator()
	{
	}

	int operator()(int i) { return (m_counter += i); }
};

int main() {
	Accumulator acc;
	std::cout << acc(10) << std::endl; // prints 10
	std::cout << acc(20) << std::endl; // prints 30

	return 0;
}