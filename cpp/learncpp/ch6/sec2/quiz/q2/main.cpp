#include <iostream>

namespace Animals {
    enum Animal {
        CHICKEN,
        DOG,
        CAT,
        ELEPHANT,
        DUCK,
        SNAKE,
        MAX_ANIMALS
    };
}

int main() {
    int numberLegs[Animals::MAX_ANIMALS] = {2, 4, 4, 4, 2, 0};
    std::cout << "An elephant has " << numberLegs[Animals::ELEPHANT] << " legs.\n";

    return 0;
}