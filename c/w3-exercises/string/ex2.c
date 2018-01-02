/*
2. Write a program in C to find the length of a string without using library function. Go to the editor

Test Data :
Input the string : w3resource.com

Expected Output :

Length of the string is : 15 
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	char string[BUFFER_SIZE];

	printf("Input the string : ");
	fgets(string, BUFFER_SIZE, stdin);

	// find the length
	int length = 0;
	char* cur_char = string;

	while (*cur_char != '\n' && *cur_char != '\0') {
		length++;
		cur_char++;
	}

	printf("Length of the string is : %d\n", length);
	return 0;
}