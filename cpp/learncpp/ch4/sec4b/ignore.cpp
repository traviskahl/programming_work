#include <iostream>
#include <string>

int main() {
    std::cout << "Enter 1 or 2: ";
    int choice;
    std::cin >> choice;

    std::cin.ignore(32767, '\n');

    std::cout << "Now enter your name: ";
    std::string name;
    std::getline(std::cin, name);

    std::cout << "Hello, " << name << ", you picked " << choice << '\n';

    return 0;
}