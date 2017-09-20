#include <iostream>

int factorial(int x) {
    if (x == 0)
        return 0;
    if (x == 1)
        return 1;
    else
        return x * factorial(x-1);
}

int main() {
    for (int x = 0; x < 11; x++) {
        std::cout << factorial(x) << ' ';
    }
    std::cout << '\n';
    return 0;
}