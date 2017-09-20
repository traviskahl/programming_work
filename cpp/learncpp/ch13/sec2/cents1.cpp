#include <iostream>

template <typename T>
const T& max(const T& x, const T& y) {
	return (x > y) ? x : y;
}

class Cents {
private:
	int m_cents;

public:
	Cents(int cents)
		: m_cents(cents)
	{
	}
};

int main() {
	Cents nickle(5);
	Cents dime(10);

	Cents bigger = max(nickle, dime);

	return 0;
}