#include <stdio.h>

int main() {
	int intarray[5] = { 10, 20, 30, 40, 50 };
	// -------------------------^^
	int* pointer = &intarray[2];

	for (int x = 0; x < 3; ++x)
		printf("%x\n", pointer++);

	return 0;
}