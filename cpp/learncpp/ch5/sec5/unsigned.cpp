#include <iostream>

int main() {
    unsigned int count = 10;

    // count from 10 down to 0
    while (count >= 0) {
        if (count == 0)
            std::cout << "Blastoff!";
        else
            std::cout << count << '\n';
        --count;
    }

    return 0;
}