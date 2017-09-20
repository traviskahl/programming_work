#include <iostream>
#include <string>

void print(std::string s) {
	std::cout << s << std::endl;
}

int main() {
	using namespace std;
	string sString;

	// Assign a string value
	sString = string("One");
	print(sString);

	const string sTwo("Two");
	sString.assign(sTwo);
	print(sString);

	// Assign a c-style string
	sString = "Three";
	print(sString);

	sString.assign("Four");
	print(sString);

	// Assign a char
	sString = '5';
	print(sString);

	// Chain assignment
	string sOther;
	sString = sOther = "Six";
	cout << sString << " " << sOther << endl;

	return 0;
}