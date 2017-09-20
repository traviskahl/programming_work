#include <iostream>
#include <string>

template <class T>
void swap(T &a, T &b) {
	T tmp { std::move(a) }; // invokes move constructor
	a = std::move(b); // invokes move assignment
	b = std::move(tmp); // invokes move assignment
}

int main() {
	std::string x { "abc" };
	std::string y { "de" };

	std::cout << "x: " << x << '\n';
	std::cout << "y: " << y << '\n';

	swap(x, y);

	std::cout << "x: " << x << '\n';
	std::cout << "y: " << y << '\n';

	return 0;
}