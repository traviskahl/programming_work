#include <iostream>

class Base {
public:
	Base() {}
};

class Derived : public Base {
public:
	Derived() {}
};

int main() {
	try {
		throw Derived();
	}
	catch (Base &base) {
		std::cerr << "caught base\n";
	}
	catch (Derived &derived) {
		std::cerr << "caught derived\n";
	}

	return 0;
}