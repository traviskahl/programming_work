#include <iostream>

int main() {
    const int arrayLength = 9;
    int array[arrayLength] = { 4, 6, 7, 3, 8, 2, 1, 9, 5 };

    // get the input from the user
    int input;
    while (true) {
        std::cout << "Enter a number between 1 and 9: ";
        std::cin >> input;

        if (std::cin.fail()) {
            std::cin.clear();
            std::cin.ignore(32767, '\n');
        }

        if (input > 1 && input < 9) {
            break;
        }
        else {
            continue;
        }
    }

    // print the array
    std::cout << "The array is:\n";
    for (int x = 0; x < arrayLength; x++) {
        std::cout << array[x] << " ";
    }
    std::cout << '\n';

    // find the number
    for (int x = 0; x < arrayLength; x++) {
        if (array[x] == input) {
            std::cout << "The number you entered was found at index " << x << '\n';
            break;
        }
    }
}