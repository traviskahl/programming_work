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
	Fraction(const Fraction& f)
		: m_numerator(f.m_numerator), m_denominator(f.m_denominator)
	{
		// no need to check for a denominator of 0 here since f must already be a valid Fraction
		std::cout << "Copy constructor called\n";
	}

	friend std::ostream& operator<<(std::ostream& out, const Fraction& f);
	int getNumerator() { return m_numerator; }
	void setNumerator(int numerator) { m_numerator = numerator; }
};

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
	out << f.m_numerator << '/' << f.m_denominator;
	return out;
}

Fraction makeNegative(Fraction f) {
	f.setNumerator(-f.getNumerator());
	return f;
}

int main() {
	std::cout << makeNegative(6); // note the integer here

	return 0;
}