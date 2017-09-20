#include <iostream>

int main() {
    const int arrayLength = 9;
    int array[arrayLength] = { 4, 6, 7, 3, 8, 2, 1, 9, 5 };

    for (int x = 0; x < arrayLength; x++) {
        std::cout << array[x] << '\n';
    }

    return 0;
}