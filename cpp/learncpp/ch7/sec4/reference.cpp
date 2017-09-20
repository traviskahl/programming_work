#include <iostream>

// tempPtr is now a reference to a pointer, so any changes made made to tempPtr will change the argument as well!
void setToNull(int *&tempPtr) {
    tempPtr = nullptr;
}

int main() {
    // first we set ptr to the address of 5, which means *ptr = 5
    int five = 5;
    int *ptr = &five;

    // this will print 5
    std::cout << *ptr;

    // tempPtr is set as a reference to ptr
    setToNull(ptr);

    // ptr has now been changed to nullptr!

    if (ptr)
        std::cout << *ptr;
    else
        std::cout << "ptr is null";

    std::cout << '\n';
    return 0;
}