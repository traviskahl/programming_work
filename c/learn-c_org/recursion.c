#include <stdio.h>

int factorial(int n);

int main() {
	printf("1! = %i\n", factorial(1));
	printf("3! = %i\n", factorial(3));
	printf("5! = %i\n", factorial(5));

	return 0;
}

int factorial(int n) {
	if (n == 1)
		return 1;
	else
		return n * factorial(n - 1);
}