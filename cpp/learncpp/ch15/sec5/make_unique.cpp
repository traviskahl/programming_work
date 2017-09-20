#include <memory> // for std::unique_ptr
#include <iostream>

class Fraction {
private:
	int m_numerator = 0;
	int m_denominator = 1;

public:
	Fraction(int numerator=0, int denominator=1)
		: m_numerator(numerator), m_denominator(denominator)
	{
	}

	friend std::ostream& operator<<(std::ostream &out, const Fraction &f1) {
		out << f1.m_numerator << "/" << f1.m_denominator;
		return out;
	}
};

int main() {
	// Create a single dynamically allocated Fraction with numerator 3 and denominator 5
	std::unique_ptr<Fraction> f1 = std::make_unique<Fraction>(3, 5);
	std::cout << *f1 << '\n';

	// Create a dynamically allocated array of Fractions of length 4
	// We can also use automatic type deduction to good effect here
	auto f2 = std::make_unique<Fraction[]>(4);
	std::cout << f2[0] << '\n';

	return 0;
}