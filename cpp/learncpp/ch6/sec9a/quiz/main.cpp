#include <iostream>
#include <utility> // for std::swap

int getNumNames() {
    std::cout << "How many names would you like to enter? ";
    int length;
    std::cin >> length;
    return length;
}

void sortNames(std::string *array, int length) {
    for (int startIndex = 0; startIndex < length - 1; startIndex++) {
        int smallestIndex = startIndex;
        for (int currentIndex = startIndex + 1; currentIndex < length; currentIndex++) {
            if (array[currentIndex] < array[smallestIndex]) {
                smallestIndex = currentIndex;
            }
        }
        std::swap(array[startIndex], array[smallestIndex]);
    }
}

void printNames(std::string *names, int length) {
    std::cout << "\nHere is your sorted list:\n";
    for (int x = 0; x < length; x++) {
        std::cout << "Name " << x+1 << ": " << *(names+x) << '\n';
    }
}

int main() {
    int length = getNumNames();
    std::string *names = new std::string[length];
    for (int x = 0; x < length; x++) {
        std::cout << "Enter name #" << x+1 << ": ";
        std::cin >> names[x]; 
    }
    sortNames(names, length);
    printNames(names, length);

    delete[] names;
    names = nullptr;

    return 0;
}