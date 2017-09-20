#include <iostream>
#include <array>
#include <algorithm>

int main() {
    std::array<int, 5> myArray { 7, 3, 1, 9, 5 };
    std::sort(myArray.begin(), myArray.end()); // sort the array forwards
    
    for (const auto &element : myArray)
        std::cout << element << ' ';

    std::cout << '\n';

    return 0;
}