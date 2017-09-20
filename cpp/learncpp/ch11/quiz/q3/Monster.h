#ifndef MONSTER_H
#define MONSTER_H

#include <cstdlib> // for rand() and srand()

#include "Creature.h"

class Monster : public Creature {
private:
    struct MonsterData {
        std::string name;
        char symbol;
        int health;
        int damage;
        int gold;
    };

    static MonsterData monsterData[];

public:
    enum Type {
        DRAGON,
        ORC,
        SLIME,
        MAX_TYPES
    };

    Monster(Type type)
        : Creature(monsterData[type].name, monsterData[type].symbol, monsterData[type].health,
          monsterData[type].damage, monsterData[type].gold)
    {
    }

    static int getRandomNumber(int min, int max) {
        static const double fraction = 1.0 / (static_cast<double>(RAND_MAX) + 1.0);
        return static_cast<int>(rand() * fraction * (max - min + 1) + min);
    }

    static Monster getRandomMonster() {
        return Monster(static_cast<Type>(getRandomNumber(0, MAX_TYPES-1)));
    }
};

Monster::MonsterData Monster::monsterData[Monster::MAX_TYPES]
{
	{ "dragon", 'D', 20, 4, 100 },
	{ "orc", 'o', 4, 2, 25 },
	{ "slime", 's', 1, 1, 10 }
};

#endif