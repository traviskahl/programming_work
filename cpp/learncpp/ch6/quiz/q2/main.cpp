#include <iostream>
#include <string>
#include <utility> // for std::swap

struct Student {
    std::string name;
    int score;
};

void getStudents(Student *students, int numStudents) {
    for (int x = 0; x < numStudents; x++) {
        std::cout << "Enter name #" << x+1 << ": ";
        std::string currentName;
        std::cin >> currentName;

        std::cout << "Enter the score for " << currentName << ": ";
        int currentScore;
        std::cin >> currentScore;

        students[x] = { currentName, currentScore };
    }
}

void sortStudents(Student *students, int numStudents) {
    for (int pass = 1; pass <= numStudents; pass++) {
        for (int currentIndex = 0; currentIndex < numStudents - 1; currentIndex++) {
            if (students[currentIndex].score < students[currentIndex+1].score) {
                std::swap(students[currentIndex], students[currentIndex+1]);
            }
        }
    }
}

void printStudents(Student *students, int numStudents) {
    for (int x = 0; x < numStudents; x++) {
        std::cout << students[x].name << " got a grade of " << students[x].score << '\n';
    }
}

int main() {
    std::cout << "How many students do you want to enter? ";
    int numStudents;
    std::cin >> numStudents;
    Student *students = new Student[numStudents];

    getStudents(students, numStudents);
    sortStudents(students, numStudents);
    printStudents(students, numStudents);

    return 0;
}