#include <iostream>
#include <array>

void printLength(const std::array<double, 5> &myArray) {
    std::cout << "length: " << myArray.size();
}

int main() {
    std::array<double, 5> myArray = { 9.0, 7.2, 5.4, 3.6, 1.8 };

    printLength(myArray);

    return 0;
}