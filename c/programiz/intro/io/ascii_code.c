#include <stdio.h>

int main() {
	char chr;
	printf("Enter a character: ");
	scanf("%c", &chr);

	// When %c text format is used, character is displayed in case of character types
	printf("You entered %c\n", chr);

	// when %d text format is used, integer is displayed in case of character types
	printf("ASCII value of %c is %d", chr, chr);

	return 0;
}
