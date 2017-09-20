#include <iostream>
#include <vector>

int main() {
    std::vector<int> array = { 0, 1, 2 };
    array.resize(5); // set size to 5

    std::cout << "The length is: " << array.size() << '\n';

    for (auto const &element : array)
        std::cout << element << ' ';

    std::cout << '\n';

    return 0;
}