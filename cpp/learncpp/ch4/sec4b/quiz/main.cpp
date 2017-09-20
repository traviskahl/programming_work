#include <iostream>
#include <string>

std::string getName() {
    std::cout << "Enter your full name: ";
    std::string name;
    std::getline(std::cin, name);
    return name;
}

int getAge() {
    std::cout << "Enter your age: ";
    int age;
    std::cin >> age;
    return age;
}

double calculateYearsLived(std::string name, int age) {
    int length = name.length();
    double yearsLived = static_cast<double>(age) / length;
    return yearsLived;
}

int main() {
    std::string name = getName();
    int age = getAge();
    double yearsLived = calculateYearsLived(name, age);

    std::cout << "You've lived " << yearsLived << " years for every letter in your name.\n";

    return 0;
}