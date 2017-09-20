#include <iostream>

class Cents {
private:
	int m_cents;

public:
	Cents(int cents)
		: m_cents(cents)
	{
	}

	// overload -Cents as a member function
	Cents operator-() const;

	int getCents() { return m_cents; }
};

// note: this function is a member function!
Cents Cents::operator-() const {
	return Cents(-m_cents);
}

int main() {
	const Cents nickel(5);
	std::cout << "A nickel of debt is worth " << (-nickel).getCents() << " cents.\n";

	return 0;
}