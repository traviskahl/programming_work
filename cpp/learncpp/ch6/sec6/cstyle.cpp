#include <iostream>

int main() {
    char myString[] = "string";
    std::cout << myString << " has " << sizeof(myString) << " characters.\n";
    for (int index = 0; index < sizeof(myString); index++) {
        std::cout << static_cast<int>(myString[index]) << " ";
    }

    return 0;
}