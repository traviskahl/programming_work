/*
4. Write a program in C to print individual characters of string in reverse order. Go to the editor

Test Data :
Input the string : w3resource.com

Expected Output :

The characters of the string in reverse are :
m  o  c  .  e  c  r  u  o  s  e  r  3  w 
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	printf("Input the string : ");
	char string[BUFFER_SIZE];
	fgets(string, BUFFER_SIZE, stdin);

	// we should get the length of the string
	int length = 0;
	char* cur_char = string;
	while (*cur_char != '\n' && *cur_char != '\0') {
		length++;
		cur_char++;
	}

	printf("The characters of the string in reverse are :\n");
	for (int x = length - 1; x >= 0; --x) {
		printf("%c  ", string[x]);
	}

	printf("\n");
	return 0;
}