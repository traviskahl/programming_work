/*
3. Write a program in C to separate the individual characters from a string. Go to the editor

Test Data :
Input the string : w3resource.com

Expected Output :

The characters of the string are : 
w  3  r  e  s  o  u  r  c  e  .  c  o  m 
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	char string[BUFFER_SIZE];

	printf("Input the string : ");
	fgets(string, BUFFER_SIZE, stdin);

	printf("The characters of the string are :\n");
	char* cur_char = string;

	while (*cur_char != '\0') {
		printf("%c  ", *cur_char);
		cur_char++;
	}

	return 0;
}