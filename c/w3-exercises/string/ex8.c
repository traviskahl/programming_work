/*
8. Write a program in C to copy one string to another string. Go to the editor

Test Data :
Input the string : This is a string to be copied.

Expected Output :

The First string is : This is a string to be copied.
The Second string is : This is a string to be copied. 
Number of characters copied : 31 
*/

#include <stdio.h>
#include <stdlib.h>

#define BUF_SIZE 50

int main() {
	printf("Input the string : ");
	char input_string[BUF_SIZE];
	fgets(input_string, BUF_SIZE, stdin);

	// find the length of our entered string
	// -------------------------------------
	int length = 0; // we're interested in keeping the null terminator
	char* cur_char = input_string;
	while (1) {
		if (*cur_char == '\0')
			break;
		++length;
		++cur_char;
	}

	// do our deep copy
	// ----------------
	char* copied_string = (char*) malloc(length * sizeof(char));
	for (int i = 0; i < length; ++i) {
		copied_string[i] = input_string[i];
	}

	printf("The First string is : ");
	puts(input_string);
	printf("The Second string is : ");
	puts(copied_string);
	printf("Number of characters copied : %d\n", length);

	free(copied_string);
	return 0;
}