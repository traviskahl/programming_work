#include <iostream>

class Cents {
private:
	int m_cents;

public:
	Cents(int cents=0)
		: m_cents(cents)
	{
	}

	// overloaded int cast
	operator int() { return m_cents; }

	int getCents() { return m_cents; }
	void setCents(int cents) { m_cents = cents; }
};

void printInt(int value) {
	std::cout << value << '\n';
}

int main() {
	Cents cents(7);
	printInt(cents); // prints 7

	return 0;
}