#include <iostream>

enum class Animal {
    PIG,
    CHICKEN,
    GOAT,
    CAT,
    DOG,
    OSTRICH
};

std::string getAnimalName(Animal animal) {
    std::string ret;
    switch (animal) {
        case Animal::PIG:
            ret = "Pig";
            break;
        case Animal::CHICKEN:
            ret = "Chicken";
            break;
        case Animal::GOAT:
            ret = "Goat";
            break;
        case Animal::CAT:
            ret = "Cat";
            break;
        case Animal::DOG:
            ret = "Dog";
            break;
        case Animal::OSTRICH:
            ret = "Ostrich";
            break;
        default:
            ret = "Unknown";
    }
    return ret;
}

void printNumberOfLegs(Animal animal) {
    switch (animal) {
        case Animal::PIG:
            std::cout << "A pig has four legs.\n";
            break;
        case Animal::CHICKEN:
            std::cout << "A chicken has two legs.\n";
            break;
        case Animal::GOAT:
            std::cout << "A goat has four legs.\n";
            break;
        case Animal::CAT:
            std::cout << "A cat has four legs.\n";
            break;
        case Animal::DOG:
            std::cout << "A dog has four legs.\n";
            break;
        case Animal::OSTRICH:
            std::cout << "An ostrich has two legs.\n";
            break;
        default:
            std::cout << "I don't know what you passed.\n";
    }
}

int main() {
    printNumberOfLegs(Animal::CAT);
    printNumberOfLegs(Animal::CHICKEN);

    return 0;
}