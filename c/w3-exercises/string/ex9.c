/*
9. Write a program in C to count total number of vowel or consonant in a string. Go to the editor

Test Data :
Input the string : Welcome to w3resource.com

Expected Output :

The total number of vowel in the string is : 9 
The total number of consonant in the string is : 12 
*/

#include <stdio.h>
#include <ctype.h>

#define BUF_SIZE 50

int main() {
	printf("Input the string : ");
	char string[BUF_SIZE];
	fgets(string, BUF_SIZE, stdin);

	// find the number of vowels and consonants
	// ----------------------------------------
	int num_vowel = 0;
	int num_consonant = 0;

	char* cur_char = string;
	while (*cur_char != '\0') {
		// only do if it's alpha
		if (isalpha(*cur_char)) {
			switch(*cur_char) {
				case 'a': case 'A': case 'e': case 'E': case 'i': case 'I': case 'o': case 'O': case 'u': case 'U':
					++num_vowel;
					break;
				default:
					++num_consonant;
					break;
			}
		}
		++cur_char;
	}

	printf("The total number of vowel in the string is : %d\n", num_vowel);
	printf("The total number of consonant in the string is : %d\n", num_consonant);

	return 0;
}