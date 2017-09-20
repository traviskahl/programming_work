#include <iostream>
#include <vector>

int main() {
    std::vector<int> fibonacci = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
    for (const auto &number : fibonacci)
        std::cout << number << ' ';

    std::cout << '\n';
    return 0;
}