#include <iostream>
#include <stdexcept>

class Fraction {
private:
	int m_numer;
	int m_denom;

public:
	Fraction(int numer, int denom) try
		: m_numer(numer), m_denom(denom)
	{
		if (m_denom == 0)
			throw std::runtime_error("Your fraction has an invalid denominator.");
	}
	catch (std::runtime_error &error) {
		throw;
	}

	int getNumer() { return m_numer; }
	int getDenom() { return m_denom; }
};

int main() {
	std::cout << "Enter the numerator: ";
	int numer;
	std::cin >> numer;

	std::cout << "Enter the denominator: ";
	int denom;
	std::cin >> denom;

	Fraction *f = nullptr;

	try {
		f = new Fraction(numer, denom);
		std::cout << "The fraction is: " << f->getNumer() << '/' << f->getDenom() << '\n';

		delete f;
	}
	catch (std::runtime_error &error) {
		std::cerr << error.what() << std::endl;
		delete f;
	}

	return 0;
}