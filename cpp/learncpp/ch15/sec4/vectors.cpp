#include <iostream>
#include <string>
#include <utility>
#include <vector>

int main() {
	std::vector<std::string> v;
	std::string str = "Knock";

	std::cout << "Copying str\n";
	v.push_back(str); // calls l-value version of push_back, which makes a copy

	std::cout << "str: " << str << '\n';
	std::cout << "vector: " << v[0] << '\n';

	std::cout << "\nMoving str\n";

	v.push_back(std::move(str)); // calls r-value version of push_back, which does a move

	std::cout << "str: " << str << '\n';
	std::cout << "vector: " << v[0] << ' ' << v[1] << '\n';

	return 0;
}