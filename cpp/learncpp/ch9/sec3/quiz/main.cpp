#include <iostream>
 
class Fraction {
private:
	int m_numerator;
	int m_denominator;
 
public:
	Fraction(int numerator=0, int denominator=1)
		: m_numerator(numerator), m_denominator(denominator)
	{
		// We put reduce() in the constructor to ensure any new fractions we make get reduced!
		// Any fractions that are overwritten will need to be re-reduced
		reduce();
	}
 
	// We'll make gcd static so that it can be part of class Fraction without requiring an object of type Fraction to use
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
 
	void reduce() {
		int gcd = Fraction::gcd(m_numerator, m_denominator);
		m_numerator /= gcd;
		m_denominator /= gcd;
	}
 
	friend Fraction operator*(const Fraction &f1, const Fraction &f2);
	friend Fraction operator*(const Fraction &f1, int value);
	friend Fraction operator*(int value, const Fraction &f1);

	friend std::ostream& operator<<(std::ostream& out, const Fraction& f);
	friend std::istream& operator>>(std::istream& in, Fraction& f);
 
	void print() {
		std::cout << m_numerator << "/" << m_denominator << "\n";
	}
};
 
Fraction operator*(const Fraction &f1, const Fraction &f2) {
	return Fraction(f1.m_numerator * f2.m_numerator, f1.m_denominator * f2.m_denominator);
}
 
Fraction operator*(const Fraction &f1, int value) {
	return Fraction(f1.m_numerator * value, f1.m_denominator);
}
 
Fraction operator*(int value, const Fraction &f1) {
	return Fraction(f1.m_numerator * value, f1.m_denominator);
}

std::istream& operator>>(std::istream& in, Fraction& f) {
	in >> f.m_numerator;
	char slash;
	in >> slash; // we want to get rid of the line that separates numerator from denominator
	in >> f.m_denominator;

	// clear the buffer in case the user entered some funky stuff afterwards
	in.clear();
	in.ignore(32767, '\n');

	return in;
}

std::ostream& operator<<(std::ostream& out, const Fraction& f) {
	out << f.m_numerator << "/" << f.m_denominator;
	return out;
}

int main()
{
 
	Fraction f1;
	std::cout << "Enter fraction 1: ";
	std::cin >> f1;
 
	Fraction f2;
	std::cout << "Enter fraction 2: ";
	std::cin >> f2;
 
	std::cout << f1 << " * " << f2 << " is " << f1 * f2 << '\n';
 
	return 0;
}