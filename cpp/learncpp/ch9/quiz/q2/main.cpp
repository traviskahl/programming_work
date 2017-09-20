#include <iostream>
#include <cstdint>

class Average {
private:
	int32_t m_sum;
	int8_t m_seen;

public:
	// default constructor
	Average()
		: m_sum(0), m_seen(0)
	{
	}

	// += operator
	Average& operator+=(int value);

	// overloaded operator<< for output
	friend std::ostream& operator<<(std::ostream& out, const Average& a);
};

Average& Average::operator+=(int value) {
	m_sum += value;
	++m_seen;
	return *this; // return the implicit object for chaining
}

std::ostream& operator<<(std::ostream& out, const Average& a) {
	out << static_cast<double>(a.m_sum) / a.m_seen;
	return out;
}

int main() {
	Average avg;
	
	avg += 4;
	std::cout << avg << '\n'; // 4 / 1 = 4
	
	avg += 8;
	std::cout << avg << '\n'; // (4 + 8) / 2 = 6

	avg += 24;
	std::cout << avg << '\n'; // (4 + 8 + 24) / 3 = 12

	avg += -10;
	std::cout << avg << '\n'; // (4 + 8 + 24 - 10) / 4 = 6.5

	(avg += 6) += 10; // 2 calls chained together
	std::cout << avg << '\n'; // (4 + 8 + 24 - 10 + 6 + 10) / 6 = 7

	Average copy = avg;
	std::cout << copy << '\n';

	return 0;
}