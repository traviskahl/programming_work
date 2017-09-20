#include <iostream>
#include <cstdlib>
#include <ctime>

class Monster {
public:
    enum MonsterType {
        Dragon,
        Goblin,
        Ogre,
        Orc,
        Skeleton,
        Troll,
        Vampire,
        Zombie,
        MAX_MONSTER_TYPES
    };

    Monster(MonsterType type, std::string name, std::string roar, int hp) :
        m_type { type }, m_name { name }, m_roar { roar }, m_hitpoints { hp }
    {
    }

    std::string getTypeString() {
        switch(m_type) {
            case MonsterType::Dragon:       return "dragon";
            case MonsterType::Goblin:       return "goblin";
            case MonsterType::Ogre:         return "ogre";
            case MonsterType::Orc:          return "orc";
            case MonsterType::Skeleton:     return "skeleton";
            case MonsterType::Troll:        return "troll";
            case MonsterType::Vampire:      return "vampire";
            case MonsterType::Zombie:       return "zombie";
            default:                        return "undefined";
        }
    }

    void print() {
        std::cout << m_name << " the " << getTypeString() << " has " << m_hitpoints << " hp and says " << m_roar << '\n';
    }

private:
    MonsterType m_type;
    std::string m_name;
    std::string m_roar;
    int m_hitpoints;

};

class MonsterGenerator {
public:
    static int getRandomNumber(int min, int max) {
        static const double fraction = 1.0 / (static_cast<double>(RAND_MAX) + 1.0);
        return static_cast<int>(rand() * fraction * (max - min + 1) + min);
    }

    static Monster generateMonster() {
        static std::string s_names[6] = {"Kramer", "Elaine", "George", "Newman", "Jerry", "Susan"};
        static std::string s_roars[6] = {"roar", "thunk", "*rattle*", "myeah", "bleargh", "hello"};

        int typeAsInt = getRandomNumber(0, Monster::MAX_MONSTER_TYPES - 1);
        Monster::MonsterType type = static_cast<Monster::MonsterType>(typeAsInt);

        std::string name = s_names[getRandomNumber(0, 5)];
        std::string roar = s_roars[getRandomNumber(0, 5)];

        int hp = getRandomNumber(1, 100);
        return Monster(type, name, roar, hp);
    }
};

int main() {
    srand(static_cast<unsigned int>(time(0)));
    Monster m = MonsterGenerator::generateMonster();
    m.print();

    return 0;
}