/*
5. Write a program in C to count the total number of words in a string. Go to the editor

Test Data :
Input the string : This is w3resource.com

Expected Output :

Total number of words in the string is : 3 
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	printf("Input the string : ");
	char string[BUFFER_SIZE];
	fgets(string, BUFFER_SIZE, stdin);

	// get the number of spaces, and therefore words
	// we'll always have one more word than spaces
	int num_words = 1;
	char* cur_char = string;
	while (*cur_char != '\n' && *cur_char != '\0') {
		if (*cur_char == ' ')
			num_words++;
		cur_char++;
	}

	printf("Total number of words in the string is : %d\n", num_words);

	return 0;
}