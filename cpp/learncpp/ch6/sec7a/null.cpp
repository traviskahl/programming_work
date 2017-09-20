#include <iostream>

void doSomething(int *ptr) {
    if (ptr)
        std::cout << "You passed in " << *ptr << '\n';
    else
        std::cout << "You passed a null pointer\n";
}

int main() {
    doSomething(nullptr); // the argument is definitely a null pointer, not 0

    return 0;
}