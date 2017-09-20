#include <iostream>

void printArray(const char *str) {
    while (*str != '\0') {
        std::cout << *str << ' ';
        str++;
    }

    std::cout << '\n';
}

int main() {
    printArray("Hello, world!");
    
    return 0;
}