#include <iostream>
#include <memory> // for std::unique_ptr

class Resource {
public:
	Resource() { std::cout << "Resource acquired\n"; }
	~Resource() { std::cout << "Resource destroyed\n"; }

	friend std::ostream& operator<<(std::ostream &out, const Resource &res) {
		out << "I am a resource\n";
		return out;
	}
};

void useResource(const std::unique_ptr<Resource> &res) {
	if (res)
		std::cout << *res;
}

int main() {
	auto ptr = std::make_unique<Resource>();

	useResource(ptr);

	std::cout << "Ending program\n";

	return 0;
} // the Resource is destroyed here