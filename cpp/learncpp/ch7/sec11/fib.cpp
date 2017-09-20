#include <iostream>

int fibonacci(int number) {
    if (number == 0)
        return 0;
    if (number == 1)
        return 1;
    else
        return fibonacci(number-1) + fibonacci(number-2);
    
}

int main() {
    for (int count = 0; count < 13; count++) {
        std::cout << fibonacci(count) << ' ';
    }
    return 0;
}