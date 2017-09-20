#include <iostream>

int main() {
    int currentLetter = 'a';

    while (currentLetter <= 'z') {
        std::cout << "Letter:\t" << static_cast<char>(currentLetter);
        std::cout << "\tCode:\t" << currentLetter << '\n';

        currentLetter++;
    }

    return 0;
}