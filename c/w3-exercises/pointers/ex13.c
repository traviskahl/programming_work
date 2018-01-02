/*
13. Write a program in C to count the number of vowels and consonants in a string using a pointer. Go to the editor
Test Data :
Input a string: string
Expected Output :

Number of vowels : 1                                                                                         
Number of constant : 5
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	char string[BUFFER_SIZE];

	printf("Input a string: ");
	fgets(string, BUFFER_SIZE, stdin);

	int num_vowels = 0;
	int num_consonants = 0;
	char* cur_char = string;
	while (*cur_char != '\n' && *cur_char != '\0') {
		switch (*cur_char) {
			case 'a': case 'A': case 'e': case 'E': case 'i': case 'I': case 'o': case 'O': case 'u': case 'U':
				num_vowels++;
				break;
			default:
				num_consonants++;
				break;
		}
		++cur_char;
	}

	printf("Number of vowels : %d\n", num_vowels);
	printf("Number of consonants : %d\n", num_consonants);

	return 0;
}