#include <iostream>

struct Person {
    int age;
    double weight;
};

int main() {
    Person person;
    Person *ptr = &person;
    ptr->age = 5;

    std::cout << ptr->age << '\n';

    return 0;
}