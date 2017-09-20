#include <iostream>

int main() {
    int length;
    std::cin >> length;
    int array[length]; // this shouldn't work

    for (int x = 0; x < length; x++) {
        std::cout << array[x] << '\n';
    }

    return 0;
}