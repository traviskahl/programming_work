#include <iostream>
#include <cstdlib> // for exit()

int main() {
	using namespace std;

	cout << "Enter your age: " << endl;

	int nAge;
	cin >> nAge;

	if (nAge <= 0) {
		cerr << "Oops, you entered an invalid age!" << endl;
		exit(1);
	}

	cout << "You entered " << nAge << " years old" << endl;

	return 0;
}