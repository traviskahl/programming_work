#include <iostream>

class A {
public:
	virtual const char* getName1(int x) { return "A"; }
	virtual const char* getName2(int x) { return "A"; }
};

class B : public A {
public:
	virtual const char* getName1(short int x) { return "B"; } // note: parameter is a short int
	virtual const char* getName2(int x) const { return "B"; } // note: function is const
};

int main() {
	B b;
	A &rBase = b;
	std::cout << rBase.getName1(1) << '\n';
	std::cout << rBase.getName2(2) << '\n';

	return 0;
}