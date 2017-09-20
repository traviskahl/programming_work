#include <iostream>

void setToNull(int *tempPtr) {
    // we're making tempPtr point at something else, not changing the value that tempPtr points to.
    tempPtr = nullptr;
}

int main() {
    // First we set ptr to the address of 5, which means *ptr = 5
    int five = 5;
    int *ptr = &five;

    // This will print 5
    std::cout << *ptr;

    // tempPtr will receive a copy of ptr
    setToNull(ptr);

    // ptr is still set to the address of five!

    // this will print 5
    if (ptr)
        std::cout << *ptr;
    else
        std::cout << "ptr is null";

    return 0;
}