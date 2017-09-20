#include <iostream>

int main() {
    char string[20] = "hi";
    string[2] = 'k';

    for (int index = 0; index < sizeof(string); index++) {
        std::cout << static_cast<int>(string[index]) << " ";
    }

    return 0;
}