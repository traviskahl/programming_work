#include <iostream>
#include <vector>

int main() {
	using namespace std;

	vector<int> vect;

	for (int nCount = 0; nCount < 6; ++nCount)
		vect.push_back(nCount);

	vector<int>::const_iterator it; // declare a read-only iterator
	it = vect.begin(); // assign it to the start of the vector
	while (it != vect.end()) { // while it hasn't reached the end
		cout << *it << " "; // print the value of the element it points to
		++it; // and iterate to the next element
	}

	cout << '\n';

	return 0;
}