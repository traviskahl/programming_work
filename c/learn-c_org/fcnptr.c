#include <stdio.h>

void f1(int var) {
	printf("this is f1 and var is: %d\n", var);
}

void f2(int var) {
	printf("this is f2 and var is: %d\n", var);
}

void f3(int var) {
	printf("this is f3 and var is: %d\n", var);
}

int main() {
	// define an array of function pointers to the above functions
	// that take an int as their only argument
	void (*fcnArray)(int)[] = { &f1, &f2, &f3 };

	int c = 0;
	while (c < 3) {
		
	}
}