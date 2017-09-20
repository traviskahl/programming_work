#include <string>
#include "Player.h"
#include "Monster.h"

void attackMonster(Monster &mon, Player &p);
void attackPlayer(Monster &mon, Player &p);

// this method returns true if the player wins, false if they flee or die
bool fightMonster(Monster &mon, Player &p) {
    while (!(p.isDead()) && (!(mon.isDead()))) {
        std::cout << "You have " << p.getHealth() << " health left.\n";
        std::cout << "The " << mon.getName() << " has " << mon.getHealth() << " health left.\n";
        std::cout << "(R)un or (F)ight: ";
        char choice;
        std::cin >> choice;

        if (choice == 'r' || choice == 'R') {
            bool didRun = static_cast<bool>(Monster::getRandomNumber(0, 1)); // if it rolls a 0, you can't escape, rolling 1 lets you run
            if (didRun) {
                std::cout << "You successfully fled.\n";
                return false;
            }
            else {
                std::cout << "You failed to flee.\n";
                attackPlayer(mon, p);
            }
        }
        else {
            attackMonster(mon, p);
            if (mon.getHealth() > 0) {
                attackPlayer(mon, p);
            }
            else {
                return true;
            }
        }
    }
}

void attackMonster(Monster &mon, Player &p) {
    mon.reduceHealth(p.getDamage());
    std::cout << "You hit the " << mon.getName() << " for " << p.getDamage() << " damage.\n";
}

void attackPlayer(Monster &mon, Player &p) {
    p.reduceHealth(mon.getDamage());
    std::cout << "The " << mon.getName() << " hit you for " << mon.getDamage() << " damage.\n";
}

int main() {
    srand(static_cast<unsigned int>(time(0)));
    rand(); // throw away the first result, it is sometimes unreliable
    Player p;

    do {
        Monster mon(Monster::getRandomMonster());

        std::cout << "You have encountered a " << mon.getName() << " (" << mon.getSymbol() << ").\n";
        if (fightMonster(mon, p)) {
            p.levelUp();
            std::cout << "You are now level " << p.getLevel() << ".\n";
            p.reduceHealth(-1); // this heals the user by 1 hp every time they defeat an enemy
            std::cout << "You found " << mon.getGold() << " gold.\n";
            p.addGold(mon.getGold());
        }
        std::cout << '\n';
    } while (!(p.hasWon()) && !(p.isDead()));
    
    if (p.hasWon()) {
        std::cout << "You won the game with " << p.getGold() << " gold.\n";
    }
    else {
        std::cout << "You died at level " << p.getLevel() << " and with " << p.getGold() << " gold.\n";
        std::cout << "Too bad you can't take it with you!\n";
    }

    return 0;
}