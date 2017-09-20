#include <iostream>

int main() {
    std::cout << "Enter a positive integer: ";
    int length;
    std::cin >> length;

    int *array = new int[length]; // use array new. Note that length does not need to be constant!

    std::cout << "I just allocated an array of integers of length " << length << '\n';

    array[0] = 5; // set element 0 to 5

    delete[] array; // use array delete to deallocate array
    array = nullptr; // get rid of dangling pointer

    return 0;
}