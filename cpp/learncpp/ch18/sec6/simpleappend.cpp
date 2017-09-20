#include <cstdlib> // for exit()
#include <iostream>
#include <fstream>

int main() {
	using namespace std;

	// We'll pass the ios::app flag to tell ofstream to append
	// rather than rewrite the file. We do not need to pass ios::out
	// because ofstream defaults to it
	ofstream outf("Sample.dat", ios::app);

	// If we couldn't open the output file stream for writing
	if (!outf) {
		// Print an error and exit
		cerr << "Uh oh, Sample.dat could not be opened for writing!" << endl;
		exit(1);
	}

	outf << "This is line 3" << endl;
	outf << "This is line 4" << endl;

	return 0;

	// When outf goes out of scope, the ofstream
	// destructor will close the file
}