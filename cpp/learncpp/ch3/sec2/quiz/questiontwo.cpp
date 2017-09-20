#include <iostream>

bool isEven(int num) {
    bool ret = false;
    if (num % 2 == 0) {
        ret = true;
    }
    return ret;
}

int getNumber() {
    std::cout << "Enter an integer: ";
    int input;
    std::cin >> input;
    return input;
}

int main() {
    int number = getNumber();
    if (isEven(number)) {
        std::cout << "The number is even\n";
    }
    else {
        std::cout << "The number is not even\n";
    }

    return 0;
}