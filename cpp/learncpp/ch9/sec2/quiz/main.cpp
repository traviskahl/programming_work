#include <iostream>

class Fraction {
private:
	int m_numerator;
	int m_denominator;

	int gcd(int a, int b) {
    	return b == 0 ? a : gcd(b, a % b);
	}

	void reduce() {
		int iGCD = gcd(m_numerator, m_denominator);
		//printf("iGCD is %d\n", iGCD);
		m_numerator /= iGCD;
		m_denominator /= iGCD;
	}

public:
	Fraction(int num, int denom)
		: m_numerator(num), m_denominator(denom)
	{
		reduce();
	}

	friend Fraction operator*(const Fraction& f1, const Fraction& f2);
	friend Fraction operator*(const Fraction& f, int value);
	friend Fraction operator*(int value, const Fraction& f);

	void print() {
		std::cout << m_numerator << '/' << m_denominator << '\n';
	}
};

Fraction operator*(const Fraction& f1, const Fraction& f2) {
	int num = f1.m_numerator * f2.m_numerator;
	int denom = f1.m_denominator * f2.m_denominator;

	return Fraction(num, denom);
}

Fraction operator*(const Fraction& f, int value) {
	int num = f.m_numerator * value;
	int denom = f.m_denominator;

	return Fraction(num, denom);
}

Fraction operator*(int value, const Fraction& f) {
	return (f * value);
}

int main() {
    Fraction f1(2, 5);
    f1.print();
 
    Fraction f2(3, 8);
    f2.print();
 
    Fraction f3 = f1 * f2;
    f3.print();
 
    Fraction f4 = f1 * 2;
    f4.print();
 
    Fraction f5 = 2 * f2;
    f5.print();
 
    Fraction f6 = Fraction(1, 2) * Fraction(2, 3) * Fraction(3, 4);
    f6.print();

    return 0;
}