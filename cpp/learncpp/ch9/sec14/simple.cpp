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

	// copy constructor
	Fraction(const Fraction& copy)
		: m_numerator(copy.m_numerator), m_denominator(copy.m_denominator)
	{
		std::cout << "Copy constructor called\n"; // just to prove it works
	}

	// overloaded assignment
	Fraction& operator=(const Fraction& fraction);

	friend std::ostream& operator<<(std::ostream& out, const Fraction& f);
};

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
	out << f.m_numerator << '/' << f.m_denominator;
	return out;
}

// a simplistic implementation of operator= (see better implementation below)
Fraction& Fraction::operator=(const Fraction& fraction) {
	// do the copy
	m_numerator = fraction.m_numerator;
	m_denominator = fraction.m_denominator;

	// return the existing object so we can chain this operator
	return *this;
}

int main() {
	Fraction fiveThirds(5, 3);
	Fraction f;
	f = fiveThirds; // calls overloaded assignment
	std::cout << f << '\n';

	return 0;
}