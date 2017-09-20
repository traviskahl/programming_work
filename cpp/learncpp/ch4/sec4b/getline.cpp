#include <iostream>
#include <string>

int main() {
    std::cout << "Enter your full name: ";
    std::string name;
    std::getline(std::cin, name);

    std::cout << "Enter your age: ";
    std::string age;
    std::getline(std::cin, age);

    std::cout << "Your name is " << name << " and your age is " << age << '\n';
}