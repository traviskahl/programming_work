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
	Fraction(const Fraction& fraction)
		: m_numerator(fraction.m_numerator), m_denominator(fraction.m_denominator)
		// note: we can access the members of parameter fraction directly, because we're inside the Fraction class
	{
		// no need to check for a denominator of 0 here since fraction must already be a valid Fraction
		std::cout << "Copy constructor called\n"; // just to prove it works
	}

	friend std::ostream& operator<<(std::ostream& out, const Fraction& f);
};

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
	out << f.m_numerator << '/' << f.m_denominator;
	return out;
}

int main() {
	Fraction fiveThirds(5, 3); // direct initialize a Fraction calls Fraction(int, int) constructor
	Fraction fCopy(fiveThirds); // direct initialize -- with Fraction copy constructor
	std::cout << fCopy << '\n';

	return 0;
}