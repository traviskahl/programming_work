#include <iostream>
#include <string>

class Stupid {
public:
	void operator[](std::string index);
};

// it doesn't make sense to overload operator[] to print something
// but it's the easiest way to show that the function parameter can be a non-integer
void Stupid::operator[](std::string index) {
	std::cout << index << '\n';
}

int main() {
	Stupid stupid;
	stupid["Hello world!"];
	return 0;
}