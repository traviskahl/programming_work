#include <iostream>
#include <string>

enum class Type {
    TYPE_OGRE,
    TYPE_DRAGON,
    TYPE_ORC,
    TYPE_SPIDER,
    TYPE_GIANTSPIDER,
    TYPE_SLIME
};

struct Monster {
    Type type;
    std::string name;
    int health;
};

void printMonster(Monster mon) {
    std::string monsterType;
    if (mon.type == Type::TYPE_OGRE)
        monsterType = "Ogre";
    else if (mon.type == Type::TYPE_DRAGON)
        monsterType = "Dragon";
    else if (mon.type == Type::TYPE_ORC) 
        monsterType = "Orc";
    else if (mon.type == Type::TYPE_SPIDER)
        monsterType = "Spider";
    else if (mon.type == Type::TYPE_GIANTSPIDER)
        monsterType = "Giant Spider";
    else if (mon.type == Type::TYPE_SLIME)
        monsterType = "Slime";
    else
        monsterType = "Unknown";

    std::cout << "This " << monsterType << " is named " << mon.name << " and has " << mon.health << " health.\n";
}

int main() {
    Monster torg = {Type::TYPE_OGRE, "Torg", 145};
    printMonster(torg);

    Monster blurp = {Type::TYPE_SLIME, "Blurp", 23};
    printMonster(blurp);

    return 0;
}