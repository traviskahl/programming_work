#include <stdio.h>

union ints {
	int ints[6];
	char chars[21];
};

int main() {
	// initializer lists like this are assigned to the first member of the union/struct!
	// there are 6 ints here so...
	union ints intCharacters = {{1853169737, 1936876900, 1684955508, 1768838432, 561213039, 0}};

	// testing code
	printf("[");
	// only go to 18 because 1 bytes is for the terminating 0
	for (int i = 0; i < 19; ++i)
		printf("%c, ", intCharacters.chars[i]);
	printf("%i]\n", intCharacters.chars[19]);

	printf("%s\n", intCharacters.chars);
}