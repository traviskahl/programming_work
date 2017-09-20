#include <iostream>

class Person {
private:
    std::string m_name;
    int m_age;

public:
    Person(std::string name="", int age=0) :
        m_name { name }, m_age { age }
    {
    }

    std::string getName() const { return m_name; }
    int getAge() const { return m_age; }
};

class BaseballPlayer : public Person {
private:
    double m_battingAverage;
    int m_homeRuns;

public:
    BaseballPlayer(std::string name="", int age=0,
                    double battingAverage=0.0, int homeRuns=0) :
                    Person(name, age), m_battingAverage { battingAverage },
                    m_homeRuns { homeRuns }
    {
    }

    double getBattingAverage() const { return m_battingAverage; }
    int getHomeRuns() const { return m_homeRuns; }
};

int main() {
    BaseballPlayer pedro("Pedro Cerrano", 32, 0.342, 42);

    std::cout << pedro.getName() << '\n';
    std::cout << pedro.getAge() << '\n';
    std::cout << pedro.getHomeRuns() << '\n';

    return 0;
}