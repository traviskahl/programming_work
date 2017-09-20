#ifndef CREATURE_H
#define CREATURE_H

#include <iostream>

class Creature {
protected:
    std::string m_name;
    char m_symbol;
    int m_health;
    int m_damagePerAttack;
    int m_goldCarried;

public:
    Creature(std::string name, char symbol, int health, int damage, int gold)
        : m_name { name }, m_symbol { symbol }, m_health { health },
          m_damagePerAttack { damage }, m_goldCarried { gold }
    {
    }

    const std::string& getName() const { return m_name; }
    char getSymbol() const { return m_symbol; }
    int getHealth() const { return m_health; }
    int getDamage() const { return m_damagePerAttack; }
    int getGold() const { return m_goldCarried; }

    void reduceHealth(int dealt) { m_health -= dealt; }
    bool isDead() { return m_health <= 0; }
    void addGold(int value) { m_goldCarried += value; }
};

#endif