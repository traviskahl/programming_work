#include <memory> // for std::unique_ptr
#include <iostream>

class Resource {
public:
	Resource() { std::cout << "Resource acquired\n"; }
	~Resource() { std::cout << "Resource destroyed\n"; }
	friend std::ostream& operator<<(std::ostream &out, const Resource &res) {
		out << "I am a resource\n";
		return out;
	}
};

void takeOwnership(std::unique_ptr<Resource> res) {
	if (res)
		std::cout << *res;
} // the Resource is destroyed here

int main() {
	auto ptr = std::make_unique<Resource>();

	//takeOwnership(ptr) // this won't work, need to use move semantics
	takeOwnership(std::move(ptr)); // ok: use move semantics

	std::cout << "Ending program\n";

	return 0;
}