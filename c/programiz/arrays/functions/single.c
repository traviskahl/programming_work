#include <stdio.h>

void display(int age) {
	printf("%d", age);
}

int main() {
	int ageArray[] = { 2, 3, 4 };
	display(ageArray[2]); // passing array element ageArray[2] only
	return 0;
}