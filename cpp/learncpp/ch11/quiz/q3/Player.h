#ifndef PLAYER_H
#define PLAYER_H

#include "Creature.h"

std::string getNameInput() {
    std::cout << "Enter your name: ";
    std::string name;
    std::cin >> name;
    std::cout << "Welcome, " << name << ".\n";
    return name;
}

class Player : public Creature {
protected:
    int m_level;

public:

    Player(std::string name=getNameInput(), char symbol='@', int hp=10, int dmg=1, int gold=0)
        : Creature(name, symbol, hp, dmg, gold), m_level { 1 }
    {
    }

    void levelUp() {
        ++m_level;
        ++m_damagePerAttack;
    }

    int getLevel() { return m_level; }
    bool hasWon() { return m_level == 20; }
};

#endif