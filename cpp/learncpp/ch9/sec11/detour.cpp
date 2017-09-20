#include <cassert>
#include <iostream>

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
	out << f.m_numerator << "/" << f.m_denominator;
	return out;
}

int main() {
	Fraction fiveThirds(5, 3); // direct init a Fraction, calls Fraction(int, int) constructor
	Fraction fCopy(fiveThirds); // direct init -- with what constructor?

	std::cout << fCopy << '\n';
	return 0;
}