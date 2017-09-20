#include <iostream>
#include <string>
#include <vector>

struct StudentGrade {
	std::string m_name;
	char m_grade;
};

class GradeMap {
private:
	std::vector<StudentGrade> m_map;

public:
	GradeMap() {}

	char& operator[](std::string name);
};

char& GradeMap::operator[](std::string name) {
	// first iterate through vector to see if student exists
	for (StudentGrade& student : m_map) {
		// if the student exists, return a reference to the grade
		if (student.m_name == name)
			return student.m_grade;
	}

	// otherwise use std::vector.push_back() to add a StudentGrade for the new student
	StudentGrade temp;
	temp.m_name = name;
	m_map.push_back(temp);
	return m_map.back().m_grade;
}

int main() {
	GradeMap grades;
	grades["Joe"] = 'A';
	grades["Frank"] = 'B';
	std::cout << "Joe has a grade of " << grades["Joe"] << '\n';
	std::cout << "Frank has a grade of " << grades["Frank"] << '\n';
 
	return 0;
}