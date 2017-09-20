#include <iostream>

class Base {
public:
	Base() {}

	virtual void print() const { std::cout << "Base"; }

	friend std::ostream& operator<<(std::ostream& out, const Base& b) {
		out << "Base";
		return out;
	}
};

class Derived : public Base {
public:
	Derived()
		: Base()
	{
	}

	virtual void print() const override { std::cout << "Derived"; }

	friend std::ostream& operator<<(std::ostream& out, const Derived& d) {
		out << "Derived";
		return out;
	}
};

int main() {
	Base b;
	std::cout << b << '\n';

	Derived d;
	std::cout << d << '\n';

	Base& bref = d;
	std::cout << bref << '\n';

	return 0;
}