#include <stdlib.h>

void f() {
	int* x = malloc(10 * sizeof(int));
	x[10] = 0;
	// problem 1: heap block overrun
	// problem 2: memory leak: x not freed
}

int main() {
	f();
	return 0;
}