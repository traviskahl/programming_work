#include <iostream>
#include <cassert>

class Fraction {
private:
	int m_numerator;
	int m_denominator;

public:
	// default constructor
	Fraction(int numerator=0, int denominator=1)
		: m_numerator(numerator), m_denominator(denominator)
	{
		assert(denominator != 0);
	}

	friend std::ostream& operator<<(std::ostream& out, const Fraction& f);
};

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
	out << f.m_numerator << '/' << f.m_denominator;
	return out;
}

int main() {
	Fraction six = Fraction(6);
	std::cout << six;
	return 0;
}