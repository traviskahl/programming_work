#include "ArrayList.hpp"

int main() {
	int array[] = { 0, 1, 2, 3, 4 };
	ArrayList<int> list(array, sizeof(array)/sizeof(array[0]));

	std::cout << "before pushing: " << list;
	std::cout << "seen of: " << list.getSeen() << '\n';
	std::cout << "length of: " << list.getLength() << '\n';

	for (int num = 5; num <= 10; ++num)
		list.push(num);

	std::cout << "after pushing: " << list;
	std::cout << "seen of: " << list.getSeen() << '\n';
	std::cout << "length of: " << list.getLength() << '\n';

	list[5] = 99;

	std::cout << list;

	return 0;
}