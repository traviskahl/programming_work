#include <iostream>
#include <string>

int main() {
    std::string names[] = { "Alex", "Betty", "Caroline", "Dave", "Emily", "Fred", "Greg", "Holly" };

    std::cout << "Enter a name: ";
    std::string enteredName;
    std::cin >> enteredName;

    bool isFound = false;
    for (const auto &name : names) {
        if (name == enteredName)
            isFound = true;
    }

    if (isFound)
        std::cout << enteredName << " was found.\n";
    else
        std::cout << enteredName << " was not round.\n";

    return 0;
}