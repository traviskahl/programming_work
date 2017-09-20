#include <iostream>
#include <string> // for this example
#include <exception> // for std::exception

int main() {
	try {
		// Your code using standard library goes here
		// We'll trigger one of these exceptions intentionally for the sake of example
		std::string s;
		s.resize(-1); // will trigger a std::bad_alloc
	}
	// This handler will catch std::exception and all the derived exceptions too
	catch (std::exception &exception) { 
		std::cerr << "Standard exception: " << exception.what() << '\n';
	}

	return 0;
}