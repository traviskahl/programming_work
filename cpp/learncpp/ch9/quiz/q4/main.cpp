#include <iostream>
#include <cstdint>
#include <cmath>

class FixedPoint2 {
private:
	int16_t m_whole;
	int8_t m_decimal;

public:
	FixedPoint2(int whole, int decimal) {
		// we want to store both parts as the same sign
		// if either only whole or whole and decimal are negative
		if (whole < 0) {
			if (decimal < 0) {
				// if both are negative, we don't need to do anything sign-wise
				m_whole = whole;
				m_decimal = decimal;
			}
			else {
				// otherwise if just whole is negative we need to change the sign of decimal
				m_whole = whole;
				m_decimal = -decimal;
			}
		}
		else if (decimal < 0) { // if only decimal is negative we need to change whole
			m_whole = -whole;
			m_decimal = decimal;
		}
		else {
			m_whole = whole;
			m_decimal = decimal;
		}
	}

	FixedPoint2(double value) {
		m_whole = static_cast<int>(value);
		m_decimal = round((value - m_whole) * 100);
	}

	operator double() const { return m_whole + (static_cast<double>(m_decimal) / 100); }

	friend std::ostream& operator<<(std::ostream& out, FixedPoint2& fp);
	friend std::istream& operator>>(std::istream& in, FixedPoint2& fp);

	friend bool operator==(const FixedPoint2& fp1, const FixedPoint2& fp2);
	friend FixedPoint2 operator+(const FixedPoint2& fp1, const FixedPoint2& fp2);

};

FixedPoint2 operator-(const FixedPoint2& fp) {
	return FixedPoint2(-(static_cast<double>(fp)));
}

bool operator==(const FixedPoint2& fp1, const FixedPoint2& fp2) {
	return (static_cast<double>(fp1) == static_cast<double>(fp2));
}

FixedPoint2 operator+(const FixedPoint2& fp1, const FixedPoint2& fp2) {
	return FixedPoint2(static_cast<double>(fp1) + static_cast<double>(fp2));
}

std::istream& operator>>(std::istream& in, FixedPoint2& fp) {
	double input;
	in >> input;
	fp = input;
	return in;
}

std::ostream& operator<<(std::ostream& out, FixedPoint2& fp) {
	out << static_cast<double>(fp);
	return out;
}

void testAddition() {
	// h/t to reader Sharjeel Safdar for this function
	std::cout << std::boolalpha;
	std::cout << (FixedPoint2(0.75) + FixedPoint2(1.23) == FixedPoint2(1.98)) << '\n'; // both positive, no decimal overflow
	std::cout << (FixedPoint2(0.75) + FixedPoint2(1.50) == FixedPoint2(2.25)) << '\n'; // both positive, with decimal overflow
	std::cout << (FixedPoint2(-0.75) + FixedPoint2(-1.23) == FixedPoint2(-1.98)) << '\n'; // both negative, no decimal overflow
	std::cout << (FixedPoint2(-0.75) + FixedPoint2(-1.50) == FixedPoint2(-2.25)) << '\n'; // both negative, with decimal overflow
	std::cout << (FixedPoint2(0.75) + FixedPoint2(-1.23) == FixedPoint2(-0.48)) << '\n'; // second negative, no decimal overflow
	std::cout << (FixedPoint2(0.75) + FixedPoint2(-1.50) == FixedPoint2(-0.75)) << '\n'; // second negative, possible decimal overflow
	std::cout << (FixedPoint2(-0.75) + FixedPoint2(1.23) == FixedPoint2(0.48)) << '\n'; // first negative, no decimal overflow
	std::cout << (FixedPoint2(-0.75) + FixedPoint2(1.50) == FixedPoint2(0.75)) << '\n'; // first negative, possible decimal overflow
}
 
int main() {
	testAddition();
 
	FixedPoint2 a(-0.48); 
	std::cout << a << '\n';
 
	std::cout << -a << '\n';
 
	std::cout << "Enter a number: "; // enter 5.678
	std::cin >> a;
	
	std::cout << "You entered: " << a << '\n';
 
	return 0;
}