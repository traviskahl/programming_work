#include <iostream>

class Base {
public:
	virtual const char* getName() { return "Base"; } // note addition of virtual keyword
};

class Derived : public Base {
public:
	virtual const char* getName() { return "Derived"; }
};

int main() {
	Derived derived;
	Base &rBase = derived;
	std::cout << "rBase is a " << rBase.getName() << '\n';

	return 0;
}